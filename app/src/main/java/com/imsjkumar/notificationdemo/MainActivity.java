package com.imsjkumar.notificationdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button notificationBTN;
private Context context;
private int notificationCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationBTN = findViewById(R.id.notification_btn);
        context = this;

        notificationBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context ,MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(context , 0,intent,0);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setContentTitle("Notification Title");
                builder.setContentText("Notification Description");
                builder.setContentIntent(pendingIntent);
                builder.setAutoCancel(true);


                NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(notificationCount, builder.build());
                notificationCount++;
            }
        });
    }
}