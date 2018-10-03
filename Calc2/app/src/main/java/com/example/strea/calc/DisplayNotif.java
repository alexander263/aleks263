package com.example.strea.calc;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.view.View;

import org.w3c.dom.Text;

public class DisplayNotif extends Service {
    final int NOTIFICATION_ID = 16;
    public DisplayNotif() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public int onStartCommand(Intent intent,int flags, int startId){
        displayNotificaiton("Cпасибо что вы с нами", "Калькулятор успешно запущен!");
        return super.onStartCommand(intent, flags, startId);
    }

    private void displayNotificaiton(String title, String text) {
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent notificationPendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);


        NotificationCompat.Builder notif = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Cпасибо что вы с нами")
                .setContentText("Калькулятор успешно запущен")
                .setColor(getResources().getColor(R.color.colorAccent))
                .setVibrate(new long[]{0, 300, 300, 300})
                .setLights(Color.GRAY, 1000, 5000)
                .setContentIntent(notificationPendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
               .setStyle(new NotificationCompat.BigTextStyle().bigText(text));

        NotificationManager notificationmgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationmgr.notify(NOTIFICATION_ID, notif.build());
    }
    }