package com.example.nohurtfeelings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

public class QuestionListActivity extends FragmentActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_base_question_lists);
		FragmentManager fm = getSupportFragmentManager();
		Fragment questionListsFragment = fm.findFragmentById(R.id.fragment_content);
		if(questionListsFragment == null){
			FragmentTransaction ft = fm.beginTransaction();
			ft.add(R.id.fragment_content, new QuestionListsFragment());
			try{
			ft.commit();
			}catch(Exception e){
				e.printStackTrace();
			};
		}
	}
	public void clickedQList(View view){
		setContentView(R.layout.fragment_question_list);
		FragmentManager fm = getSupportFragmentManager();
		Fragment questionListFragment = fm.findFragmentById(R.id.fragment_content);
		if(questionListFragment == null){
			FragmentTransaction ft = fm.beginTransaction();
			ft.add(R.id.fragment_content, new QuestionListFragment());
			try{
			ft.commit();
			}catch(Exception e){
				e.printStackTrace();
			};
		}
	}
	public void back(View view) {
		Intent intent = new Intent(view.getContext(), AccountOptions.class);
		startActivity(intent);
	}
	

}
