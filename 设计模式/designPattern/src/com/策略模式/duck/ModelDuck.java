package com.策略模式.duck;
/**
* <p>
* @jira   TODO
* @author 贲国龙
* @date   2016年11月21日
* @see    1.5.0
* @modified TODO
*/
public class ModelDuck extends Duck{
	public ModelDuck(){
		behavior = new FlyNoWway();
		quackBehavior = new Quack();
		this.dispay();
	}
	
	public void dispay(){
		System.out.println("我是模型鸭");
	}
}
