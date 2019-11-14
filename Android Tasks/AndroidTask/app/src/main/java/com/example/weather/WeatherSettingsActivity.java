package com.example.weather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WeatherSettingsActivity extends Activity {
    private EditText cityName;
    private Switch humidity, pressure, windSpeed;
    private Button backButton;
    private RadioButton moscow, saintPetersburg, other;
    private String cityNameValue;

    //Теги
    private static final String TAG = "WeatherSettingsActivity";
    public static final String HUMIDITY = "WeatherSettingsActivityHumidity";
    public static final String PRESSURE = "WeatherSettingsActivityPressure";
    public static final String WIND_SPEED = "WeatherSettingsActivityWindSpeed";
    public static final String CITY_NAME = "WeatherSettingsCityName";
    public static final String CITY_MOSCOW = "WeatherSettingsActivityCityMoscow";
    public static final String CITY_PETERBURG = "WeatherSettingsActivityCityPeterburg";
    public static final String CITY_OTHER = "WeatherSettingsActivityCityOther";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showLog("OnCreate");
        setContentView(R.layout.weather_settings);

        humidity = findViewById(R.id.weather_settings_humidity);
        pressure = findViewById(R.id.weather_settings_pressure);
        windSpeed = findViewById(R.id.weather_settings_wind_speed);
        backButton = findViewById(R.id.weather_settings_button_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickOnBackButton();
            }
        });

        cityName = findViewById(R.id.weather_settings_city_other_change);
        moscow = findViewById(R.id.weather_settings_city_moscow);
        saintPetersburg = findViewById(R.id.weather_settings_city_saint_petersburg);
        other = findViewById(R.id.weather_settings_city_other);

        restoreData(savedInstanceState);
        getSwitchStateFromMain();
    }

    @Override
    public void onBackPressed() {
        clickOnBackButton();
    }

    private void clickOnBackButton() {
        if (otherCityCheckValue()) {
            cityNameValue = cityName.getText().toString();
            prepareResult();
            finish();
        }
    }

    private void getSwitchStateFromMain() {
        humidity.setChecked(getIntent().getBooleanExtra(HUMIDITY, false));
        pressure.setChecked(getIntent().getBooleanExtra(PRESSURE, false));
        windSpeed.setChecked(getIntent().getBooleanExtra(WIND_SPEED, false));
        moscow.setChecked(getIntent().getBooleanExtra(CITY_MOSCOW, true));
        saintPetersburg.setChecked(getIntent().getBooleanExtra(CITY_PETERBURG, false));
        other.setChecked(getIntent().getBooleanExtra(CITY_OTHER, false));
        cityName.setText(getIntent().getStringExtra(CITY_NAME));
    }

    private void prepareResult() {
        Intent intent = new Intent();
        intent.putExtra(PRESSURE, pressure.isChecked());
        intent.putExtra(HUMIDITY, humidity.isChecked());
        intent.putExtra(WIND_SPEED, windSpeed.isChecked());
        intent.putExtra(CITY_MOSCOW, moscow.isChecked());
        intent.putExtra(CITY_PETERBURG, saintPetersburg.isChecked());
        intent.putExtra(CITY_OTHER, other.isChecked());
        intent.putExtra(CITY_NAME, cityNameValue);

        setResult(RESULT_OK, intent);
    }

    public boolean otherCityCheckValue() {
        if (other.isChecked() & cityName.getText().toString().equals("")) {
            Toast.makeText(this, "Выберите город", Toast.LENGTH_SHORT).show();
            return false;
        } else return true;
    }

    private void restoreData(Bundle savedInstanceState) {
        if (savedInstanceState == null) return;
        cityName.setText(savedInstanceState.getString(CITY_NAME, getString(R.string.novosibirsk)));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(CITY_NAME, cityName.getText().toString());
    }

    //Выводим логи по событиям активностей

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
