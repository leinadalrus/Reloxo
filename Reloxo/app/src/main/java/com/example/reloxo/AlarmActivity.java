package com.example.reloxo;

import android.provider.AlarmClock;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View.OnClickListener;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Message;
import android.os.Handler;

public class AlarmActivity extends FragmentActivity {

    static int alarm_TypeInt;

    public static final String alarm_tag = "AlarmActivity";
    public final String EXTRA_INTENT = "com.example.reloxo.AlarmActivity.EXTRA_INTENT";
    public final String EXTRA_FRAGMENT = "com.example.reloxo.AlarmActivity.EXTRA_FRAGMENT";

    AlarmFragment alarmfragment;

    Handler handler; // Handler variable for thread messaging.

    // @Override create all new instances of values when app is re/started
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        alarmfragment = new AlarmFragment();

        Intent intent = new Intent(this, AlarmFragment.class);
        intent.putExtra(EXTRA_INTENT, 0);
        PendingIntent pend = PendingIntent.getActivity(this, 6565, intent,
            PendingIntent.FLAG_CANCEL_CURRENT); /*
            6565 is the requestcode, and is 'AA' (for AlarmActivity) in Decimal.
            If we have an existing PendingIntent
            - cancel it, and launch new data; */
            // FLAG_UPDATE_CURRENT will just update the current PendingIntent.
        this.startActivity(intent);

        // OnClickListener : Alarm Set Button
        Button button_SetAlarm;
        button_SetAlarm = findViewById(R.id.button_set);
        button_SetAlarm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent button_Intent = new Intent();
                startActivity(button_Intent);
                buttonSet();
            }
        });

        Button button_StopAlarm;
        button_StopAlarm = findViewById(R.id.button_stop);
        button_StopAlarm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent button_Intent = new Intent();
                startActivity(button_Intent);
                buttonStop();
            }
        });
    }

    AlarmFragment.buttonSet buttonSet, buttonSet_Operation;
    com.example.reloxo.AlarmFragment.buttonSet buttonSet() {
        buttonSet = buttonSet_Operation;
        return buttonSet_Operation;
    }

    AlarmFragment.buttonStop buttonStop, buttonStop_Operation;
    com.example.reloxo.AlarmFragment.buttonStop buttonStop() {
        buttonStop = buttonStop_Operation;
        return buttonStop_Operation;
    }

}