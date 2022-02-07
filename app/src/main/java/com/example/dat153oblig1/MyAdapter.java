package com.example.dat153oblig1;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String data1[], data2[];
    private ArrayList<Integer> images;
    private ArrayList<String> names;
    Context context;
    //private HashMap<String, Integer> test;


    public MyAdapter(Context c, ArrayList<String> names, ArrayList<Integer> images){
        this.context = c;
        this.names = names;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);

        Log.d(TAG, "onCreateViewHolder: Test");

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText1.setText(names.get(position));
        //holder.myText1.setText((Integer) getKeyFromValue(test, R.drawable.ic_cat));
        //holder.myText2.setText(data2[position]);
        holder.myImage.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myText1, myText2;
        ImageView myImage;
        Button btnDelete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.txtAnimalNames);
            myText2 = itemView.findViewById(R.id.txtDescription);
            myImage = itemView.findViewById(R.id.imgImage);
        }
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
