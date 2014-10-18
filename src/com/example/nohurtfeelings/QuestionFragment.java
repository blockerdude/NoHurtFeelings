package com.example.nohurtfeelings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class QuestionFragment extends Fragment {
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View questionListsView = inflater.inflate(R.layout.fragment_question, container, false);
		
		Bundle args = getArguments();
		String name = args.getString("questionName");
		TextView tv = (TextView) questionListsView.findViewById(R.id.selected_question_TextView);
		if(name != null){
			tv.setText(name);
		}
		else{
			tv.setText("Didn't work!");
		}
		
		return questionListsView;
	}

}
