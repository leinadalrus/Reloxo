package com.example.reloxo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_INTENT= "com.example.reloxo.AlarmActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoAlarm(View view) {
        Intent intent = new Intent(MainActivity.this, AlarmActivity.class);
        intent.putExtra(EXTRA_INTENT, 0);
        MainActivity.this.startActivity(intent);
    }
}
