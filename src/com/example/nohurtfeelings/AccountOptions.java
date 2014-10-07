package com.example.nohurtfeelings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AccountOptions extends Activity{
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_options);
        EditText acctName=(EditText) findViewById(R.id.account_name_EditText);
        acctName.setKeyListener(null);
    }
	
	public void editQuestionLists(View view){
		Intent questionListActivityIntent=new Intent(this, QuestionListActivity.class);
    	startActivity(questionListActivityIntent);
	}
    public void back(View view){
    	Intent mainMenuIntent=new Intent(this, MainMenu.class);
    	startActivity(mainMenuIntent);
    }

}
