package com.example.myfinalapplication;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.format.DateFormat;

public class DBService {

    private static SQLiteDatabase db = null;

    static {
        db = SQLiteDatabase.openOrCreateDatabase("data/data/cn.lger.board/Board.db", null);
        String sql = "create table NoteBook(_id integer primary key autoincrement,title varchar(255),content TEXT, createTime varchar(25))";
        try{
            db.rawQuery("select count(1) from Board ",null);
        }catch(Exception e){
            db.execSQL(sql);
        }
    }

    public static SQLiteDatabase getSQLiteDatabase(){
        return db;
    }

    public static Cursor queryAll(){
        return db.rawQuery("select * from Board ",null);
    }

    public static Cursor queryNoteById(Integer id){
        return db.rawQuery("select * from Board where _id =?",new String[]{id.toString()});
    }

    public static void addBoard(ContentValues values){
        values.put("createTime", DateFormat.format("yyyy-MM-dd kk:mm:ss", System.currentTimeMillis()).toString());
        db.insert("Board", null, values);
    }
}
