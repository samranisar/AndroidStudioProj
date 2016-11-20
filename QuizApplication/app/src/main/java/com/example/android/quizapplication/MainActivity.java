package com.example.android.quizapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Callable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int score = 0;
    boolean F=false;



    public void Score(View view) {

        EditText name = (EditText) findViewById(R.id.name_);
        String n_ame=name.getText().toString();
        EditText Rollno = (EditText) findViewById(R.id.Roll_no_);
        String Rollno_ = Rollno.getText().toString();

        if (score > 0) {
            score = 0;
        }


        RadioButton answer1 = (RadioButton) findViewById(R.id.answer_1);
        if (answer1.isChecked()) {
            score += 1;
        }

        RadioButton answer2 = (RadioButton) findViewById(R.id.answer_2);
        if (answer2.isChecked()) {
            score += 1;
        }

        CheckBox answer3i = (CheckBox) findViewById(R.id.answer_3i);
        CheckBox answer3ii = (CheckBox) findViewById(R.id.answer_3ii);
        CheckBox wrongAnswer3i = (CheckBox) findViewById(R.id.wrong_answer3i);
        CheckBox wrongAnswer3ii = (CheckBox) findViewById(R.id.wrong_answer3ii);
        if (answer3i.isChecked() && answer3ii.isChecked() && wrongAnswer3i.isChecked()==F && wrongAnswer3ii.isChecked()==F) {
            score += 1;
        }

        EditText answer4 = (EditText) findViewById(R.id.answer_4);
        String ans4= answer4.getText().toString();
        if (ans4.equals("C") || ans4.equals("c"))
        {
            score += 1;
        }


        RadioButton answer5 = (RadioButton) findViewById(R.id.answer_5);
        if (answer5.isChecked()) {
            score += 1;
        }

        EditText answer6 = (EditText) findViewById(R.id.answer_6);
        String ans6=answer6.getText().toString();
        if (ans6.equals("6th") || ans6.equals("6")) {
            score += 1;
        }

        EditText answer7 = (EditText) findViewById(R.id.answer_7);
        String ans7=answer7.getText().toString();
        if (ans7.equals("Haemoglobin") || ans7.equals("haemoglobin")) {
            score += 1;
        }

        CheckBox answer8i = (CheckBox) findViewById(R.id.answer_8i);
        CheckBox answer8ii = (CheckBox) findViewById(R.id.asnwer_8ii);
        CheckBox wrongAnswer8i = (CheckBox)findViewById(R.id.wrong_answer8i);
        CheckBox wrongAnswer8ii = (CheckBox) findViewById(R.id.wrong_answer8ii);
        if (answer8i.isChecked() && answer8ii.isChecked() && wrongAnswer8i.isChecked()==F && wrongAnswer8ii.isChecked()==F) {
            score += 1;
        }

        RadioButton answer9 = (RadioButton) findViewById(R.id.answer_9);
        if (answer9.isChecked()) {
            score += 1;
        }

        RadioButton answer10 = (RadioButton) findViewById(R.id.answer_10);
        if (answer10.isChecked()) {
            score += 1;
        }


        Toast.makeText(MainActivity.this,"Name : "+n_ame+"\n Roll no : "+Rollno_+ "\nYour score is " + score + "/10", Toast.LENGTH_SHORT).show();

    }
}
