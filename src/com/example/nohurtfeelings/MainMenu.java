package com.example.nohurtfeelings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainMenu extends Activity {

	private boolean loggedOn = true; //false to test account creation, true for normal test

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

	public void joinRoom(View view) {
		if (loggedOn) {
			Intent joinRoomIntent = new Intent(this, JoinRoom.class);
			startActivity(joinRoomIntent);
		} else
			noAccountDetected();
	}

	public void editAccount(View view) {
		if (loggedOn) {
			Intent editAccountIntent = new Intent(this, AccountOptions.class);
			startActivity(editAccountIntent);
		} else
			noAccountDetected();
	}

	public void hostRoom(View view) {
		if (loggedOn) {
			Intent hostRoomIntent = new Intent(this, HostRoom.class);
			startActivity(hostRoomIntent);
		} else
			noAccountDetected();
	}

	private void noAccountDetected() {
		// if no account detected then launch account Creation activity
		Intent accountCreationIntent = new Intent(this, AccountCreation.class);
		startActivity(accountCreationIntent);

	}

}
