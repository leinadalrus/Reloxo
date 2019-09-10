package com.example.reloxo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.provider.AlarmClock;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.Button;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class AlarmActivity extends AppCompatActivity {

    int hours, minutes;
    static int alarm_TypeInt;

    private static TextView onScreen_Alert, onScreen_Message;
    EditText userActive_SetName, userActive_SetAlarm;

    public static final String alarm_tag = "AlarmActivity";
    public static final String alarm_frag = "AlarmFragment";

    // Initialize Alarm Activity Screen
    public void init_alarm(String msg, int hours, int minutes) {
        Intent init_alarm_intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, msg)
                .putExtra(AlarmClock.EXTRA_HOUR, hours)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);

        if (init_alarm_intent.resolveActivity(getPackageManager()) != null) {
            startActivity(init_alarm_intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        if (getSupportFragmentManager().findFragmentByTag(alarm_tag) == null) {
            AlarmFragment alarm_frag = new AlarmFragment();
            FragmentTransaction alarmFragment_FragmentTransaction = getSupportFragmentManager().beginTransaction();
            alarmFragment_FragmentTransaction.add(alarm_frag, alarm_tag);
            alarmFragment_FragmentTransaction.commit();
        } // Creates a new instance of the FragmentManager to allow for the MainFrag class to link to MainActivity and operate.

        // OnClickListener : Alarm Set Button
        Button button_SetAlarm;
        button_SetAlarm = findViewById(R.id.button_set);
        button_SetAlarm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent button_Press = new Intent();
                startActivity(button_Press);
                getUser_SetAlarm();
                optionSelect();
            }
        });
    }

    AlarmFragment.optionSelect optionSelect, sub_OPTS;
    com.example.reloxo.AlarmFragment.optionSelect optionSelect() {
        optionSelect = sub_OPTS;
        return sub_OPTS;
    }

    // Meed to link this to the button-ID from the resources and XML.
    public EditText getUser_SetAlarm() {
        userActive_SetName = findViewById(R.id.message_varied);
        String onName = userActive_SetName.getText().toString();
        Intent intent_Action = new Intent(this, AlarmActivity.class);
        intent_Action.putExtra(EXTRA_MESSAGE, onName);
        startActivity(intent_Action);
        return userActive_SetName;

    }

    public static TextView get_OnScreenAlert() {
        return onScreen_Alert;
    }

}