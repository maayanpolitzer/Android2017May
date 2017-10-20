package example.com.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BroadcastReceiver receiver = new MyReceiver();
    private BroadcastReceiver myCustomReceiver = new MyCustomReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        // insert the receiver to OS notification table. (registerReceiver)
        registerReceiver(receiver, new IntentFilter(Intent.ACTION_BATTERY_LOW));
        registerReceiver(myCustomReceiver, new IntentFilter("99fm"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        // delete the receiver from OS. (unregisterReceiver)
        unregisterReceiver(receiver);
        unregisterReceiver(myCustomReceiver);
    }

    @Override
    public void onClick(View v) {
        // trigger action:
        Intent intent = new Intent("99fm");
        intent.putExtra("NAME", "Maayan");  // send params to the receiver
        sendBroadcast(intent);
    }
}
