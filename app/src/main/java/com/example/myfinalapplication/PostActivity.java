package com.example.myfinalapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class PostActivity extends AppCompatActivity {
    private EditText titleEditText = null;
    private EditText contentEditText = null;
    private String BoardId = null;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        Button PostButton = (Button) findViewById(R.id.PostButton);
        PostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PostActivity.this,BoardActivity.class);
                startActivity(intent);
                Toast.makeText(PostActivity.this,"发布成功",Toast.LENGTH_SHORT).show();
            }
        });

    }


    }
