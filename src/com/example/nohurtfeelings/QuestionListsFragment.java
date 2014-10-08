package com.example.nohurtfeelings;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class QuestionListsFragment extends Fragment {
	ArrayList<String> qLists;
	private Button selected;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View questionListsView = inflater.inflate(R.layout.fragment_question_lists, container, false);
		qLists = new ArrayList<String>();
		qLists.add("Adult Games");
		qLists.add("Kiddie Games");
		qLists.add("Teen Games");
		qLists.add("Allison Games");
		qLists.add("Sexual Games");
		qLists.add("College Games");
		qLists.add("Future Games");
		setUpLists(questionListsView);
		setUpButtons(questionListsView);
		return questionListsView;
	}

	/*
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question_lists);
		qLists = new ArrayList<String>();
		qLists.add("Adult Games");
		qLists.add("Kiddie Games");
		qLists.add("Teen Games");
		qLists.add("Allison Games");
		qLists.add("Sexual Games");
		qLists.add("College Games");
		qLists.add("Future Games");
		setUpLists();

	}
	 */

	private void setUpLists(View curView) {
		View currentView = curView;
		LinearLayout qListLayout = (LinearLayout) currentView.findViewById(R.id.questionLists_LinearLayout);
		String name;
		for (int x = 0; x < qLists.size(); x++) {
			name = qLists.get(x);
			Button list1 = setUpButton(name, curView);
			qListLayout.addView(list1);
		}

	}

	private Button setUpButton(final String name, View curView) {
		final Button listButton = new Button(curView.getContext());
		listButton.setText(name);
		listButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//start new fragment.
				//selected = listButton;
				Bundle infoToPass = new Bundle();
				infoToPass.putString("qListName", (String)listButton.getText());
				Fragment qListFragment = new QuestionListFragment();
				qListFragment.setArguments(infoToPass);
				getFragmentManager()
				    .beginTransaction()
				    .replace(R.id.fragment_content, qListFragment)
				    .addToBackStack("newFragReplacement").commit();			
				//updateSelectedList(listButton);
			}

		});
		return listButton;
	}

	private void updateSelectedList(Button pressed) {
		// change old selection back to normal color
		if (selected != null) {
			selected.getBackground().setColorFilter(Color.LTGRAY,
					PorterDuff.Mode.MULTIPLY);
		}
		selected = pressed;
		selected.getBackground().setColorFilter(Color.RED,
				PorterDuff.Mode.SRC_ATOP);
	}

	/*
	public void back(View view) {
		Intent intent = new Intent(view.getContext(), AccountOptions.class);
		startActivity(intent);
	}
	*/
	public void setUpButtons(View view){
		//setup the addlistbutton
		Button addButton = (Button) view.findViewById(R.id.add_List_Button);
		addButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
				alert.setTitle("Choose a Name");
				final EditText input = new EditText(view.getContext());
				alert.setView(input);
				alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						Editable value = input.getText();
						LinearLayout qListLayout = (LinearLayout) getView().findViewById(R.id.questionLists_LinearLayout);
						qLists.add(value.toString()); //adds to arraylist !!will be server in future

						Button addedList = setUpButton(value.toString(), getView()); 
						qListLayout.addView(addedList); //adds to view
					}
				});

				alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// Canceled.
					}
				});

				alert.show();		
			}

		});

		
		

		//set up editQuestionList button
		//this should start the new fragment
		Button editButton = (Button) view.findViewById(R.id.edit_List_Button);
		editButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				
				
				
					//Bundle infoToPass = new Bundle();
					//infoToPass.putString("qListName", (String)selected.getText());
					
					//Intent intent_EQL = new Intent(getView().getContext(), EditQuestionList.class);
					//intent_EQL.putExtras(infoToPass);
					//startActivity(intent_EQL);					
				
			}

		});
		

		//setup deletelist button 
		Button deleteButton = (Button) view.findViewById(R.id.delete_List_Button);
		deleteButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				//uses on the fly creation

				//creates a dialog box to prompt user for acceptance.
				if(selected != null){
					new AlertDialog.Builder(getView().getContext())
					.setTitle("Delete List")
					.setMessage("Are you sure you want to delete this list?")
					.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
						//Deletes list upon acceptance
						public void onClick(DialogInterface dialog, int which) { 
							LinearLayout qListLayout = (LinearLayout) getView().findViewById(R.id.questionLists_LinearLayout);
							qListLayout.removeView(selected); //removes from view
							qLists.remove(selected); //removes from list !!WILL BE SERVER IN FUTURE
							selected=null;
						}
					})
					.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) { 
							// do nothing
						}
					})
					.setIcon(android.R.drawable.ic_dialog_alert)
					.show();
				}

			}

		});

	}

	/*
	public void addQuestionList(View view) {

		//uses defined creation

		AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
		alert.setTitle("Choose a Name");
		final EditText input = new EditText(view.getContext());
		alert.setView(input);
		alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				Editable value = input.getText();
				LinearLayout qListLayout = (LinearLayout) getView().findViewById(R.id.questionLists_LinearLayout);
				qLists.add(value.toString()); //adds to arraylist !!will be server in future

				Button addedList = setUpButton(value.toString(), getView()); 
				qListLayout.addView(addedList); //adds to view
			}
		});

		alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				// Canceled.
			}
		});

		alert.show();


		// 1) take in new name of list to be created
		// 2) add name to array list
		// 3) sync with server/set preset questions
		// 4) add button to list

		// currently just adds to the array list/puts it in the scroll view
		// doesn't prompt for name
		// CHOICE: new activity/pop up, how much data needs to be gathererd.

		// only works temporarily at the moment, not saved in any meaningful
		// place
	}
	 

	public void editQuestionList(View view) {
		// bring user to activity to edit Qlist, pass by bundle the needed info
		//will only work if something is selected
		if(selected != null){
			Bundle infoToPass = new Bundle();
			infoToPass.putString("qListName", (String)selected.getText());
			Intent intent_EQL = new Intent(getView().getContext(), EditQuestionList.class);
			intent_EQL.putExtras(infoToPass);
			startActivity(intent_EQL);
		}
	}

	public void deleteQuestionList(View view) {

		//uses on the fly creation

		//creates a dialog box to prompt user for acceptance.
		if(selected != null){
			new AlertDialog.Builder(getView().getContext())
			.setTitle("Delete List")
			.setMessage("Are you sure you want to delete this list?")
			.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
				//Deletes list upon acceptance
				public void onClick(DialogInterface dialog, int which) { 
					LinearLayout qListLayout = (LinearLayout) getView().findViewById(R.id.questionLists_LinearLayout);
					qListLayout.removeView(selected); //removes from view
					qLists.remove(selected); //removes from list !!WILL BE SERVER IN FUTURE
					selected=null;
				}
			})
			.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) { 
					// do nothing
				}
			})
			.setIcon(android.R.drawable.ic_dialog_alert)
			.show();
		}

	}
	*/

}
