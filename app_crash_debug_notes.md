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