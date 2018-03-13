package com.tranquanghuy.petprojects;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Huy on 3/7/2018.
 */

public class EggTimer extends AppCompatActivity{
    private SeekBar sbTimer;
    private TextView tvTimer;
    private Button btnGo;
    private boolean hasStarted = false;
    CountDownTimer waitTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg_timer);
        setControl();

        sbTimer.setMax(600);
        sbTimer.setProgress(30);
        sbTimer.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateTimer(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void setControl(){
        sbTimer = findViewById(R.id.sbTimer);
        tvTimer = findViewById(R.id.tvTimer);
        btnGo = findViewById(R.id.btnGo);
    }
    public void controlTimer(View view) {
        if (waitTimer == null){
            waitTimer = new CountDownTimer(sbTimer.getProgress() * 1000, 1000){

                @Override
                public void onTick(long l) {
                    Log.d("test", "onTick: " + l/1000);
                    updateTimer((int) l/1000);
                }

                @Override
                public void onFinish() {
                    tvTimer.setText("0:00");
                    btnGo.setText("Go!");
                }
            }.start();
            btnGo.setText("Stop!");
        } else {
            waitTimer.cancel();
            waitTimer = null;
            btnGo.setText("Go!");
        }
    }

    public void updateTimer(int secondsLeft){
        int minutes = (int) secondsLeft / 60;
        int seconds = secondsLeft - minutes * 60;
        String secondsString = Integer.toString(seconds);
        if (seconds <= 9){
            secondsString = "0" + secondsString;
        }
        tvTimer.setText(Integer.toString(minutes) + " : " + secondsString);
    }
}
