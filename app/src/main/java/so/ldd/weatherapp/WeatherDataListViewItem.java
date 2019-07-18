package so.ldd.weatherapp;

import java.io.Serializable;
import java.util.Random;

public class WeatherDataListViewItem implements Serializable {

    private String m_cityName;
    private String m_uri;
    private int m_temperature;

    private Random rand = new Random();

    WeatherDataListViewItem(String cityName, String uri) {
        m_cityName = cityName;
        m_uri = uri;

        m_temperature = rand.nextInt(30);
    }

    public String getCurrentCityName() {
        return m_cityName;
    }

    public String getUri() {
        return m_uri;
    }

    public int getTemperature() {
        return m_temperature;
    }
}
