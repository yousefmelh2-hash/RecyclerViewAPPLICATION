package com.example.yousef;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    private List<Item> itemList;

    // Constructor
    public ItemAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    // Holds the Views inside one item_row
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvLastName;
        ImageView ivPhoto;
        Button btnEdit;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvLastName = itemView.findViewById(R.id.tvLastName);
            ivPhoto = itemView.findViewById(R.id.ivPhoto);
            btnEdit=itemView.findViewById(R.id.btnEdit);
        }
    }

    // Creates a new item_row
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);

        return new MyViewHolder(view);
    }

    // Puts the Item's data into the row
    @Override
    public void onBindViewHolder(
            @NonNull MyViewHolder holder,
            int position) {

        Item item = itemList.get(position);

        holder.tvName.setText(item.getName());
        holder.tvLastName.setText(item.getLastName());

        if (item.getPhotoID() != null) {
            holder.ivPhoto.setImageURI(
                    Uri.parse(item.getPhotoID())
            );
        }
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(), EditItemActivity.class);
                intent.putExtra("item",item.getId());
                view.getContext().startActivity(intent);
            }
        });
    }

    // Number of items
    @Override
    public int getItemCount() {
        return itemList.size();
    }
}