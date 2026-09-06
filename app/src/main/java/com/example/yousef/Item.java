package com.example.yousef;

import android.widget.ImageView;

import java.io.Serializable;

public class Item implements Serializable {
    String name, lastName, photoID;
    public Item(String name, String lastName, String photoID){
        this.name=name;
        this.lastName=lastName;
        this.photoID=photoID;
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
