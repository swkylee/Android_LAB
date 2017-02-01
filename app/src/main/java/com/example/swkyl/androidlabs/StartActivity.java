package com.example.swkyl.androidlabs;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    protected static final String ACTIVITY_NAME = "StartActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(ACTIVITY_NAME, "In onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //v.getId();
        Intent intent1 = new Intent(this, ListItemsActivity.class);
        startActivityForResult(intent1,5);

    }

    public void onActivityResult(int requestCode, int responseCode, Intent data) {
        if (requestCode == 5) {
            Log.i(ACTIVITY_NAME, "Returned to StartActivity.onActivityResult");
        }

        if (responseCode == Activity.RESULT_OK) {
            String messagePassed = data.getStringExtra ( "Response");

            CharSequence text = "ListItemsActivity passed: " + messagePassed;// "Switch is Off"
            int duration = Toast.LENGTH_LONG; //= Toast.LENGTH_LONG if Off

            Toast toast = Toast.makeText(this , text, duration); //this is the ListActivity
            toast.show(); //display your message box

        }
    }

    public void onResume() {
        Log.i(ACTIVITY_NAME, "In onResume()");
        super.onResume();
    }
    public void onStart() {
        Log.i(ACTIVITY_NAME, "In onStart()");
        super.onStart();
    }
    public void onPause() {
        Log.i(ACTIVITY_NAME, "In onPause()");
        super.onPause();
    }
    public void onStop() {
        Log.i(ACTIVITY_NAME, "In onStop()");
        super.onStop();
    }
    public void onDestory() {
        Log.i(ACTIVITY_NAME, "In onDestroy()");
        super.onDestroy();
    }
}
