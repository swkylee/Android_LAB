package com.example.swkyl.androidlabs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by swkyl on 2017-02-17.
 */

public class ChatDatabaseHelper extends SQLiteOpenHelper {

    private static String databaseName = "Chatdb";
    private static int databaseVersion = 3;
    public static String tableName = "CHAT_LOG";
    public final static String KEY_ID = "ID";
    public static String KEY_MESSAGE = "Message";
    private Context ctx;


    public ChatDatabaseHelper(Context ctx) {
        super(ctx, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("ChatDatabaseHelper", "Calling onCreate");
        db.execSQL("CREATE TABLE " + tableName + " ( " + KEY_ID + " INTEGER AUTO_INCREMENT PRIMARY KEY, "+ KEY_MESSAGE + " text); ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("ChatDatabaseHelper", "Calling onUpgrade, oldVersion=" + oldVersion + " newVersion=" + newVersion);
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);
    }

}
