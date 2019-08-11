package com.example.clockoodle;


import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;

public abstract class TimePDM extends SubActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_sub);
    }

    public static final String HAND_HOUR = "hour";
    public static final String HAND_MINUTE = "minute";

    Context ctxt;
    TimePickerDialog.OnTimeSetListener listener;
    boolean is_24h;
    int hrs, mins;

    public static final String MANAGER = "manager";

    public TimePDM(Context context, TimePickerDialog.OnTimeSetListener onListener, int hour,
                   int minute, boolean is_24Hours){
        ctxt = context;
        hrs = hour;
        mins = minute;
        is_24h = is_24Hours;
        listener = onListener;
    }
}
