package com.coderchain.sa.wishme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class DVSService extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        Intent i = new Intent(context,Wish.class);
        context.startService(i);



    }
}
