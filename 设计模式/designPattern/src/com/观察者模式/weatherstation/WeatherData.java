package com.观察者模式.weatherstation;

import java.util.ArrayList;

/**
 * <p>主题实现
 * 
 * @jira TODO
 * @author 贲国龙
 * @date 2016年11月24日
 * @see 1.5.0
 * @modified TODO
 */
public class WeatherData implements Subject {

	private ArrayList<Observer> observers;//观察者记录收集器
	private float temperature;
	private float humidity;
	private float weather;

	public  WeatherData() {
		observers = new ArrayList<>();//初始化
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
		System.out.println("注册观察者,当前观察者有"+observers.size());
	}

	@Override
	public void removeObserver(Observer observer) {
//		int i = observers.indexOf(observer);
//		if(i!=0){
//			observers.remove(i);
//		}
		observers.remove(observer);
		System.out.println("移除观察者,当前观察者有"+observers.size());
	}

	@Override
	public void notifyObserver() {
		System.out.println("通知观察者,当前观察者有"+observers.size());
		for(Observer ob : observers){
			ob.update(temperature, humidity, weather);
		}
	}
	
	public void measurementsChanged(){
		notifyObserver();
	}

	//有坑
	public void setSeasurementsChanged(float temperature, float humidity, float weather){
		this.humidity = humidity;
		this.temperature = temperature;
		this.weather = weather;
		measurementsChanged();
	}
}
