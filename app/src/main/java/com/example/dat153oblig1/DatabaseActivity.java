package com.example.dat153oblig1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class DatabaseActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnTest;
    private ImageView imgCat;

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnTest:
                //imgCat.setImageResource();
                //imgCat.setVisibility(View.INVISIBLE);
                Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        btnTest = findViewById(R.id.btnTest);
        imgCat = findViewById(R.id.imgCat);

        btnTest.setOnClickListener(this);

        //imgCat.setVisibility(View.INVISIBLE);
    }
}