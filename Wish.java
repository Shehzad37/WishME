package com.coderchain.sa.wishme;

import android.app.PendingIntent;
import android.app.Service;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class Wish extends Service {





    public static final String SMS_BUNDLE = "pdus";
    SmsMessage smsMessage;
    String smsBody,r;
    TextView tv;
    IntentFilter f;
    PendingIntent pi;
    int j=1;







    private BroadcastReceiver ir = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {


            String str = "";


            Bundle intentExtras = intent.getExtras();

            if (intentExtras != null) {


                Object[] sms = (Object[]) intentExtras.get(SMS_BUNDLE);


                for (int i = 0; i < sms.length; ++i) {

                    smsMessage = SmsMessage.createFromPdu((byte[]) sms[i]);

                    smsBody = smsMessage.getMessageBody().toString();

                }


            }


            if (smsBody.contains("Happybirthday") || smsBody.contains("happybirthday") || smsBody.contains("Happy birthday") || smsBody.contains("happy birthday") || smsBody.contains("Happy Birthday")) {

                Intent b = new Intent(getApplicationContext(), wishh.class);
                b.putExtra("sms", smsBody);
                b.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(b);

            }


            if (smsBody.contains("Eid mubarak")) {

                Intent b = new Intent(getApplicationContext(), wishh.class);
                b.putExtra("sms", smsBody);
                b.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(b);


            }
        }

    };




    @Override
    public void onCreate() {
        super.onCreate();



        IntentFilter filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");



        registerReceiver(ir, filter);
        // f = new IntentFilter();
        // f.addAction("SMS_RECEIVED_ACTION");
        // registerReceiver(ir, filter);
    }



    public Wish() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
