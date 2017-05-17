package com.example.administrator.mdmd.Utils;

import android.util.Log;

/**
 * Created by Administrator on 2017/5/16.
 */

public class L {
    private static final String sTag = "WallPaper";

    public static void d(String msg, Object... params) {

        Log.d(sTag, String.format(msg, params));

    }
}
