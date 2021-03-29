package com.example.test;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ListItemHolder> {

    ArrayList<ListItem> list;
    Context context;
    ArrayList<Uri> imageUri;
   static int count=0;

    public ListItemAdapter(ArrayList<Uri> imageUri)
    {
        this.imageUri = imageUri;
        count++;

    }

    public ListItemAdapter(Context mContext, ArrayList<ListItem> list) {
        this.list = list;
        context = mContext;
    }



    @NonNull
    @Override
    public ListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new ListItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemHolder holder, int position) {

        String title = list.get(position).get_itemListTitle();
        holder._title.setText(title);

        holder._button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
                ((Activity) context).startActivityForResult(intent, 1);
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListItemHolder extends RecyclerView.ViewHolder
    {
        TextView _title;
        ImageButton _button;
       RecyclerView horRecycler;

        public ListItemHolder(View view){
            super(view);

            _title = view.findViewById(R.id.listTitle);
            _button = view.findViewById(R.id.listButton);
            horRecycler = view.findViewById(R.id.horRecycler);

            horRecycler.setHasFixedSize(false);
            horRecycler.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL,false));



        }

    }

    void setImageRecycler(RecyclerView imageRecycler, ArrayList<Uri> imgUri)
    {
        imageRecycler.setAdapter(new ImageItemAdapter(imgUri));

    }
}
