package com.example.clockoodle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.Button;
import android.view.View;

import com.example.clockoodle.SubFrag.optionSelect;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class SubActivity extends AppCompatActivity {

    public static final String appTag = "SubActivity";
    public static final String appFrag = "AlarmSet_FRAG";

    int hour, minute;

    private static TextView onScreen_Alert, onScreen_Message;

    EditText userActive_SetName, userActive_SetAlarm;

    static int alarm_TypeInt;
    static int RC = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        if (getSupportFragmentManager().findFragmentByTag(appTag) == null) {
            SubFrag subFrag = new SubFrag();
            FragmentTransaction init_SubFragTransaction = getSupportFragmentManager().beginTransaction();
            init_SubFragTransaction.add(subFrag, appFrag);
            init_SubFragTransaction.commit();
        } // Creates a new instance of the FragmentManager to allow for the SubFrag class to link to SubActivity and operate.
        OnClickListener onClick = new OnClickListener() {
            @Override
            public void onClick(View view) {
                onScreen_Message.setText("");
                Bundle onClickBundle = new Bundle();
                onClickBundle.putInt(TimePDM.HAND_HOUR, hour);
                onClickBundle.putInt(TimePDM.HAND_MINUTE, minute);

                DialogManager DMGR = new DialogManager();
                DMGR.setArguments(onClickBundle);

                DialogManager bundle_FRAG = new DialogManager();
                FragmentTransaction init_SubFragTransaction = getSupportFragmentManager().beginTransaction();
                init_SubFragTransaction.add(bundle_FRAG, appFrag);
                init_SubFragTransaction.commit();
            }
        };
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

    SubFrag.optionSelect optionSelect, sub_OPTS;
    com.example.clockoodle.SubFrag.optionSelect optionSelect() {
        optionSelect = sub_OPTS;
        return sub_OPTS;
    }

    // Meed to link this to the button-ID from the resources and XML.

    public EditText getUser_SetAlarm() {
        userActive_SetName = findViewById(R.id.message_Vary);
        String onName = userActive_SetName.getText().toString();
        Intent intent_Action = new Intent(this, SubActivity.class);
        intent_Action.putExtra(EXTRA_MESSAGE, onName);
        startActivity(intent_Action);
        return userActive_SetName;
    }


    public static TextView get_OnScreenAlert() {
        return onScreen_Alert;
    }
}