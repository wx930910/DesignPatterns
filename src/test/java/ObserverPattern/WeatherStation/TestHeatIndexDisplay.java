package ObserverPattern.WeatherStation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestHeatIndexDisplay {

	private static WeatherData weatherData;

	@BeforeClass
	public static void initiateWeatherData() {
		weatherData = new WeatherData();
	}

	@Parameters(name = "Day {index}: temperature={0},humidity={1},pressure={2}")
	public static List<float[]> prepareWeatherData() {
		List<float[]> data = new ArrayList<>();
		data.add(new float[] { 80, 65, 30.4f });
		data.add(new float[] { 82, 70, 29.2f });
		data.add(new float[] { 78, 90, 29.2f });
		return data;
	}

	@Parameter(0)
	public float[] currentWeather;

	@Test
	public void testHeatIndexDispaly() {
		HeatIndexDisplay display = new HeatIndexDisplay();
		weatherData.registerObserver(display);
		weatherData.setMeasurement(currentWeather[0], currentWeather[1],
				currentWeather[2]);
		Assert.assertNotEquals(currentWeather[0], display.temperture());
		weatherData.notifyObserver();
		Assert.assertEquals("NotifyObservers() is not working",
				currentWeather[0], display.temperture(), 0);
		display.display();
	}

}
