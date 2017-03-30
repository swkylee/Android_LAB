package com.example.swkyl.androidlabs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {
    private static String ACTIVITY_NAME = "ChatWindow";
    private ArrayList<String> chatMessages = new ArrayList<String>();;
    private SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);

        final ListView listView = (ListView)findViewById(R.id.messageList);
        final Button sendMessageButton = (Button)findViewById(R.id.sendButton);
        final EditText chatMessageField = (EditText)findViewById(R.id.chatText);

        // handling DB
        final ChatDatabaseHelper dbHelper;dbHelper = new ChatDatabaseHelper(this);
        db = dbHelper.getWritableDatabase();

        Cursor cursor = db.query(false, dbHelper.tableName, new String[]{dbHelper.KEY_ID,dbHelper.KEY_MESSAGE}, null,null,null,null,null,null);
        //Cursor cursor = db.rawQuery("select * from ?", new String[] { dbHelper.tableName});
        cursor.moveToFirst();

        int index = cursor.getColumnIndex(dbHelper.KEY_MESSAGE);

        while(!cursor.isAfterLast() ) {
            String t = cursor.getString(index);
            chatMessages.add(t);

            Log.i(ACTIVITY_NAME, "SQL MESSAGE:" + cursor.getString(cursor.getColumnIndex(ChatDatabaseHelper.KEY_MESSAGE)));
            Log.i(ACTIVITY_NAME, "Cursor’s  column count = " + cursor.getColumnCount() );

            cursor.moveToNext();
        }

        cursor.close();

        //in this case, “this” is the ChatWindow, which is-A Context object
        final ChatAdapter messageAdapter = new ChatAdapter( this );
        listView.setAdapter(messageAdapter);

        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = chatMessageField.getText().toString();
                chatMessages.add(temp);
                messageAdapter.notifyDataSetChanged();
                chatMessageField.setText("");

                ContentValues cValues = new ContentValues();
                cValues.put(dbHelper.KEY_MESSAGE, temp);
                db.insert(dbHelper.tableName, null, cValues);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Log.i(ACTIVITY_NAME,"positin :"+position +", id:"+id);

            }
        });
    }

    private class ChatAdapter extends ArrayAdapter<String>{
        public ChatAdapter(Context ctx){
            super(ctx, 0);
        }

        public int getCount(){
            return chatMessages.size();
        };

        public String getItem(int position){
            return chatMessages.get(position);
        };

        public View getView(int position, View convertView, ViewGroup parent){

            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();

            View result = null;

            if(position%2 == 0){
                result = inflater.inflate(R.layout.chat_row_incoming, null);
            } else {
                result = inflater.inflate(R.layout.chat_row_outgoing, null);
            }

            TextView message = (TextView) result.findViewById(R.id.message_text);
            message.setText(getItem(position));

            return result;
        }
    }

    protected void onDestroy() {
        Log.i(ACTIVITY_NAME, "In onDestroy()");
        super.onDestroy();
        db.close();
    }
}