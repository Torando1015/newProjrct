package com.example.administrator.mdmd.Acitvity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.mdmd.R;
import com.suke.widget.SwitchButton;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Administrator on 2017/4/24.
 */

public class TabLayoutActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout_ac);

        SwitchButton button1 = (SwitchButton) findViewById(R.id.button1);
        TextView tv1 = (TextView) findViewById(R.id.tv1);
        Button button2 = (Button) findViewById(R.id.button2);
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        Button button3 = (Button) findViewById(R.id.button3);
        TextView tv3 = (TextView) findViewById(R.id.tv3);
        Button button4 = (Button) findViewById(R.id.button4);
        TextView tv4 = (TextView) findViewById(R.id.tv4);
        Button button5 = (Button) findViewById(R.id.button5);
        TextView tv5 = (TextView) findViewById(R.id.tv5);
        Button button6 = (Button) findViewById(R.id.button6);
        TextView tv6 = (TextView) findViewById(R.id.tv6);

        button1.setOnClickListener(this);
        button1.setChecked(true);
        button1.isChecked();
        button1.toggle();
        button1.setShadowEffect(true);
        button1.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton switchButton, boolean b) {

            }
        });


        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.button1://A basic message
//                new SweetAlertDialog(this)
//                        .setTitleText("Here's a message!")
//                        .show();
//                break;
            case R.id.button2://A title with a text under
                new SweetAlertDialog(this)
                        .setTitleText("Here's a message!")
                        .setContentText("It's pretty,isn't it?")
                        .show();
                break;
            case R.id.button3://A error message
                new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Oops...")
                        .setContentText("Something went wrong!")
                        .show();
                break;
            case R.id.button4://Show the cancel button and bind listener to it
                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure?")
                        .setContentText("Won't be able to recover this file!")
                        .setCancelText("No,cancel plx!")
                        .setConfirmText("Yes,delete it!")
                        .showCancelButton(true)
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.cancel();
                            }
                        })
                        .show();
                break;
            case R.id.button5://A success message
                new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Good job!")
                        .setContentText("You clicked the button!")
                        .show();
                break;
            case R.id.button6://Show the cancel button and bind listener to it
                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure?")
                        .setContentText("Won't be able to recover this file!")
                        .setConfirmText("Yes,delete it!")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .show();
                break;
        }
    }
}
