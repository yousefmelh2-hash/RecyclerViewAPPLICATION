package com.example.yousef;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemListActivity extends AppCompatActivity {
ArrayList<Item> arrayList=new ArrayList<>();
RecyclerView recyclerView;
ItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_input_activity);
        initComponents();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new ItemAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }

    private void initComponents() {
        recyclerView=findViewById(R.id.recyclerView);
        arrayList=(ArrayList<Item>) getIntent().getSerializableExtra("array");
    }
}