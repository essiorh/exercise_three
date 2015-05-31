package com.example.iliamaltsev.exercise_three;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class ChangeActivity extends AppCompatActivity implements View.OnClickListener{
    private int idContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_activity);

        idContainer=getIntent().getIntExtra(getString(R.string.id_container),0);
        findViewById(R.id.first).setOnClickListener(this);
        findViewById(R.id.second).setOnClickListener(this);
        findViewById(R.id.third).setOnClickListener(this);
        findViewById(R.id.fourth).setOnClickListener(this);
        findViewById(R.id.fifth).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_container, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent homeIntent = new Intent(this, ContainerActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        homeIntent.putExtra(getString(R.string.id_container), idContainer);
        switch (v.getId()){
            case R.id.first:
                homeIntent.putExtra(getString(R.string.id_fragment), 1);
                break;
            case R.id.second:
                homeIntent.putExtra(getString(R.string.id_fragment), 2);
                break;
            case R.id.third:
                homeIntent.putExtra(getString(R.string.id_fragment), 3);
                break;
            case R.id.fourth:
                homeIntent.putExtra(getString(R.string.id_fragment), 4);
                break;
            case R.id.fifth:
                homeIntent.putExtra(getString(R.string.id_fragment), 5);
                break;

        }
        setResult(RESULT_OK, homeIntent);
        finish();
    }
}
