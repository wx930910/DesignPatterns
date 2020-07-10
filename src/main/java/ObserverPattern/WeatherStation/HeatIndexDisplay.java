package ObserverPattern.WeatherStation;

public class HeatIndexDisplay implements Observer, DisplayElement {
	private float temperture;
	private float humidity;
	private float heatIndex;

	public HeatIndexDisplay() {
		this.heatIndex = 0.0f;
	}

	public float temperture() {
		return this.temperture;
	}

	@Override
	public void display() {
		System.out.println("Tempature is " + this.temperture);
		System.out.println("Humidity is " + this.humidity);
		System.out.println("Heat index is " + this.heatIndex);
	}

	@Override
	public void update(float temperture, float humidity, float pressure) {
		this.temperture = temperture;
		this.humidity = humidity;
		this.heatIndex = this.computeHeatIndex(this.temperture, this.humidity);
	}

	private float computeHeatIndex(float temperture, float humidity) {
		float index = (float) ((16.923 + (0.185212 * temperture)
				+ (5.37941 * humidity) - (0.100254 * temperture * humidity)
				+ (0.00941695 * (temperture * temperture))
				+ (0.00728898 * (humidity * humidity))
				+ (0.000345372 * (temperture * temperture * humidity))
				- (0.000814971 * (temperture * humidity * humidity))
				+ (0.0000102102
						* (temperture * temperture * humidity * humidity))
				- (0.000038646 * (temperture * temperture * temperture))
				+ (0.0000291583 * (humidity * humidity * humidity))
				+ (0.00000142721
						* (temperture * temperture * temperture * humidity))
				+ (0.000000197483
						* (temperture * humidity * humidity * humidity))
				- (0.0000000218429 * (temperture * temperture * temperture
						* humidity * humidity))
				+ 0.000000000843296 * (temperture * temperture * humidity
						* humidity * humidity))
				- (0.0000000000481975 * (temperture * temperture * temperture
						* humidity * humidity * humidity)));
		return index;
	}

}
