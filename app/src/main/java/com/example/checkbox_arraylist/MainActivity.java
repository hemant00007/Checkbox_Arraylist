package com.example.checkbox_arraylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements QualatyListner{
    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = findViewById(R.id.recyclerview);
        setrecyclerview();
        
        
    }
    private ArrayList<String> getquantities(){
        ArrayList<String> arrayList= new ArrayList<>();
        arrayList.add("10 KG");
        arrayList.add("20 KG");
        arrayList.add("30 KG");
        arrayList.add("40 KG");
        arrayList.add("50 KG");
        arrayList.add("60 KG");
        arrayList.add("70 KG");
        arrayList.add("80 KG");
        arrayList.add("90 KG");
        return arrayList;
    }

    private void setrecyclerview() {
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(new QuantityAdapter(this,getquantities(),this));
    }

    @Override
    public void onQualtityChange(ArrayList<String> arrayList) {
        Toast.makeText(getApplicationContext(),arrayList.toString(),Toast.LENGTH_SHORT).show();
    }
}