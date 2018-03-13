package com.tranquanghuy.petprojects;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Huy on 3/8/2018.
 */

public class Weather extends AppCompatActivity {
    private final String TAG = "check";
    private Button btnFindWeather;
    private EditText etCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        setControl();
    }
    private void setControl(){
        btnFindWeather = findViewById(R.id.btnWeather);
        etCity = findViewById(R.id.etCIty);
    }
    public void findWeather(View view){
        Log.d(TAG, "city: " + etCity.getText().toString());
    }
}
