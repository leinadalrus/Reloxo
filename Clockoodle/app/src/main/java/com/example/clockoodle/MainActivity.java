package com.example.preloxo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.Button;
import android.view.View;

import com.example.clockoodle.PrelFrag.optionSelect;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    int hours, minutes;

    public static final String main_tag = "MainActivity";
    public static final String main_frag = "MainFragment";

    // Initialize Alarm Activity Screen
    public void init_alarm(String msg, int hrs, int mins) {
        Intent init_alarm_intent = new Intent (AlarmClock.ACTION_SET_ALARM)
            .putExtra(AlarmClock.EXTRA_MESSAGE, msg)
            .putExtra(AlarmClock.EXTRA_HOUR, hrs)
            .putExtra(AlarmClock.EXTRA_MINUTES, mins);

            if (intent.resolveActivity(getPackageManager())!=null) {
                startActivity(init_alarm_intent);
            }
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.Layout.MainActivity);

        if (getSupportFragmentManager().findFragmentByTag(main_tag) == null) {
            MainFragment main_frag = new MainFragment();
            FragmentTransaction mainFragment_FragmentTransaction = getSupportFragmentManager().beginTransaction();
            mainFragment_FragmentTransaction.add(main_tag, main_frag);
            mainFragment_FragmentTransaction.commit();
        } // Creates a new instance of the FragmentManager to allow for the MainFrag class to link to MainActivity and operate.

        // OnClickListener : Alarm Set Button
        public void button_set_alarm(Button button_btns) {
            button_btns = findViewById(R.id.button_set_alarm_time);
            button_btns.setOnClickOnListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent button_press = new Intent();
                    startActivity(button_press);
                    getUser_set_alarm();
                    optionSelect();
                }
            });
        }
    }
}

MainFragment.optionSelect optionSelect, main_OPTS;
com.example.clockoodle.MainFragment.optionSelect optionSelect() {
    optionSelect = main_OPTS;
    return main_OPTS;
}