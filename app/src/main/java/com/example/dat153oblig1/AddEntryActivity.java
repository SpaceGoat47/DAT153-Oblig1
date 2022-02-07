package com.example.dat153oblig1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class AddEntryActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnChooseImage, btnAddEntry;
    ImageView imgView;
    EditText edtText;
    Intent intentMain;
    String message;
    public static final String TEST = "Hei";

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnChooseImage:
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 3);
                break;
            case R.id.btnAddEntry:
                /*
                intentMain = new Intent(this, MainActivity.class);
                message = edtText.getText().toString();
                intentMain.putExtra(TEST, message);
                setContentView(R.layout.activity_main);
                startActivity(intentMain);
                */
                break;
            default:
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        //initialize
        btnChooseImage = findViewById(R.id.btnChooseImage);
        btnAddEntry = findViewById(R.id.btnAddEntry);

        //onclicklistener
        btnChooseImage.setOnClickListener(this);
        btnAddEntry.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && data != null){
            //uniformed resource identifier
            Uri selectedImage = data.getData();
            imgView = findViewById(R.id.imageView);
            imgView.setImageURI(selectedImage);


        }
    }
}