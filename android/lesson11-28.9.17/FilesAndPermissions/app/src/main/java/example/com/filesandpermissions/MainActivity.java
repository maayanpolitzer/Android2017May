package example.com.filesandpermissions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    public static final String[] perm = {
            Manifest.permission.CAMERA,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
                                        };

    private static final int WRITE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // multiple permissions.
        ArrayList<String> requests = new ArrayList<>();
        for(String p : perm){
            if(ContextCompat.checkSelfPermission(this, p) != PackageManager.PERMISSION_GRANTED){
                requests.add(p);
            }
        }
        if(requests.isEmpty()){
            //writeToFile();
            readFromFile();
        }else {
            String[] s = requests.toArray(new String[requests.size()]);// ??? check if works
            ActivityCompat.requestPermissions(this, s, 2);
        }

/*
        // only one permission.
        // only dangerous permissions...
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            // no permission!!!
            // request permission..
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},WRITE_REQUEST_CODE);
        }else{
            // will call if permission already granted!
            writeToFile();
        }
        */
    }

    private void readFromFile(){
        File file = new File(Environment.getExternalStorageDirectory(), "maayan.txt");
        try {
            FileInputStream in = new FileInputStream(file);
            StringBuilder sb = new StringBuilder();
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while((line = reader.readLine()) != null){
                sb.append(line);
            }
            Log.d("TAG", sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile(){
        File file = new File(Environment.getExternalStorageDirectory(), "maayan.txt");
        try {
            FileOutputStream out = new FileOutputStream(file);
            out.write("wow its working!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == WRITE_REQUEST_CODE){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                // will call if the user allow NOW!
                writeToFile();
            }
        }
    }
}
