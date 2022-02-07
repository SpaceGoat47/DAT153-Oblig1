package com.example.dat153oblig1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DatabaseActivity extends AppCompatActivity implements View.OnClickListener{

    //fields
    Button btnAddEntry2, btnRemove, btnSort;
    String s1[], s2[];
    RecyclerView recyclerView;
    private Intent intentAddEntry;
    private ArrayList<Integer> images;
    private ArrayList<String> names;
    Intent intentMain;


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnAddEntry2:
                setContentView(R.layout.activity_add_entry);
                startActivity(intentAddEntry);
                break;
            case R.id.btnSort:
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        //Initialize
        btnAddEntry2 = findViewById(R.id.btnAddEntry2);
        btnRemove = findViewById(R.id.btnRemove);
        btnSort = findViewById(R.id.btnSort);
        recyclerView = findViewById(R.id.recyclerView);
        intentAddEntry = new Intent(this, AddEntryActivity.class);

        intentMain = getIntent();
        ArrayList<String> names = (ArrayList<String>) intentMain.getSerializableExtra("names");
        ArrayList<Integer> images = (ArrayList<Integer>) intentMain.getSerializableExtra("images");

        //set onCLickListener
        btnAddEntry2.setOnClickListener(this);

        //Initialize MyAdapter class
        MyAdapter testAdapter = new MyAdapter(this, names, images);
        recyclerView.setAdapter(testAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}