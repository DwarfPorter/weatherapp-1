package so.ldd.weatherapp;

public class WeatherDataListViewItem {

    private String m_cityName;
    private String m_uri;
    private int m_temperature;

    WeatherDataListViewItem(String cityName, String uri) {
        m_cityName = cityName;
        m_uri = uri;

        m_temperature = 20;
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
