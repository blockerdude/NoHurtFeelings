package com.example.nohurtfeelings;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class JoinRoom extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_room);
    }
    public void back(View view){
    	Intent intent=new Intent(this, MainMenu.class);
    	startActivity(intent);
    }
    public void connect(View view){
    	//connect to a server... how?
    	//Intent intent=new Intent(this, )
    	//startActivity(intent);
    }
}
