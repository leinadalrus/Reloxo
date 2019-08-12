package com.example.clockoodle;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TimePicker;

import androidx.fragment.app.DialogFragment;

public class DialogManager extends DialogFragment {
    private int hour, minute;
    Handler handler;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle onDialogBundle = getArguments();
        this.hour = onDialogBundle.getInt(TimePDM.HAND_HOUR, hour);
        this.minute = onDialogBundle.getInt(TimePDM.HAND_MINUTE, minute);

        TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker tp, int hour_, int minute_) {
                hour = hour_;
                minute = minute_;
                Bundle bundle_Data = new Bundle();
                bundle_Data.putInt(TimePDM.HAND_HOUR, hour_);
                bundle_Data.putInt(TimePDM.HAND_MINUTE, minute_);
                Message msg = new Message();
                msg.setData(bundle_Data);
                handler.sendMessage(msg);
                handler.sendMessage(msg);
            }
        };
        return new TimePickerDialog(getActivity(), listener, hour, minute, false);
    }
}
