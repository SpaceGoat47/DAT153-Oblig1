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

import java.util.HashMap;
import java.util.Map;

public class DatabaseActivity extends AppCompatActivity implements View.OnClickListener{

    String s1[], s2[];
    RecyclerView recyclerView;
    //TODO change to ListArray
    int images[] = {R.drawable.dog, R.drawable.horse, R.drawable.ic_cat};


    @Override
    public void onClick(View view) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        recyclerView = findViewById(R.id.recyclerView);

        //get resources from strings.xml and store in s1 & s2 arrays
        s1 = getResources().getStringArray(R.array.animal_names);
        s2 = getResources().getStringArray(R.array.description);


        //Initialize MyAdapter class
        MyAdapter myAdapter = new MyAdapter(this, s1, s2, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}