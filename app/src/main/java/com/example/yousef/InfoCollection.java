package com.example.yousef;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class InfoCollection extends AppCompatActivity {
Button buttonPassIn;
EditText EditTextName;
String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_collection);
        initComponents();
        buttonPassIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Intent intent = new Intent(InfoCollection.this, SecondActivity.class);
                intent.putExtra("name", EditTextName.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void initComponents() {
        buttonPassIn = findViewById(R.id.buttonPassIn);
        EditTextName = findViewById(R.id.EditTextName);

    }
}