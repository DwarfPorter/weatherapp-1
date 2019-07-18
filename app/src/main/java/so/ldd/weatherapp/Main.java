package so.ldd.weatherapp;

import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Signature;

public class Main extends AppCompatActivity {

    private final String tag = "so.ldd.weatherapp";

    private SingletonMain mainPresenter;

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

    private void updateView() {
        TextView tv = (TextView) findViewById(R.id.celcia);
        tv.setText(((Integer)mainPresenter.getWeatherData().getCurrent().getTemperature()).toString());

        TextView cn = (TextView) findViewById(R.id.cityName);
        cn.setText(mainPresenter.getWeatherData().getCurrent().getCurrentCityName());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter = SingletonMain.getInstance();
        mainPresenter.setWeatherData(new WeatherData());
        updateView();
    }

    public void onPlaceSelect(View view) {
        Intent intent = new Intent(this, LocationSelection.class);
        intent.putExtra("WEATHERCITY", mainPresenter.getWeatherData());
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode != 0) {
            super.onActivityResult(requestCode, resultCode, data);
        }

        if (resultCode == RESULT_OK) {
            int city = data.getExtras().getInt("location");
            mainPresenter.getWeatherData().setCurrent(city);
            updateView();
        }
    }

    public void onWikiQuery(View view) {

        Uri uri = Uri.parse(mainPresenter.getWeatherData().getCurrent().getUri());
        Intent openWikiIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(openWikiIntent);
    }
}
