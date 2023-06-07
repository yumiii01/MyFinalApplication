package com.example.myfinalapplication;

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

public class BoardActivity extends AppCompatActivity {
    private ListView viewById;
    private DBService DBService;
    private SimpleCursorAdapter adapter;
    private Cursor cursor;

    String from[] = new String[]{"title", "content", "CreateTime"};
    int[] to = new int[]{R.id.BoardTitle, R.id.content, R.id.CreateTime};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        DBService = new DBService(this);
        viewById = (ListView) findViewById(R.id.listBoard);
        Show();

        Button add = (Button)findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(BoardActivity.this,PostActivity.class);
            startActivity(intent);
        }
    });
    }
    public void Show() {
        SQLiteDatabase sqLiteDatabase = DBService.getWritableDatabase();
        cursor = sqLiteDatabase.query("information", null, null, null, null, null, null);
        adapter = new SimpleCursorAdapter(this, R.layout.board_item, cursor, from, to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        viewById.setAdapter(adapter);
        sqLiteDatabase.close();
    }

    public void save(View v) {
        //获得可读写数据库对象
        SQLiteDatabase sqLiteDatabase = DBService.getWritableDatabase();
        ContentValues values = new ContentValues();
        EditText title = (EditText) findViewById(R.id.title);
        EditText content = (EditText) findViewById(R.id.content);
        values.put("title", title.getText().toString().trim());
        values.put("content", content.getText().toString());
        long q = sqLiteDatabase.insert("information", "name", values);
        Toast.makeText(this, "数据存入成功", Toast.LENGTH_SHORT).show();
        //数据库发生变化时更新listview
        cursor.requery();
        adapter.notifyDataSetChanged();
        sqLiteDatabase.close();
    }


}