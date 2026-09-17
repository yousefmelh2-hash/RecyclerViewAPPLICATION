package com.example.yousef;

import android.widget.ImageView;

import java.io.Serializable;

public class Item implements Serializable {
    private String name, lastName, photoID;
    private int id;
    public Item(String name, String lastName, String photoID){
        this.name=name;
        this.lastName=lastName;
        this.photoID=photoID; //g
    }

    public int getId() {
        return id;
    }

    public Item(String name, String lastName, String photoID, int id) {
        this.name = name;
        this.lastName = lastName;
        this.photoID = photoID;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhotoID() {
        return photoID;
    }

    public void setPhotoID(String photoID) {
        this.photoID = photoID;
    }
    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", photoID='" + photoID + '\'' +
                '}';
    }
}
