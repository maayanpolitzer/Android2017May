package example.com.files;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //writeToFile("This is internal storage");
        readFromFile("myFile.txt");

    }

    private void readFromFile(String fileName){
        try {
            FileInputStream in = new FileInputStream(new File(getFilesDir(), fileName));
            byte[] buffer = new byte[1024];
            int actuallyRead;
            StringBuilder sb = new StringBuilder();
            while((actuallyRead = in.read(buffer)) != -1){
                sb.append(new String(buffer, 0, actuallyRead));
            }
            Log.d("TAG", sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile(String content){
        File file = new File(getFilesDir(), "myFile.txt");
        try {
            FileOutputStream out = new FileOutputStream(file);
            out.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
