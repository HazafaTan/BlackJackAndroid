package com.example.blackjackgame;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

public class LoseDialog extends AppCompatDialogFragment {
    private LoseExampleDialogListner listner;
    /*
     * Create a dialog pop up with options with the option to click restart
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.MyDialogTheme);
        builder.setTitle("GAME OVER")
                .setMessage("YOU LOSE!!!\nDealer Had: " + GAME.DealerValue + "\nYou Had: " + GAME.PlayerValue)
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("RESTART", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    listner.onRESTARTCLICK();
                    }
                });
        return builder.create();
    }
    public interface LoseExampleDialogListner{
        void onRESTARTCLICK();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            listner = (LoseExampleDialogListner) context;

        }catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }
}
