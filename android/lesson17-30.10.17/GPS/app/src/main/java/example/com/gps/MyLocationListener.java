package example.com.gps;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.List;

/**
 * Created by hackeru on 10/26/2017.
 */

class MyLocationListener implements LocationListener {

    private Geocoder geocoder;
    private Location lastLocation;
    private MainActivity activity;

    public MyLocationListener(Context context){
        geocoder = new Geocoder(context);
        activity = (MainActivity) context;
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d("TAG", "location changed!");
        Log.d("TAG", location.toString());

        if(lastLocation != null){
            double meters = location.distanceTo(lastLocation);
            Log.d("TAG", "changed by " + meters + " meters");
        }
        lastLocation = location;
        /*
        // GETTING ADDRESS
        try {
            List<Address> addresses = geocoder.getFromLocation(
                    location.getLatitude(),
                    location.getLongitude(),
                    10
            );
            for(int i = 0; i < addresses.size(); i++){
                Log.d("TAG", addresses.get(i).toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("TAG", "onStatusChanged: " + provider + ", status: " + status);
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("TAG", "onProviderEnabled: " + provider);
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("TAG", "onProviderDisabled: " + provider);
    }
}
