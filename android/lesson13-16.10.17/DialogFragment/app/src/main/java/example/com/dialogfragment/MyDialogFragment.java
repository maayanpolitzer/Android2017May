package example.com.dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by hackeru on 10/16/2017.
 */

public class MyDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        Bundle bundle = getArguments();
        String name = bundle.getString("name");

        return new AlertDialog.Builder(getActivity())
                .setTitle("Are you sure " + name)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // finish the activity...
                        ((MyListener)getActivity()).closeApp();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((MyListener)getActivity()).displayToast("working");
                    }
                })
                .create();
    }


}
