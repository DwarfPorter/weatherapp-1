package so.ldd.weatherapp;

public class SingletonMain {

    private static SingletonMain instance;
    private static Object objSync = new Object();

    private WeatherData weatherData;

    private SingletonMain(){}

    public static SingletonMain getInstance(){
        synchronized (objSync){
            if (instance == null)
            {
                instance = new SingletonMain();
            }
            return instance;
        }
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }
}
