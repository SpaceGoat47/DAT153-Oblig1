package com.example.dat153oblig1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //fields
    private Button btnDatabase;
    private Button btnQuiz;
    private Button btnAddEntry;

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnDatabase:
                setContentView(R.layout.activity_database);
                Toast.makeText(this, "Going to Database", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnQuiz:
                setContentView(R.layout.activity_quiz);
                break;
            case R.id.btnAddEntry:
                setContentView(R.layout.activity_add_entry);
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

        //set the onClickListener
        //this refers to View.OnClickListener
        btnDatabase.setOnClickListener(this);
        btnQuiz.setOnClickListener(this);
        btnAddEntry.setOnClickListener(this);
    }
}