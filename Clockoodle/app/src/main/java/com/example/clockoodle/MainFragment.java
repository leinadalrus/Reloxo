package com.example.clockoodle;

import android.app.AlarmManager;
import android.os.SystemClock;

import android.os.Bundle;
import android.content.Intent;
import android.view.MenuItem;

import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {
    AlarmManager mainFragment_AlarmManager;
    Intent mainIntent = new Intent(getActivity(), MainActivity.class);
    PendingIntent pendIntent = PendingIntent.getActivity(getActivity(), SubActivity.RC, subIntent, 0);
    // PendingIntent allow outsider/foreign apps to have access to the OS's public code.
    // getActivity() can be replaced by getActivities() if you have an array of Intents:
    // getActivities(Context context, int requestCode, Intent[] intents, int flags)

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public class optionSelect {
        MenuItem primary_AlarmItem;
        {

            if (mainFragment_AlarmManager == null) {

                if (primary_AlarmItem.getItemId() == R.id.alarm_Set) {
                    pendIntent.setAction(Intent.ACTION_MAIN);
                    pendIntent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);

                    MainActivity.alarm_TypeInt = AlarmManager.ELAPSED_REALTIME_WAKEUP;
                    int ms_SecondDelay = 30000;
                    mainFragment_alarmManager.setInexactRepeating(MainActivity.alarm_TypeInt, SystemClock.elapsedRealtime() + ms_SecondDelay,
                            ms_SecondDelay, subPending);

                    mainFragment_AlarmManager = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
                    // You may notice that tha AlarmManager typename is in brackets after an assignment operator.
                    // This is called typecasting and it works as a force typesetter just for this specific assignment
                    // to allow for the use of AlarmManager ready-built functions.
                } else if (mainFragment_AlarmManager != null) mainFragment_AlarmManager.cancel(pendIntent);
            }
        }
    }
}