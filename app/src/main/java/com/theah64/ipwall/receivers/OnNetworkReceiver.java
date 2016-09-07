package com.theah64.ipwall.receivers;

import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.WindowManager;
import android.widget.Toast;

import com.theah64.ipwall.R;
import com.theah64.ipwall.utils.NetworkManager;
import com.theah64.ipwall.utils.WallDrawer;

import java.io.IOException;

public class OnNetworkReceiver extends BroadcastReceiver {
    public OnNetworkReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        final String ipAddress = NetworkManager.getCurrentIPAddress();

        Toast.makeText(context.getApplicationContext(), "IP: " + ipAddress, Toast.LENGTH_LONG).show();

        final WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        final Bitmap wallpaper = WallDrawer.getWallpaper(context.getAssets(), wm, ipAddress);

        WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);
        try {
            wallpaperManager.setBitmap(wallpaper);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
