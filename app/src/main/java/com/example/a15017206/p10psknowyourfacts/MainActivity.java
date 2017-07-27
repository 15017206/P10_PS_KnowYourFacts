package com.example.a15017206.p10psknowyourfacts;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Fragment> al;
    MyFragmentPagerAdapter adapter;
    ViewPager vPager;
    Button btnReadLater;
    int reqCode = 0;

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("hkk", vPager.getCurrentItem());
        editor.apply();

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        int b = preferences.getInt("hkk", 0);
        vPager.setCurrentItem(b);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vPager = (ViewPager) findViewById(R.id.viewpager1);
        btnReadLater = (Button) findViewById(R.id.btnReadLater);

        FragmentManager fm = getSupportFragmentManager();

        al = new ArrayList<Fragment>();
        al.add(new Frag1());
        al.add(new Frag2());
        al.add(new Frag3());

        adapter = new MyFragmentPagerAdapter(fm, al);

        vPager.setAdapter(adapter);

        btnReadLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmManager am = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND, 2);

                Intent intent = new Intent(MainActivity.this, ScheduledNotificationReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, reqCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);



                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.previous:
                Toast.makeText(this, "previous", Toast.LENGTH_SHORT).show();
                if (vPager.getCurrentItem() > 0) {
                    int previousPage = vPager.getCurrentItem() - 1;
                    vPager.setCurrentItem(previousPage, true);
                }
                return true;

            case R.id.random:
                Toast.makeText(this, "random", Toast.LENGTH_SHORT).show();
                Random r = new Random();
                int i = r.nextInt(vPager.getChildCount());
                vPager.setCurrentItem(i);
                return true;

            case R.id.next:
                Toast.makeText(this, "next", Toast.LENGTH_SHORT).show();
                int max = vPager.getChildCount();
                if (vPager.getCurrentItem() < max - 1) {
                    int nextPage = vPager.getCurrentItem() + 1;
                    vPager.setCurrentItem(nextPage, true);
                }

                return true;
        }

        return false;
    }
}
