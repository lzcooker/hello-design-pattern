package helloworld.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luzhicheng
 * @date 2025/5/12 16:21
 */
public class ObserverDemo {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        //订阅主题，其实是主题内部注册该订阅者， 事件发布后notify订阅者
        CurrentConditionsDisplay currentConditionsDisplay = new
                CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        weatherData.setMeasurements(0, 0, 0);
        weatherData.setMeasurements(1, 1, 1);
    }
}

interface Subject1 {
    void registerObserver(Observer1 o);

    void removeObserver(Observer1 o);

    void notifyObserver();
}

class WeatherData implements Subject1 {
    private List<Observer1> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer1 o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer1 o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer1 o : observers) {
            o.update(temperature, humidity, pressure);
        }
    }
}

interface Observer1 {
    void update(float temp, float humidity, float pressure);
}

class StatisticsDisplay implements Observer1 {
    public StatisticsDisplay(Subject1 weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        System.out.println("StatisticsDisplay.update: " + temp + " " + humidity + " " +
                pressure);
    }
}

class CurrentConditionsDisplay implements Observer1 {
    public CurrentConditionsDisplay(Subject1 weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        System.out.println("CurrentConditionsDisplay.update: " + temp + " " + humidity + " "
                + pressure);
    }
}

class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new
                CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        weatherData.setMeasurements(0, 0, 0);
        weatherData.setMeasurements(1, 1, 1);
    }
}
