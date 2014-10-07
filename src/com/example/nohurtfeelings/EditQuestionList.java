package com.example.nohurtfeelings;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class EditQuestionList extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_question_list);
        
        Bundle passedInfo = getIntent().getExtras();
        String qListName = passedInfo.getString("qListName");
        
        TextView qTitle = (TextView) findViewById(R.id.question_list_name_TextView);
        qTitle.setText(qListName);
        
       // setUpQuestions();
    }
	//private void setUpQuestions(){
		//same logic as the questionList activity.
		//can i roll both of these into one activity.
		//reduces duplicated code...
		
		//so upon pressing edit on a question list, the list is replaced with questions, and a back button exists
		//to cycle between lists and questions.
		
	//}

}
