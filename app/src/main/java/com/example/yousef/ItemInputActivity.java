package com.example.yousef;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ItemInputActivity extends AppCompatActivity {
private Button btnAdd, btnGallery, btnCamera, btnDisplayResults;
private EditText etName, etLastName;
private ImageView ivPhoto;
private Item item;
private ArrayList<Item>arrayList =new ArrayList();

private ActivityResultLauncher<String> galleryLauncher;
private Uri selectedImageUri;
String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_list_activity);
        initComponents();
        registerLaunchers();
        setListeners();
        chooseFromGallery();
        cameraNotImplemented();
        addItem();
        clearForm();
        openItemList();









    }

    private void openItemList() {
       Intent intent=new Intent(this, ItemListActivity.class);
       intent.putExtra("array", arrayList);
       startActivity(intent);
    }

    private void clearForm() {
        etName.setText("");
        etLastName.setText("");
        ivPhoto.setVisibility(View.GONE);

    }

    private void addItem() {
        String name=etName.getText().toString();
        String lastName=etLastName.getText().toString();
        if (name.isEmpty()) {
            etName.setError("Name is required");
            return;}
        if (lastName.isEmpty()) {
            etLastName.setError("Name is required");
            return;
        }
        if (selectedImageUri == null) {
            Toast.makeText(this, "Please choose an image", Toast.LENGTH_SHORT).show();
            return;
        }
        String photoID=selectedImageUri.toString();
        item=new Item(name,lastName,photoID);
        arrayList.add(item);
        clearForm();

    }

    private void setListeners() {

            btnGallery.setOnClickListener(v -> chooseFromGallery());
            btnCamera.setOnClickListener(v -> cameraNotImplemented());
            btnAdd.setOnClickListener(v -> addItem());
           /* btnDisplayResults.setOnClickListener(v -> openItemList());*/
        }


    private void cameraNotImplemented() {
        Toast.makeText(this, "Not implemented yet",Toast.LENGTH_SHORT).show();
    }

    private void registerLaunchers() {
        galleryLauncher = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                uri -> {
            if (uri != null) {
                selectedImageUri = uri;
                ivPhoto.setImageURI(uri);
                ivPhoto.setVisibility(VISIBLE);
            }
        }
);
    }

    private void chooseFromGallery() {
        galleryLauncher.launch("image/*");
    }

    private void initComponents() {
        btnAdd = findViewById(R.id.btnAdd);
        btnGallery = findViewById(R.id.btnGallery);
        btnDisplayResults = findViewById(R.id.btnDisplayResults);
        btnCamera= findViewById(R.id.btnCamera);
        etName = findViewById(R.id.etName);
        etLastName=findViewById(R.id.etLastName);
        ivPhoto =findViewById(R.id.iVPhoto);
    }
}