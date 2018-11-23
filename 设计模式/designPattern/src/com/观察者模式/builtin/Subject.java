package com.观察者模式.builtin;

/**
 * <p>
 * 主题
 * 
 * @jira TODO
 * @author 贲国龙
 * @date 2016年11月24日
 * @see 1.5.0
 * @modified TODO
 */
public interface Subject {

	public void registerObserver(Observer observer);// 注册观察者

	public void removeObserver(Observer observer);// 移除观察者

	public void notifyObserver();// 通知观察者
}
