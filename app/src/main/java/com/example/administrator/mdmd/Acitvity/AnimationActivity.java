package com.example.administrator.mdmd.Acitvity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.administrator.mdmd.Animation.AnimationButton;
import com.example.administrator.mdmd.R;

/**
 * Created by Administrator on 2017/5/15.
 */

public class AnimationActivity extends AppCompatActivity {

    private AnimationButton animationButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_layout);
        animationButton = (AnimationButton) findViewById(R.id.animation_btn);
        animationButton.setAnimationButtonListener(new AnimationButton.AnimationButtonListener() {
            @Override
            public void onClickListener() {
                animationButton.start();
            }

            @Override
            public void animationFinish() {
                Toast.makeText(AnimationActivity.this, "over", Toast.LENGTH_LONG).show();
            }
        });
    }
}
