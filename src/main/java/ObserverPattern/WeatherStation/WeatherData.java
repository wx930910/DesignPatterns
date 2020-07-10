package ObserverPattern.WeatherStation;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
	private List<Observer> observers;

	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {
		this.observers = new ArrayList<>();
	}

	@Override
	public void registerObserver(Observer observer) {
		this.observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		this.observers.remove(observer);
	}

	@Override
	public void notifyObserver() {
		for (Observer observer : this.observers)
			observer.update(this.temperature, this.humidity, this.pressure);
	}

	public void setMeasurement(float temperature, float humidity,
			float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
	}

}
