package java.ObserverPattern.WeatherStation;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

public class WeatherData implements Subject {
    private Set<Observer> observers;

    public WeatherData() {
        this.observers = new HashSet<>();
    }
    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

}
