package so.ldd.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onPlaceSelect(View view) {
        Intent intent = new Intent(this, LocationSelection.class);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        String city = getResources().getStringArray(R.array.locations)[data.getExtras().getInt("location")];

        TextView cn = (TextView) findViewById(R.id.cityName);
        cn.setText(city);
    }
}
