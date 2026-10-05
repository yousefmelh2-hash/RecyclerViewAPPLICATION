package com.example.yousef;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemListActivity extends AppCompatActivity {
    ArrayList<Item> arrayList = new ArrayList<>();
    RecyclerView recyclerView;
    ItemAdapter adapter;
    HelperDB helperDB;
    Button btnSearch, btnShowAll;
    EditText etSearchTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_list_activity);
        initComponents();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        helperDB = new HelperDB(this);
        arrayList = helperDB.getAllItems();
        adapter = new ItemAdapter(arrayList);
        recyclerView.setAdapter(adapter);
        btnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAllItems();
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchItems();
            }
        });
    }

    private void initComponents() {
        recyclerView = findViewById(R.id.recyclerView);
        /*    arrayList=(ArrayList<Item>) getIntent().getSerializableExtra("array");*/
        btnSearch = findViewById(R.id.btnSearch);
        btnShowAll = findViewById(R.id.btnShowAll);
        etSearchTitle = findViewById(R.id.etSearchTitle);
    }

    private void showAllItems() {
        arrayList = helperDB.getAllItems();
        ItemAdapter adapter = new ItemAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }

    private void searchItems() {
        String title = etSearchTitle.getText().toString();
        arrayList = helperDB.getItemsByTitle(title);
        ItemAdapter adapter = new ItemAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }
}