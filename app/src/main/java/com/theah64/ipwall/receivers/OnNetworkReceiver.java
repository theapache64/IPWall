package com.theah64.ipwall.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.theah64.ipwall.utils.NetworkManager;

public class OnNetworkReceiver extends BroadcastReceiver {
    public OnNetworkReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {


        final String ipAddress = NetworkManager.getCurrentIPAddress(context);

        if (NetworkManager.isNetwork(context)) {
            Toast.makeText(context, "Network Changed : true " + ipAddress, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Network Changed : false " + ipAddress, Toast.LENGTH_SHORT).show();
        }

    }
}
