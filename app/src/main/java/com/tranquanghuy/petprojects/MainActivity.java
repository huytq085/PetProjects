package com.tranquanghuy.petprojects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnEggTimer;
    private Button btnWeather;
    private Button btnTTT;
    private Button btnGGMaps;
    private Button btnNotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        linkToProject();

    }
    public void setControl(){
        btnEggTimer = findViewById(R.id.btnEggTimer);
        btnWeather = findViewById(R.id.btnWeather);
        btnTTT = findViewById(R.id.btnTTT);
        btnGGMaps = findViewById(R.id.btnGGMaps);
        btnNotes = findViewById(R.id.btnNotes);

    }
    public void linkToProject(){
        btnEggTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), EggTimer.class);
                startActivityForResult(myIntent, 0);
            }
        });
        btnWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Weather.class);
                startActivityForResult(myIntent, 0);
            }
        });
        btnTTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), TicTacToe.class);
                startActivityForResult(myIntent, 0);
            }
        });
        btnGGMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MapsActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
        btnNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), AppNotes.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}
