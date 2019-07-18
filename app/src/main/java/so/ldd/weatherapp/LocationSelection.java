package so.ldd.weatherapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.security.Signature;
import java.util.ArrayList;

public class LocationSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_selection);

        try {
            WeatherDataListViewAdapter adapter = null;
            adapter = new WeatherDataListViewAdapter(this, Singleton.getInstance(WeatherData.class).get_arrayOfWD());
            ListView v = (ListView) findViewById(R.id.lv);
            v.setAdapter(adapter);

            v.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent data = new Intent();
                    data.putExtra("location", i);
                    setResult(RESULT_OK, data);
                    finish();
                }
            });
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
