package so.ldd.weatherapp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by k on 15.07.19.
 */

public class Singleton {
    private static final Singleton instance = new Singleton();
    private static final Object syncObject = new Object();
    private Map<Class, Object> objectStorage = new HashMap<Class, Object>();

    private Singleton() {}

    public static <T> T getInstance(Class<T> classOf) throws IllegalAccessException, InstantiationException {
        synchronized (syncObject) {
            if (!instance.objectStorage.containsKey(classOf)) {
                T obj = classOf.newInstance();
                instance.objectStorage.put(classOf, obj);
            }
            return (T)instance.objectStorage.get(classOf);
        }
    }
}
