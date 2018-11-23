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
public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private float temperature;
	private float humidity;
	private float weather;
	private Subject weatherData;

	public CurrentConditionsDisplay(Subject subject) {
		this.weatherData = subject;
		this.weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("观察者1号:温度=" + temperature + "湿度=" + humidity + "天气" + weather);
	}

	@Override
	public void update(float temperature, float humidity, float weather) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.weather = weather;
		display();
	}
}
