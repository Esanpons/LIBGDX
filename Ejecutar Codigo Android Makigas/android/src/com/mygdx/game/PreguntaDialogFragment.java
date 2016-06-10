package com.mygdx.game;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Zan on 10/06/2016.
 */

public class PreguntaDialogFragment extends DialogFragment {

    private DialogListener listener;

    public PreguntaDialogFragment(DialogListener listener) {

        this.listener = listener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity())
                 .setTitle("Atencio pregunta")
                .setMessage("estasSeguro?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       listener.onPressYes();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onPressNo();
                    }
                });

        return builder.create();

    }
}
