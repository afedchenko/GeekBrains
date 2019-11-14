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
        showLog("OnCreate");
        setContentView(R.layout.weather_settings);

        findViewById(R.id.weather_settings_button_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickOnBackButton();
            }
        });

        cityName = findViewById(R.id.weather_settings_city_other_change);
        restoreData(savedInstanceState);


    }

    void clickOnBackButton(){
        finish();
    }

    private void restoreData(Bundle savedInstanceState) {
        if(savedInstanceState == null) return;
        cityName.setText(savedInstanceState.getString(CITY_NAME, getString(R.string.novosibirsk)));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(CITY_NAME, cityName.getText().toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        showLog("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showLog("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showLog("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showLog("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showLog("onDestroy");
    }

    private void showLog(String logMessage) {
        Log.d(TAG, logMessage);
        //Toast.makeText(getApplicationContext(), logMessage, Toast.LENGTH_SHORT).show();
    }
}
