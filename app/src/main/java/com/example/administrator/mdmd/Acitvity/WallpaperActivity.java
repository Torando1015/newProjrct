package com.example.administrator.mdmd.Acitvity;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.administrator.mdmd.R;
import com.example.administrator.mdmd.Service.CameraLiveWallpaper;
import com.example.administrator.mdmd.Service.VideoLiveWallpaper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/16.
 */

public class WallpaperActivity extends AppCompatActivity {
    private CheckBox mCbVoice;
    private Button button;
    private Button text_btn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wallpager);
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoLiveWallpaper.setToWallPaper(WallpaperActivity.this);
            }
        });
        mCbVoice = (CheckBox) findViewById(R.id.id_cb_voice);
        mCbVoice.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(
                            CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            // 静音
                            VideoLiveWallpaper.voiceSilence(getApplicationContext());
                        } else {
                            VideoLiveWallpaper.voiceNormal(getApplicationContext());
                        }
                    }
                });

        text_btn = (Button) findViewById(R.id.text_btn);
        text_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startWallpaper();
                CameraPermission();
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void CameraPermission() {
        final List<String> permissionsList = new ArrayList<String>();
        List<String> permissionsNeeded = new ArrayList<String>();

        if (!addPermission(permissionsList, Manifest.permission.CAMERA))
            permissionsNeeded.add("CAMERA");

        if (permissionsList.size() > 0) {
            if (permissionsNeeded.size() > 0) {
                requestPermissions(permissionsList.toArray(new String[permissionsList.size()]), 10);
                return;
            }
        }
        Log.e("show", "C");
        startWallpaper();
    }

    @TargetApi(Build.VERSION_CODES.M)
    private boolean addPermission(List<String> permissionsList, String permission) {
        if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission);
            if (!shouldShowRequestPermissionRationale(permission))
                return false;
        }
        return true;
    }

    /**
     * 选择壁纸
     */
    private void startWallpaper() {
        final Intent pickWallpaper = new Intent(Intent.ACTION_SET_WALLPAPER);
        Intent chooser = Intent.createChooser(pickWallpaper, getString(R.string.choose_wallpaper));
        startActivity(chooser);
    }

    /**
     * 不需要手动启动服务
     */
    void setTransparentWallpaper() {
        startService(new Intent(this, CameraLiveWallpaper.class));
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode) {
//            case PERMISSIONS_REQUEST_CAMERA: {
//                // If request is cancelled, the result arrays are empty.
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
////                    setTransparentWallpaper();
//                    startWallpaper();
//                } else {
//                    Toast.makeText(mContext, getString(R.string._lease_open_permissions), Toast.LENGTH_SHORT).show();
//                }
//                return;
//            }
//        }
//    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 10) {
            if (grantResults.length > 0 && (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)) {
                startWallpaper();
            } else {
                Toast.makeText(this, getString(R.string._lease_open_permissions), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
