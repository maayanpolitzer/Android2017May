package example.com.dialogfragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyListener {

    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = getIntent().getStringExtra("NAME");
        if(name == null){
            name = "Maayan";
        }
    }

    public void launchDialog(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("name", name);

        MyDialogFragment dialog = new MyDialogFragment();


        dialog.setArguments(bundle);
        dialog.show(getFragmentManager(), null);
        /*
        new AlertDialog.Builder(this)
                .setTitle("title")
                .setMessage("Are you sure " + name)
                .setPositiveButton("Ehud", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Gal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNeutralButton("Yoel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setCancelable(false)
                .setIcon(R.mipmap.ic_launcher)
                .show();
                */
    }

    @Override
    public void displayToast(String message) {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void closeApp(){
        finish();
    }

}
