package com.example.myfinalapplication;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.Toast;

public class DBService extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "Board.db";
    public static final String TB_NAME = "Board";


    public DBService(Context context, String name, SQLiteDatabase.CursorFactory factory,
                     int version) {
        super(context, name, factory, version);
    }

    DBService(Context context) {
        super(context, "Board.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Board(_id INTEGER PRIMARY KEY AUTOINCREMENT,title varchar,content varchar,CreateTime varchar)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}

