package com.example.dat153oblig1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //fields
    private Button btnDatabase;
    private Button btnQuiz;
    private Button btnAddEntry;
    private Map<String, Integer> database;
    private Intent intentDatabase, intentQuiz, intentAddEntry;

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnDatabase:
                setContentView(R.layout.activity_database);
                startActivity(intentDatabase);
                Toast.makeText(this, "Going to Database", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnQuiz:
                setContentView(R.layout.activity_quiz);
                startActivity(intentQuiz);
                break;
            case R.id.btnAddEntry:
                setContentView(R.layout.activity_add_entry);
                startActivity(intentAddEntry);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing the Views
        btnDatabase = findViewById(R.id.btnDatabase);
        btnQuiz = findViewById(R.id.btnQuiz);
        btnAddEntry = findViewById(R.id.btnAddEntry);

        //initializing the intents
        intentDatabase = new Intent(this, DatabaseActivity.class);
        intentQuiz = new Intent(this, QuizActivity.class);
        intentAddEntry = new Intent(this, AddEntryActivity.class);

        //set the onClickListener
        //this refers to View.OnClickListener
        btnDatabase.setOnClickListener(this);
        btnQuiz.setOnClickListener(this);
        btnAddEntry.setOnClickListener(this);



    }
}