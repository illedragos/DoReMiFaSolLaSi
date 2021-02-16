package com.example.doremifasollasi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private SoundPool soundPool;
    private int do_key,re_key,mi_key,fa_key,sol_key,la_key,si_key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(7)
                    .setAudioAttributes(audioAttributes)
                    .build();
        }
        else{
            soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC,0);
        }

        do_key = soundPool.load(this,R.raw.key1do,1);
        re_key = soundPool.load(this,R.raw.key2re,1);
        mi_key = soundPool.load(this,R.raw.key3mi,1);
        fa_key = soundPool.load(this,R.raw.key4fa,1);
        sol_key =soundPool.load(this,R.raw.key5la,1);
        la_key = soundPool.load(this,R.raw.key5la,1);
        si_key = soundPool.load(this,R.raw.key6si,1);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                soundPool.play(do_key,1,1,0,0,1);
                break;
            case R.id.button2:
                soundPool.play(re_key,1,1,0,0,1);
                break;
            case R.id.button3:
                soundPool.play(mi_key,1,1,0,0,1);
                break;
            case R.id.button4:
                soundPool.play(fa_key,1,1,0,0,1);
                break;
            case R.id.button5:
                soundPool.play(sol_key,1,1,0,0,1);
                break;
            case R.id.button6:
                soundPool.play(la_key,1,1,0,0,1);
                break;
            case R.id.button7:
                soundPool.play(si_key,1,1,0,0,1);
                break;
            default:
                break;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(soundPool!=null){
            soundPool.release();
            soundPool=null;
        }
    }
}