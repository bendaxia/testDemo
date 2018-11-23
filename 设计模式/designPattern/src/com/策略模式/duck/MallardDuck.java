package com.策略模式.duck;
/**
* <p>
* @jira   TODO
* @author 贲国龙
* @date   2016年11月14日
* @see    1.5.0
* @modified TODO
*/
public class MallardDuck extends Duck{
	public MallardDuck(){
		quackBehavior = new Squeak();
		behavior = new FlyWithWings();
		this.display();
	}
	
	public void display(){
		System.out.println("这是红瓜娃子");
	}
}
