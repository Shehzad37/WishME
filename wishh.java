package com.coderchain.sa.wishme;

import android.app.WallpaperManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.ActivityCompat;
import java.io.IOException;

public class wishh {

    ImageView iv;
    String s;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        iv = (ImageView)findViewById(R.id.imageView);
        tv = (TextView)findViewById(R.id.textView);


        Intent i = getIntent();
       s =  i.getStringExtra("sms");



        if(s.contains("Happybirthday")){

//            iv.setImageResource(R.drawable.bday);
            tv.setText(s);
            MediaPlayer mp1 = MediaPlayer.create(this, R.raw.hbd);
            mp1.start();


            WallpaperManager myWallpaperManager
                    = WallpaperManager.getInstance(getApplicationContext());
            try {
                myWallpaperManager.setResource(R.raw.bday);
            } catch (IOException e) {

                e.printStackTrace();
            }


        }

        if(s.contains("Eid mubarak")){

           // iv.setImageResource(R.drawable.eid);
            tv.setText(s);


            MediaPlayer mp1 = MediaPlayer.create(this, R.raw.eod);
            mp1.start();



            WallpaperManager myWallpaperManager
                    = WallpaperManager.getInstance(getApplicationContext());
            try {
                myWallpaperManager.setResource(R.raw.eid);
            } catch (IOException e) {

                e.printStackTrace();
            }


        }


    }
}
