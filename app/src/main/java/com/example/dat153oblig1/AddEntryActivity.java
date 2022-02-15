package com.example.dat153oblig1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class AddEntryActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "AddEntryActivity";
    private static Database database = Database.getInstance();
    static final int REQUEST_IMAGE_GET = 1;
    //fields
    private ImageView imgImage;
    private Button btnAddEntry, btnChooseImage;
    private EditText edtText;
    private Intent intent;

    @Override
    public void onClick(View view) {

        Log.d(TAG, "onClick-button: " + view.getResources().getResourceEntryName(view.getId()));

        switch(view.getId()){
            case R.id.btnAddEntry:
                break;
            case R.id.btnChooseImage:
                selectImage();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        Log.d(TAG, "onCreate");

        //initialize views
        imgImage = findViewById(R.id.imgImage);
        btnAddEntry = findViewById(R.id.btnAddEntry);
        btnChooseImage = findViewById(R.id.btnChooseImage);
        edtText = findViewById(R.id.edtText);

        //set onClickListener
        btnAddEntry.setOnClickListener(this);
        btnChooseImage.setOnClickListener(this);

    }

    public void selectImage(){
        intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent, REQUEST_IMAGE_GET);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_IMAGE_GET && resultCode == RESULT_OK){
            Uri fullPhotoUri = data.getData();

        }
    }
}