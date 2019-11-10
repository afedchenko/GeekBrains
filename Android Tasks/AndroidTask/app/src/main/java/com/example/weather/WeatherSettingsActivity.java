package com.example.weather;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WeatherSettingsActivity extends Activity {
    private static final String TAG = "WeatherSettingsActivity";
    private EditText cityName;
    private static String CITY_NAME = "city_name";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"OnCreate");
        Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.weather_settings);

        findViewById(R.id.buttonBackToMain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickOnBackButton();
            }
        });

        cityName = findViewById(R.id.changeCityName);
        restoreData(savedInstanceState);
    }

    private void restoreData(Bundle savedInstanceState) {
        if(savedInstanceState == null) return;
        cityName.setText(savedInstanceState.getString(CITY_NAME, "@string/saint_petersburg"));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(CITY_NAME, cityName.getText().toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
        Toast.makeText(getApplicationContext(), "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
        Toast.makeText(getApplicationContext(), "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_SHORT).show();
    }

    void clickOnBackButton(){
        finish();
    }
}
