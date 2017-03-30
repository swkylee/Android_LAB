package com.example.swkyl.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TestToolbar extends AppCompatActivity {
    final private String ACTIVITY_NAME = "TestToolbar";
    String value="";
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toolbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, value, Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch(menuItem.getItemId()){
            case R.id.action_one:
                Log.i(ACTIVITY_NAME,"MENU 1");
                value="You selected item 1";
                return true;

            case R.id.action_two:
                Log.i(ACTIVITY_NAME,"MENU 2");
                value="You selected item 2";

                new android.app.AlertDialog.Builder(TestToolbar.this).setTitle("Do you want to go back")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent resultIntent = new Intent(getApplicationContext(),StartActivity.class);
                                startActivity(resultIntent);
                                finish();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                return true;

            case R.id.action_three:
                Log.i(ACTIVITY_NAME,"MENU 3");
                value="You selected item 3";

                AlertDialog.Builder builder = new AlertDialog.Builder(TestToolbar.this);

                LayoutInflater inflater = getLayoutInflater();

                final View inflator =  inflater.inflate(R.layout.custom_dialog , null);

                builder.setView(inflator).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                editText= (EditText)inflator.findViewById(R.id.newMessage);
                                value = editText.getText().toString();
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        .show();

                return true;
            case R.id.action_about:
                Toast.makeText(this, "Version 1.0 by Sungwon LEE", Toast.LENGTH_LONG).show();
                return true;
            default:  return super.onOptionsItemSelected(menuItem);
        }


    }

}
