package com.example.swkyl.androidlabs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button b1 = (Button) findViewById(R.id.button2);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //v.getId();
        Intent intent1 = new Intent(this, LoginActivity.class);
        startActivity(intent1);
    }
}
