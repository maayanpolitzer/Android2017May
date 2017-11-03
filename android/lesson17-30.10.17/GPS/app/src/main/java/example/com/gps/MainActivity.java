package example.com.gps;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    private LocationManager manager;
    private LocationListener listener;
    private boolean working;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startGettingLocations();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 1){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                startGettingLocations();
            }
        }
    }

    /*
    Link to enable GPS with java:
    https://stackoverflow.com/questions/4721449/how-can-i-enable-or-disable-the-gps-programmatically-on-android
     */

    private void startGettingLocations(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            // no permission... need to ask!
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }else{
            // permission already granted.
            manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            if(!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                new AlertDialog.Builder(this)
                        .setTitle("Your GPS is disabled.")
                        .setMessage("In order to use the app, please enable it")
                        .setIcon(android.R.drawable.ic_menu_mylocation)
                        .setPositiveButton("Enable GPS", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivityForResult(intent, 1);
                            }
                        })
                        .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setCancelable(false)
                        .show();
            }else{
                listener = new MyLocationListener(this);
                manager.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER,
                        1000,   // every second.
                        1,      // notify my app when the change is larger than one meter .
                        listener
                );
                working = true;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(working){
            manager.removeUpdates(listener);    // stop notify my listener about location changes.
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1){
            startGettingLocations();
        }
    }
}
