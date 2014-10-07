package com.example.nohurtfeelings;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class HostRoom extends Activity {
	
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_room);
        setUpDropDown();
	}
	public void setUpDropDown(){
		Spinner dropDown = (Spinner)findViewById(R.id.question_list_Spinner);
		ArrayList<String> listNames = new ArrayList<String>();
		listNames.add("College Games");
		listNames.add("Party Games");
		listNames.add("Kiddie Games");
		listNames.add("Adult Fun");
		listNames.add("Is this name too long?");
		listNames.add("There yet?");
		listNames.add("avada");
		listNames.add("Genie in the bottle");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listNames);
		dropDown.setAdapter(adapter);
	}
	public void back(View view){
		Intent intent = new Intent(this, MainMenu.class);
		startActivity(intent);
		
	}

}
