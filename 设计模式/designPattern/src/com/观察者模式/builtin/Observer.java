package com.观察者模式.builtin;

/**
 * <p>
 * 观察者
 * 
 * @jira TODO
 * @author 贲国龙
 * @date 2016年11月24日
 * @see 1.5.0
 * @modified TODO
 */
public interface Observer {
	public void update(float temperature, float humidity, float weather);// 更新气象数据
}
