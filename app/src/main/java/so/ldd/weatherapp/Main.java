package so.ldd.weatherapp;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    private final String tag = "so.ldd.weatherapp";

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(getApplicationContext(), "stage onStart", Toast.LENGTH_SHORT).show();
        Log.d(tag, "stage onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(getApplicationContext(), "stage onStop", Toast.LENGTH_SHORT).show();
        Log.d(tag, "stage onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(getApplicationContext(), "stage onDestroy", Toast.LENGTH_SHORT).show();
        Log.d(tag, "stage onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(getApplicationContext(), "stage onPause", Toast.LENGTH_SHORT).show();
        Log.d(tag, "stage onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(getApplicationContext(), "stage onResume", Toast.LENGTH_SHORT).show();
        Log.d(tag, "stage onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(getApplicationContext(), "stage onRestart", Toast.LENGTH_SHORT).show();
        Log.d(tag, "stage onRestart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Toast.makeText(getApplicationContext(), "stage onRestoreInstanceState", Toast.LENGTH_SHORT).show();
        Log.d(tag, "stage onRestoreInstanceState");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        Toast.makeText(getApplicationContext(), "stage onSaveInstanceState", Toast.LENGTH_SHORT).show();
        Log.d(tag, "stage onSaveInstanceState");
    }

    private void updateView() throws InstantiationException, IllegalAccessException {
        TextView tv = (TextView) findViewById(R.id.celcia);
        String tx = Singleton.getInstance(WeatherData.class).toString() + "c";
        if (tv != null)
            tv.setText(tx);

        TextView cn = (TextView) findViewById(R.id.cityName);
        cn.setText(getResources().getStringArray(R.array.locations)[Singleton.getInstance(WeatherData.class).getCurrentCity()]);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.activity_main);

            updateView();

            Toast.makeText(getApplicationContext(), "stage onCreate", Toast.LENGTH_SHORT).show();
            Log.d(tag, "stage onCreate");

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public void onPlaceSelect(View view) {
        Intent intent = new Intent(this, LocationSelection.class);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        try {
            int city = data.getExtras().getInt("location");
            Singleton.getInstance(WeatherData.class).setCurrentCity(city);

            updateView();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
