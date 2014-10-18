package com.example.nohurtfeelings;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QuestionListFragment extends Fragment {
	ArrayList<String> qLists;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View questionListView = inflater.inflate(R.layout.fragment_question_lists, container, false);
		qLists = new ArrayList<String>();
		Bundle args = getArguments();
		String name = args.getString("qListName");
		TextView tv = (TextView) questionListView.findViewById(R.id.introdution_TextView);
		if(name!=null)
			tv.setText(name);
		else
			tv.setText("Didn't work");
		
		qLists.add("Question 0");
		qLists.add("MLT do drugs");
		qLists.add("Who got the highest ACT score");
		qLists.add("Most likely to die first");
		qLists.add("MLT forget someone");
		qLists.add("MLT cheat on someone");
		qLists.add("MLT win the lottery");
		setUpLists(questionListView);
		return questionListView;
	}
	
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
				infoToPass.putString("questionName", (String)listButton.getText());
				Fragment questionFragment = new QuestionFragment();
				questionFragment.setArguments(infoToPass);
				getFragmentManager()
				    .beginTransaction()
				    .replace(R.id.fragment_content, questionFragment)
				    .addToBackStack("newFragReplacement").commit();			
				//updateSelectedList(listButton);
			}

		});
		return listButton;
	}
	
}
