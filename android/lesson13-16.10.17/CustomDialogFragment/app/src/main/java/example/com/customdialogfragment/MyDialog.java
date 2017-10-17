package example.com.customdialogfragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by hackeru on 10/16/2017.
 */

public class MyDialog extends DialogFragment implements View.OnClickListener {

    private EditText nameET;
    private Context context;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_name, null);

        nameET = (EditText) view.findViewById(R.id.name_edit_text);

        String name = getArguments().getString("name");

        nameET.setText(name);

        view.findViewById(R.id.dialog_save_button).setOnClickListener(this);

        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .create();
    }



    @Override
    public void onClick(View v) {
        String name = nameET.getText().toString();
        ((OnChangeNameListener)getActivity()).changeDisplay(name);
        dismiss();  // close the dialog.
    }

    /*
    if you decided to override this method DONT forget to override the next one .

    // only for devices version 23 and up.
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    // for devices version 22 and below.
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity;
    }
    */

}
