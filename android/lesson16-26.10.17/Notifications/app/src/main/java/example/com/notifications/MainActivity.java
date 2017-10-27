package example.com.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.telephony.SmsManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private NotificationManager manager;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

    }

    public void btnClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        PendingIntent pi = PendingIntent.getActivity(this, 1, intent, 0);   // performs - startActivity(intent);

        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("You've got a new message")
                .setContentText("Yossi: How are you? " + counter++)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),android.R.drawable.ic_menu_send))
                .setContentIntent(pi)
                .addAction(R.mipmap.ic_launcher, "Exit app", pi)
                .addAction(android.R.drawable.btn_radio, "play music", pi)
                .build();

        manager.notify(78,notification);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //manager.cancelAll();
    }


    public void sendSMS(){
        // need permission...
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(
                "05234593632",
                null,
                "Hi man whats up?",
                PendingIntent.getBroadcast(this, 1, new Intent("SMS SENT"),0),    // perform - sendBroadcast(intent) cellcom got this sms.
                PendingIntent.getBroadcast(this, 2, new Intent("SMS DELIVERED"), 0) // 05234593632 got the sms.
                );
    }

}
