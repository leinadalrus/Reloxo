package com.example.reloxo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_INTENT= "com.example.reloxo.AlarmActivity.EXTRA_INTENT";

    AlarmActivity alarmactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmactivity = new AlarmActivity();

        if (getSupportFragmentManager().findFragmentByTag(alarm_tag) == null) {
            AlarmFragment alarm_frag = new AlarmFragment();
            FragmentTransaction alarmFragment_FragmentTransaction = getSupportFragmentManager().beginTransaction();
            alarmFragment_FragmentTransaction.add(alarm_frag, alarm_tag); // Swtich ~.add() to ~.replace()
            // Access alarmFragment_FragmentTransaction.setTransition(FragmentTransaction.SET_TRANSITION_CUT)
            alarmFragment_FragmentTransaction.commit();
        } // Creates a new instance of the FragmentManager to allow for the AlarmFragment class to link to AlarmActivity and operate.
    }

    public void gotoAlarm(View view) {
        Intent intent = new Intent(MainActivity.this, AlarmActivity.class);
        intent.putExtra(EXTRA_INTENT, 0);
        this.startActivity(intent);
    }
}
