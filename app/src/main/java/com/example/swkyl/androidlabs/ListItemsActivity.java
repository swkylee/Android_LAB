package com.example.swkyl.androidlabs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ListItemsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        Button b3 = (Button) findViewById(R.id.button4);
        b3.setOnClickListener(this);
    }

    public void onClick(View v) {
        //v.getId();
        Intent intent3 = new Intent(this, StartActivity.class);
        startActivity(intent3);
    }
}
