package com.learning.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private NotificationManager notificationManager;
    private Notification notification;
    private PendingIntent pendingIntent;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create NotificationManager
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        intent = new Intent(this,NotificationActivity.class);
        pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        //check the version
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("shao","testing notification",notificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
        }

        //Using Builder Constructor to create Notification object
        notification = new NotificationCompat.Builder(this,"shao")
                .setContentTitle("No Enough Money!!!")
                .setContentText("please check if you are using the correct credit card.")
                .setSmallIcon(R.drawable.alipay)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.alipay))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();
    }

    public void sendNotification(View view){
        notificationManager.notify(1,notification);
    }
    public void cancelNotification(View view){
        notificationManager.cancel(1);
    }
}