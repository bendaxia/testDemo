package com.观察者模式.builtin;

/**
 * <p>
 * 
 * @jira TODO
 * @author 贲国龙
 * @date 2016年11月29日
 * @see 1.5.0
 * @modified TODO
 */
public class ForecastDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	private float weather;
	private Subject weatherData;

	public ForecastDisplay(Subject subject) {//以主题对象为参数的构造器,实例化的时候必须放入一个主题对象
		this.weatherData = subject;
		this.weatherData.registerObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("观察者2号:温度=" + temperature + "湿度=" + humidity + "天气" + weather);
	}

	@Override
	public void update(float temperature, float humidity, float weather) {
		this.humidity = humidity;
		this.temperature = temperature;
		this.weather = weather;
		display();
	}

}
