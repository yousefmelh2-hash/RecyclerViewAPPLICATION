package com.example.yousef;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ItemListActivity extends AppCompatActivity {
ArrayList<Item> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_input_activity);
        initComponents();
    }

    private void initComponents() {
        arrayList=(ArrayList<Item>) getIntent().getSerializableExtra("array");
    }
}