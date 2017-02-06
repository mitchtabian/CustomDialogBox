package com.tabian.customdialogbox;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button mButton1,mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1 = (Button) findViewById(R.id.button1);
        mButton2 = (Button) findViewById(R.id.button2);

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog("Dialog Box 1","This is Dialog Box 1", "cancelMethod1","okMethod1");
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog("Dialog Box 2","This is Dialog Box 2", "cancelMethod2","okMethod2");
            }
        });
    }

    private void cancelMethod1(){
        Log.d(TAG, "cancelMethod1: Called.");
        toastMessage("Cancel Method1.");
    }
    private void cancelMethod2(){
        Log.d(TAG, "cancelMethod2: Called.");
        toastMessage("Cancel Method2.");
    }
    private void okMethod1(){
        Log.d(TAG, "okMethod1: Called.");
        toastMessage("OK Method1.");
    }
    private void okMethod2(){
        Log.d(TAG, "okMethod2: Called.");
        toastMessage("OK Method2.");
    }




    /**
     * Custom alert dialog that will execute method in the class
     * @param title
     * @param message
     * @param cancelMethod
     * @param okMethod
     */
    public void customDialog(String title, String message, final String cancelMethod, final String okMethod){
        final android.support.v7.app.AlertDialog.Builder builderSingle = new android.support.v7.app.AlertDialog.Builder(this);
        builderSingle.setIcon(R.mipmap.ic_notification);
        builderSingle.setTitle(title);
        builderSingle.setMessage(message);

        builderSingle.setNegativeButton(
                "Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG, "onClick: Cancel Called.");
                        if(cancelMethod.equals("cancelMethod1")){
                            cancelMethod1();
                        }
                        else if(cancelMethod.equals("cancelMethod2")){
                            cancelMethod2();
                        }

                    }
                });

        builderSingle.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d(TAG, "onClick: OK Called.");
                        if(okMethod.equals("okMethod1")){
                            okMethod1();
                        }
                        else if(okMethod.equals("okMethod2")){
                            okMethod2();
                        }
                    }
                });


        builderSingle.show();
    }

    /**
     * customizable toast
     * @param message
     */
    public void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
