package example.com.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by hackeru on 10/19/2017.
 */

public class MyCustomReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // display the params in toast
        String name = intent.getStringExtra("NAME");
        Toast.makeText(context, "Lets dance: " + name, Toast.LENGTH_SHORT).show();
    }
}
