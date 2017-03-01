package com.example.swkyl.androidlabs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    protected static final String ACTIVITY_NAME = "LoginActivity";
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(ACTIVITY_NAME, "In onCreate()");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button b2 = (Button) findViewById(R.id.button5);
        b2.setOnClickListener(this);

        sharedPref = this.getSharedPreferences(
                getString(R.string.app_name), Context.MODE_PRIVATE);

        String defaultValue = getResources().getString(R.string.email);
        String email = sharedPref.getString(getString(R.string.email), defaultValue);

        defaultValue = getResources().getString(R.string.password);
        String password = sharedPref.getString(getString(R.string.password), defaultValue);

        //Log.i(ACTIVITY_NAME,"############ onCreate : " + email +" / " + password);

        EditText Text1 = (EditText)findViewById(R.id.loginEmail);
        EditText Text2 = (EditText)findViewById(R.id.loginPassword);

        if (!email.equals("")) {
            Text1.setText(email);
        }
        if (!password.equals("")) {
            Text2.setText(password);
        }
    }

    public void onClick(View v) {
        //v.getId();
        SharedPreferences.Editor editor = sharedPref.edit();

        EditText Text1 = (EditText)findViewById(R.id.loginEmail);
        EditText Text2 = (EditText)findViewById(R.id.loginPassword);

        String email = Text1.getText().toString();
        String password = Text2.getText().toString();

        //Log.i(ACTIVITY_NAME,"############" + email +" / " + password);

        editor.putString(getString(R.string.email), email);
        editor.putString(getString(R.string.password), password);
        editor.commit();

        Intent intent = new Intent(LoginActivity.this, StartActivity.class);
        startActivity(intent);
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
