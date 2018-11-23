package com.观察者模式.weatherstation;

/**
 * <p>
 * 
 * @jira TODO
 * @author 贲国龙
 * @date 2016年11月24日
 * @see 1.5.0
 * @modified TODO
 */
public class WeatherStation {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		weatherData.setSeasurementsChanged(1, 1, 1);
		weatherData.removeObserver(conditionsDisplay);
		weatherData.removeObserver(forecastDisplay);
		weatherData.setSeasurementsChanged(2, 1, 1);
		weatherData.setSeasurementsChanged(2, 1, 1);
	}
}
