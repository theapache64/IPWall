package com.theah64.ipwall.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;

/**
 * Created by theapache64 on 5/9/16.
 */
public class NetworkManager {
    public static boolean isNetwork(final Context context) {
        final ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public static String getCurrentIPAddress(final Context context) {
        final WifiManager wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        final String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
        return ip;
    }
}
