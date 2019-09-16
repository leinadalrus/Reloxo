#       Application subjected to an application crash
-       Due to improper use and linkage of Intent, PendingIntent and AlarmManager libraries.
-       May be entitled to further simplification of code.

#        at com.example.reloxo.AlarmFragment.<init>(AlarmFragment.java:15)

/* alarmIntent variable - unable to initialize intent with classes ...
 * Consists of three lines: 14) AlarmManager 15)Intent 16) PeningIntent
 
14)     AlarmManager alarmFragment_AlarmManager;
15)     Intent alarmIntent = new Intent(getActivity(), AlarmActivity.class);
16)     PendingIntent pendIntent = PendingIntent.getActivity(getActivity(), 0, alarmIntent, 0);

#        at com.example.reloxo.AlarmActivity.onCreate(AlarmActivity.java:53)

/*  New instance of AlarmFragment class fails as a property in FragmentTransaction.add()

53)     AlarmFragment alarm_frag = new AlarmFragment();
54)     FragmentTransaction alarmFragment_FragmentTransaction = getSupportFragmentManager().beginTransaction();
56)     alarmFragment_FragmentTransaction.add(alarm_frag, alarm_tag);

#       Possible handling need:

        at android.content.ComponentName.<init>(ComponentName.java:77)
        at android.content.Intent.<init>(Intent.java:4160)
        at com.example.reloxo.AlarmFragment.<init>(AlarmFragment.java:15)
        at com.example.reloxo.AlarmActivity.onCreate(AlarmActivity.java:53)
        at android.app.Activity.performCreate(Activity.java:5990)
        at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1106)
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2278)
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2387) 
        at android.app.ActivityThread.access$800(ActivityThread.java:151) 
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1303) 
        at android.os.Handler.dispatchMessage(Handler.java:102) 
        at android.os.Looper.loop(Looper.java:135) 
        at android.app.ActivityThread.main(ActivityThread.java:5254)
        
/* It appears as though, the main culprits in the relationship
 * between the Activity module and the Intent library.
 * It is trying to invoke the launch and instance creation
 * of the application with the assistance
 * of the Handler library.
