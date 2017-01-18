package com.example.swkyl.androidlabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button b2 = (Button) findViewById(R.id.button3);
        b2.setOnClickListener(this);
        //b1.setOnClickListener(this);
    }

    public void onClick(View v) {
        //v.getId();
        Intent intent2 = new Intent(this, ListItemsActivity.class);
        startActivity(intent2);
    }

}
