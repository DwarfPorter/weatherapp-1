package so.ldd.weatherapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WeatherDataListViewAdapter extends ArrayAdapter<WeatherDataListViewItem> {

    public WeatherDataListViewAdapter(Context context, ArrayList<WeatherDataListViewItem> users) {
        super(context, 0, users);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        WeatherDataListViewItem wd = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.tvitem, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.tvCityName);
        tvName.setText(wd.getCurrentCityName());
        return convertView;
    }
}
