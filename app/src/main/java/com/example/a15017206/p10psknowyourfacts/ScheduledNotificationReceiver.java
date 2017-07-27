package com.example.a15017206.p10psknowyourfacts;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;

public class ScheduledNotificationReceiver extends BroadcastReceiver {

    int reqCode = 0;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Intent i = new Intent(context, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(context, reqCode, i, PendingIntent.FLAG_CANCEL_CURRENT);

        // build notification
        Notification.Builder builder = new Notification.Builder(context);
        builder.setPriority(Notification.PRIORITY_HIGH);
        builder.setContentTitle("Reminder");
        builder.setContentText("Please continue reading");
        builder.setSmallIcon(android.R.drawable.ic_dialog_info);
        builder.setContentIntent(pIntent);

        Uri uri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(uri);

//        builder.setAutoCancel(true);

        Notification n = builder.build();
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, n);

    }
}
