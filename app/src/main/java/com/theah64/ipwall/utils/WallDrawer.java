package com.theah64.ipwall.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by theapache64 on 5/9/16.
 */
public class WallDrawer {

    private static boolean isInit = false;
    private static int height;
    private static int width;
    private static Canvas canvas;
    private static Bitmap bmp;
    private static Paint paint;

    /**
     * Initializes variables for the first time
     */
    private static void init(final WindowManager wm, final AssetManager am) {

        final DisplayMetrics dp = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dp);
        height = dp.heightPixels;
        width = dp.widthPixels;

        bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        canvas = new Canvas(bmp);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setTypeface(Typeface.createFromAsset(am, "fonts/roboto_thin.ttf"));
        paint.setTextSize(60);
        paint.setTextAlign(Paint.Align.CENTER);

        isInit = true;

    }

    /**
     * Returns Bitmap with current ip address
     */
    public static Bitmap getWallpaper(final AssetManager am, final WindowManager wm, final String ipaddress) {

        if (!isInit) {
            init(wm, am);
        } else {
            //Clearing previous data from bitmap
            bmp.eraseColor(Color.TRANSPARENT);
        }

        //Drawing IP address on the bitmap
        canvas.drawText(ipaddress, width / 2, height / 2, paint);
        return bmp;
    }

}
