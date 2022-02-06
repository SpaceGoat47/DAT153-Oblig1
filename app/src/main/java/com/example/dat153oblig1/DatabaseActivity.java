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
    //TODO change to ListArray?
    //int images[] = {R.drawable.dog, R.drawable.horse, R.drawable.ic_cat};
    private Intent intentAddEntry;

    private ArrayList<Integer> images;


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnAddEntry2:
                setContentView(R.layout.activity_add_entry);
                startActivity(intentAddEntry);
                Toast.makeText(this, "TESTING TESTING", Toast.LENGTH_SHORT).show();
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

        //set onCLickListener
        btnAddEntry2.setOnClickListener(this);

        //get resources from strings.xml and store in s1 & s2 arrays
        s1 = getResources().getStringArray(R.array.animal_names);
        s2 = getResources().getStringArray(R.array.description);

        images = new ArrayList<>();
        images.add(R.drawable.dog);
        images.add(R.drawable.horse);
        images.add(R.drawable.ic_cat);

        //Initialize MyAdapter class
        MyAdapter myAdapter = new MyAdapter(this, s1, s2, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        /*
        animal = new ArrayList<>();
        animal.add(new Animal("Dog", R.drawable.dog));
        animal.add(new Animal("Horse", R.drawable.horse));
        animal.add(new Animal("Cat", R.drawable.ic_cat));
        */


    }
}