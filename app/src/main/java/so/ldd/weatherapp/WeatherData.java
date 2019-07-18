package so.ldd.weatherapp;

import java.util.ArrayList;

/**
 * Created by k on 15.07.19.
 */

public class WeatherData {

    private int m_currentCity = 0;
    private ArrayList<WeatherDataListViewItem> m_arrayOfWD;

    WeatherData() {
        m_arrayOfWD = new ArrayList<>();

        /**
         *
         * Пока что без локализации.
         *
         *         <item>Chelyabinsk</item>
         *         <item>Omsk</item>
         *         <item>Samara</item>
         *         <item>Rostov-na-donu</item>
         *         <item>Ufa</item>
         *         <item>Perm</item>
         *         <item>Voronezh</item>
         *         <item>Volgograd</item>
         *         <item>Saratov</item>
         */
        m_arrayOfWD.add(new WeatherDataListViewItem("Moscow","https://en.wikipedia.org/wiki/Moscow"));
        m_arrayOfWD.add(new WeatherDataListViewItem("Saint Petersburg", "https://en.wikipedia.org/wiki/Saint_Petersburg"));
        m_arrayOfWD.add(new WeatherDataListViewItem("Novosibirsk","https://en.wikipedia.org/wiki/Novosibirsk"));
        m_arrayOfWD.add(new WeatherDataListViewItem("Yekaterinburg","https://en.wikipedia.org/wiki/Yekaterinburg"));
        m_arrayOfWD.add(new WeatherDataListViewItem("Nizhny Novgorod","https://en.wikipedia.org/wiki/Nizhny_Novgorod"));
        m_arrayOfWD.add(new WeatherDataListViewItem("Kazan","https://en.wikipedia.org/wiki/Kazan"));

    }

    public ArrayList<WeatherDataListViewItem> get_arrayOfWD() {
        return m_arrayOfWD;
    }

    public String toString() {
        return ((Integer)m_arrayOfWD.get(m_currentCity).getTemperature()).toString();
    }

    public String getCurrentCityName() {
        return m_arrayOfWD.get(m_currentCity).getCurrentCityName();
    }

    public void setCurrentCity(int city) {
        m_currentCity = city;
    }

    public String getCurrentWikiURI() {
        return m_arrayOfWD.get(m_currentCity).getUri();
    }
}
