package com.example.nohurtfeelings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class QuestionListFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View questionListView = inflater.inflate(R.layout.fragment_question_list, container, false);
		Bundle args = getArguments();
		String name = args.getString("qListName");
		TextView tv = (TextView) questionListView.findViewById(R.id.frag_test_TextView);
		if(name!=null)
			tv.setText(name);
		else
			tv.setText("Didn't work");
		return questionListView;
	}
}
