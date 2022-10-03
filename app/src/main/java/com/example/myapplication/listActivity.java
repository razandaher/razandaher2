package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listActivity extends AppCompatActivity {

     ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = (ListView) findViewById(R.id.listView);

        // Array list
        ArrayList<String> arraylist = new ArrayList<>();
        arraylist.add("banana");
        arraylist.add("apple");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arraylist); // initialize the adapter

        listView.setAdapter(arrayAdapter); // connect adapter to array
     // handle items clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(listActivity.this,"clicked item"+ i+"" + arraylist.get(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}