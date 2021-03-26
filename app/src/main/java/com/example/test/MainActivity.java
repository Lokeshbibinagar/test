package com.example.test;

import android.app.Activity;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ListItem> list;

    RecyclerView mRecyclerView;

    ArrayList<Uri> imageListUri;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        imageListUri = new ArrayList<>();

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        mRecyclerView.setAdapter(new ListItemAdapter(MainActivity.this,list));






        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder bd = new AlertDialog.Builder(MainActivity.this);

                final View cl = getLayoutInflater().inflate(R.layout.custom_dialog,null);

                bd.setView(cl);

                bd.setPositiveButton("OK", (DialogInterface dialog, int which) -> {
                    EditText _title = cl.findViewById(R.id.title);
                    String item = _title.getText().toString();
                    list.add(new ListItem(item));
                });

                bd.setNegativeButton("Cancel", (DialogInterface dialog, int which) -> {

                });

                AlertDialog dialog = bd.create();
                dialog.show();
            }
        });
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);

        ArrayList<Uri> imgUri = new ArrayList<>();

        if(requestCode == 1 && resultCode == RESULT_OK)
        {
            ClipData mClipData = data.getClipData();

            for(int i=0; i< mClipData.getItemCount();i++)
            {
                ClipData.Item item = mClipData.getItemAt(i);
                Uri uri = item.getUri();

                imgUri.add(i,uri);

            }

            imageListUri.addAll(imgUri);

            new ImageItemAdapter(imageListUri);

        }
    }



}