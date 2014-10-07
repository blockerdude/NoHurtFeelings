package com.example.nohurtfeelings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AccountCreation extends Activity {

	//only accessible if nobody is logged in..
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account_creation);
	}

	public void createAccount(View view) {
		//ensure that every field is filled out
		//check data against server
		//make the account
		//save login
		//bring to main menu
		Intent intent = new Intent(this, MainMenu.class);
		startActivity(intent);
	}
	public void loginAccount(View view){
		//check acctname and password and attempt to login
		//if fail post a toast
		//if success save login 
		//bring to main menu
		Intent intent = new Intent(this, MainMenu.class);
		startActivity(intent);
	}
}
