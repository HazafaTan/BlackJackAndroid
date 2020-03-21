package com.example.blackjackgame;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

public class WinDialog extends AppCompatDialogFragment {
    private ExampleDialogListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (ExampleDialogListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }

    /*
    * Create a dialog pop up with options with the option to click restart
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.MyDialogTheme);
        builder.setTitle("GAME OVER")
                .setMessage("YOU WIN\nDealer Had: " + GAME.DealerValue + "\nYou Had: " + GAME.PlayerValue )
                .setPositiveButton("RESTART", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("RESTART?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            listener.onYESClicked();
            }
        });
        return builder.create();
    }public interface ExampleDialogListener{
        void onYESClicked();
    }

}
