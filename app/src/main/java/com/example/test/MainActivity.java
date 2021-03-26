package com.example.test;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder bd = new AlertDialog.Builder(MainActivity.this,R.style.Theme_AppCompat_Dialog_Alert);

                final View cl = getLayoutInflater().inflate(R.layout.custom_dialog,null);

                bd.setView(cl);

                bd.setPositiveButton("OK", (DialogInterface dialog, int which) -> {
                    EditText _title = cl.findViewById(R.id.title);
                    Toast.makeText(MainActivity.this, _title.toString(), Toast.LENGTH_SHORT).show();
                });

                bd.setNegativeButton("Cancel", (DialogInterface dialog, int which) -> {

                });

            }
        });
    }
}