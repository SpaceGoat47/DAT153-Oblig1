package com.example.dat153oblig1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //fields
    private Button btnDatabase;
    private Button btnQuiz;
    private Button btnAddEntry;
    private ArrayList<String> names;
    private ArrayList<Integer> images;
    private Intent intentDatabase, intentQuiz, intentAddEntry;

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnDatabase:
                setContentView(R.layout.activity_database);
                startActivity(intentDatabase);
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

        //initialize the ArrayLists and insert items
        names = new ArrayList<>();
        images = new ArrayList<>();
        names.add("Dog");
        names.add("Horse");
        names.add("Cat");
        images.add(R.drawable.dog);
        images.add(R.drawable.horse);
        images.add(R.drawable.ic_cat);

        intentDatabase.putExtra("images", images);
        intentDatabase.putExtra("names", names);
        intentQuiz.putExtra("images", images);
        intentQuiz.putExtra("names", names);

    }

    //this is just bad freestyling...
    /*
    @Override
    protected void onResume() {
        Log.d("WTF", "Testing what happens: onResume()");
        Intent intent = getIntent();
        String msg = (String) intent.getSerializableExtra(AddEntryActivity.TEST);
        //NULL
        names.add(msg);
        System.out.println(names);
        super.onResume();
    }*/
}