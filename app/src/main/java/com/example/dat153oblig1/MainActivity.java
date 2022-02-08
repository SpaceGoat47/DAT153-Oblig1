package com.example.dat153oblig1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";
    //fields
    private Button btnDatabase, btnQuiz, btnAddEntry;
    private ArrayList<Animal> database;
    private Intent intent;

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnDatabase:
                //setContentView(R.layout.activity_database);
                intent = new Intent(this, DatabaseActivity.class);
                break;
            case R.id.btnQuiz:
                //setContentView(R.layout.activity_quiz);
                intent = new Intent(this, QuizActivity.class);
                break;
            case R.id.btnAddEntry:
                //setContentView(R.layout.activity_add_entry);
                intent = new Intent(this, AddEntryActivity.class);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "TEST1");
        //Initialize database and populate it
        Database db = new Database(database);
        db.initializeDatabase();

        Log.d(TAG, "TEST2");

        //initialize buttons
        btnDatabase = findViewById(R.id.btnDatabase);
        btnQuiz = findViewById(R.id.btnQuiz);
        btnAddEntry = findViewById(R.id.btnAddEntry);

    }
}