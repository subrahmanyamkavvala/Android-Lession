package com.practice;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class ToastDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_dialog);
    }
    public void buttonClickAction(View view){
        switch (view.getId()){
            case R.id.button1: showDialog();
                break;
            case R.id.button2: showDialogwithTowButtons();
                break;
            case R.id.button3: showDialogwithThreeButtons();
                break;
        }
    }


    private void showDialog(){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        // Setting Dialog Title
        alertDialog.setTitle("Alert Dialog");

        // Setting Dialog Message
        alertDialog.setMessage("Welcome to Dialog sample..");

        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.small);

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog closed
                Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }
    private void showDialogwithTowButtons(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        // Setting Dialog Title
        alertDialog.setTitle("Confirm Delete...");

        // Setting Dialog Message
        alertDialog.setMessage("Are you sure you want delete this?");

        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.small);

        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {

                // Write your code here to invoke YES event
                Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
            }
        });

        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to invoke NO event
                Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });

        // Showing Alert Message
        alertDialog.show();

    }
    private void showDialogwithThreeButtons(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        // Setting Dialog Title
        alertDialog.setTitle("Save File...");

        // Setting Dialog Message
        alertDialog.setMessage("Do you want to save this file?");

        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.small);

        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // User pressed YES button. Write Logic Here
                Toast.makeText(getApplicationContext(), "You clicked on YES",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // User pressed No button. Write Logic Here
                Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
            }
        });

        // Setting Netural "Cancel" Button
        alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // User pressed Cancel button. Write Logic Here
                Toast.makeText(getApplicationContext(), "You clicked on Cancel",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Showing Alert Message
        alertDialog.show();

    }
}
