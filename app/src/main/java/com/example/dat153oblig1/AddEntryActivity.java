package com.example.dat153oblig1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class AddEntryActivity extends AppCompatActivity {

    Intent intentQuiz;
    TextView txtTest;
    ImageView imgCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        intentQuiz = getIntent();

        HashMap<String, Integer> database = (HashMap<String, Integer>) intentQuiz.getSerializableExtra("hashmap");

        txtTest = findViewById(R.id.txtTest);
        imgCat = findViewById(R.id.imgCat);
        //database.get("Cat");

        txtTest.setText((String) getKeyFromValue(database, R.drawable.ic_cat));
        imgCat.setImageResource(database.get("Cat"));
    }

    public static Object getKeyFromValue(HashMap hm, Object value){
        for(Object o: hm.keySet()){
            if(hm.get(o).equals(value)){
                return o;
            }
        }
        return null;
    }

}