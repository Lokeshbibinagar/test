package com.example.test;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ImageItemAdapter extends RecyclerView.Adapter<ImageItemAdapter.ImageViewHolder> {

    ArrayList<Uri> imageList;

    public ImageItemAdapter(ArrayList<Uri> imageList)
    {
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list_layout, parent, false);

        return new ImageItemAdapter.ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {


        Uri img = imageList.get(position);

        holder._img.setImageURI(img);

    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder{
        ImageView _img;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            _img = itemView.findViewById(R.id.ImageItemList);
        }
    }
}
