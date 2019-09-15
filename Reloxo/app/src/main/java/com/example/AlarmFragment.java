package com.example.reloxo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Message;
import android.os.SystemClock;
import android.os.Handler;

import android.os.Bundle;
import android.content.Intent;
import android.view.MenuItem;

import androidx.fragment.app.Fragment;

public class AlarmFragment extends Fragment {
    AlarmManager alarmFragment_AlarmManager;
    Intent alarmIntent = new Intent(getActivity(), AlarmActivity.class);
    PendingIntent pendIntent = PendingIntent.getActivity(getActivity(), 0, alarmIntent, 0);
    // PendingIntent allow outsider/foreign apps to have access to the OS's public code.
    // getActivity() can be replaced by getActivities() if you have an array of Intents:
    // getActivities(Context context, int requestCode, Intent[] intents, int flags)

    Handler handler; // Thread Messaging Handler (with Looper looper capabilities).

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        /*
         * Bundler bund // (bundle variable) needs to be initiated
         * bund // Needs to be called into class button_set{}
         * bund // Must receive and update AlarmManager data
         */
    }

    public class button_set {
        MenuItem primary_AlarmItem;
        Handler handler;
        {

            if (alarmFragment_AlarmManager == null) {

                if (primary_AlarmItem.getItemId() == R.id.button_set) {

                    AlarmActivity.alarm_TypeInt = AlarmManager.ELAPSED_REALTIME_WAKEUP;
                    int ms_SecondDelay = 30000;
                    alarmFragment_AlarmManager.setInexactRepeating(AlarmActivity.alarm_TypeInt, SystemClock.elapsedRealtime() + ms_SecondDelay,
                            ms_SecondDelay, pendIntent);

                    alarmFragment_AlarmManager = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
                    // You may notice that tha AlarmManager typename is in brackets after an assignment operator.
                    // This is called typecasting and it works as a force typesetter just for this specific assignment
                    // to allow for the use of AlarmManager ready-built functions.

                    for (int i = 0; i < 20; i++) {
                        this.handler.post(new Thread() {
                            void msgRunner(Message msg) {
                                if (msg.what == 0) {
                                    Bundle b = msg.getData();
                                }
                            }
                        });
                    }   // Thread Message Handler, loops under 20 times, updating received data,
                        // while setting alarm.
                } else if (alarmFragment_AlarmManager != null) alarmFragment_AlarmManager.cancel(pendIntent);
            }
        }
    }

    public class button_stop {
        MenuItem secondary_AlarmItem;
        {
            if (secondary_AlarmItem.getItemId() == R.id.button_stop) {
                if (alarmFragment_AlarmManager != null)
                    alarmFragment_AlarmManager.cancel(pendIntent);
            }
        }
    }
}