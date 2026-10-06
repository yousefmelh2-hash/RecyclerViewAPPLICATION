package com.example.yousef;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EditItemActivity extends AppCompatActivity {
    private Button btnUpdate, btnDelete;
    private TextView tvName, tvLastName;
    private EditText etName, etLastName;
private HelperDB helperDB;
    Item item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_item_activity);
        initComponents();
        if (item==null){
            Toast.makeText(this, "Please choose a valid item", Toast.LENGTH_SHORT).show();
            finish();
        }
        tvName.setText(item.getName());
        tvLastName.setText(item.getLastName());

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helperDB.deleteItem(item.getId());
                Toast.makeText(EditItemActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditItemActivity.this, "Updated", Toast.LENGTH_SHORT).show();
            helperDB.updateItem(item.getId(),etName.getText().toString(),etLastName.getText().toString());
                finish();
            }
        });
    }

    private void initComponents() {
        helperDB=new HelperDB(this);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnDelete=findViewById(R.id.btnDelete);
        tvName=findViewById(R.id.tvName);
        tvLastName=findViewById(R.id.tvLastName);
        etName=findViewById(R.id.etNewName);
        etLastName=findViewById(R.id.etNewLastName);
        int id=getIntent().getIntExtra("item",-1);
        item=helperDB.getItemById(id);
    }
}