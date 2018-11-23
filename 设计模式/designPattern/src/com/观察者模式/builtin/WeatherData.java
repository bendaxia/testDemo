package com.观察者模式.builtin;

import java.util.Observable;

/**
 * <p>主题实现
 * 
 * @jira TODO
 * @author 贲国龙
 * @date 2016年11月24日
 * @see 1.5.0
 * @modified TODO
 */
public class WeatherData extends Observable{

//	private float temperature;
//	private float humidity;
//	private float weather;

	public void notifyObserver() {
//		System.out.println("通知观察者,当前观察者有"+observers.size());
//		for(Observer ob : observers){
//			ob.update(temperature, humidity, weather);
//		}
	}
	
	public void measurementsChanged(){
		notifyObserver();
	}

	//有坑
	public void setSeasurementsChanged(float temperature, float humidity, float weather){
//		this.humidity = humidity;
//		this.temperature = temperature;
//		this.weather = weather;
		measurementsChanged();
	}
}
