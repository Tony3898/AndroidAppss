package com.android.tony.unittwo;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    public static final String myKey = "RemoteInput", myChannel = "Tony";
    NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button list = findViewById(R.id.listbutton);
        Button grid = findViewById(R.id.gridbutton);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListViewActivity.class));
            }
        });

        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GridViewActivity.class));
            }
        });

        final Button intent = findViewById(R.id.intentbutton);
        intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, IntentActivity.class));
            }
        });

        Button pending = findViewById(R.id.pendingbutton);
        pending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pending", Toast.LENGTH_SHORT).show();

                myNotificationChannel();
                NotificationCompat.Builder notification = new NotificationCompat.Builder(MainActivity.this, myChannel);
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Tony3898"));
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 5, intent1, 0);

                notification.setSmallIcon(R.drawable.ic_camera);
                notification.setContentTitle("Tony");
                notification.setContentText("New Message");
                notification.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.self));
                notification.setContentIntent(pendingIntent);
                notification.setAutoCancel(true);
                notification.setDefaults(Notification.DEFAULT_ALL);

                /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                    RemoteInput ri = new RemoteInput.Builder(myKey).setLabel("Replying..").build();
                    NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_camera, "Reply..", pendingIntent).addRemoteInput(ri).build();
                    notification.addAction(action);
                }*/

                manager.notify(1, notification.build());

            }
        });
    }

    public void myNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String name = "My channel Name";
            String desc = "My notification channel";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel(myChannel, name, importance);
            notificationChannel.setDescription(desc);
            manager.createNotificationChannel(notificationChannel);

        }
    }
}
