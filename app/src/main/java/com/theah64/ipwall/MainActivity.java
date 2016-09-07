package com.theah64.ipwall;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.service.wallpaper.WallpaperService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.theah64.ipwall.utils.NetworkManager;
import com.theah64.ipwall.utils.WallDrawer;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Hiding app icon
        getPackageManager().setComponentEnabledSetting(getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        Toast.makeText(this, R.string.Thank_you, Toast.LENGTH_LONG).show();

        final String ipAddress = NetworkManager.getCurrentIPAddress();
        Toast.makeText(this, "IP: " + ipAddress, Toast.LENGTH_LONG).show();

        final WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        final Bitmap wallpaper = WallDrawer.getWallpaper(getAssets(), wm, ipAddress);

        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        try {
            wallpaperManager.setBitmap(wallpaper);
        } catch (IOException e) {
            e.printStackTrace();
        }

        finish();
    }


}
