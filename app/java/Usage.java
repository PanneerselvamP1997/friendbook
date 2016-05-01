package com.example.aishafarheen.frienbookfinal;

import android.app.Service;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;
import java.util.ListIterator;

public class Usage extends Service {


    //Context context=this;

    public Usage() {
    }

   /* long count = 0;
    long max = 0;
    String name;*/

    @Override
    public void onCreate() {
        super.onCreate();
      //  Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
      //  startActivity(intent);

        Toast temp = Toast.makeText(Usage.this, "service run", Toast.LENGTH_SHORT);
        temp.show();

    }

   /* @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast temp = Toast.makeText(Usage.this, "service run", Toast.LENGTH_SHORT);
        temp.show();
      /*  Calendar beginCal = Calendar.getInstance();
        beginCal.set(Calendar.DATE, 1);
        beginCal.set(Calendar.MONTH, 0);
        beginCal.set(Calendar.YEAR, 2016);

        Calendar endCal = Calendar.getInstance();
        endCal.set(Calendar.DATE, 14);
        endCal.set(Calendar.MONTH, 4);
        endCal.set(Calendar.YEAR, 2016);
        Context context = getApplicationContext();
        final UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService(Context.USAGE_STATS_SERVICE);

        final List<UsageStats> queryUsageStats = usageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, beginCal.getTimeInMillis(), endCal.getTimeInMillis());

        for(ListIterator<UsageStats> iter = queryUsageStats.listIterator(); iter.hasNext(); ) {
            UsageStats element = iter.next();
            Log.d(String.valueOf(element.getTotalTimeInForeground()/60000),element.getPackageName());
           long x = element.getTotalTimeInForeground() / 60000;

            if (element.getPackageName().equals("com.amazon.kindle")) {
                count = count + x;
                if (max < x) {
                    max = x;
                    name = element.getPackageName();
                }
            }
            if (element.getPackageName().equals("com.quora.android")) {
                count = count + x;
                if (max < x) {
                    max = x;
                    name = element.getPackageName();

                }
            }
            if (element.getPackageName().equals("flipboard.app")) {
                count = count + x;
                if (max < x) {
                    max = x;
                    name = element.getPackageName();
                }
            }
            if (element.getPackageName().equals("com.medium.reader")) {
                count = count + x;
                if (max < x) {
                    max = x;
                    name = element.getPackageName();
                }
            }
            if (element.getPackageName().equals("com.toi.reader.activities")) {
                count = count + x;
                if (max < x) {
                    max = x;
                    name = element.getPackageName();
                }
            }
            if (element.getPackageName().equals("com.eterno")) {
                count = count + x;
                if (max < x) {
                    max = x;
                    name = element.getPackageName();
                }
            }
            Log.d(String.valueOf(max), name);

              Log.d(String.valueOf(element.getTotalTimeInForeground()/60000), element.getPackageName());



        } return super.onStartCommand(intent, flags, startId);
    }
   */

     //   return 1;
    //}

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Intent intents = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
        startActivity(intents);

        return null;
    }
}
