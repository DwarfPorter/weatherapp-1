package so.ldd.weatherapp;

/**
 * Created by k on 15.07.19.
 */

public class WeatherData {

    private int m_temperature = 3;
    private int m_currentCity = 0;

    public String toString() {
        return ((Integer)m_temperature).toString();
    }

    public int getCurrentCity() {
        return m_currentCity;
    }

    public void setCurrentCity(int city) {
        m_currentCity = city;
        m_temperature = city+3;
    }
}
