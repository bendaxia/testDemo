package com.策略模式.duck;
/**
* <p>
* @jira   TODO
* @author 贲国龙
* @date   2016年11月21日
* @see    1.5.0
* @modified TODO
*/
public class FlyRocketPowered implements FlyBehavior{

	@Override
	public void fly() {
		System.out.println("火箭飞行动力");
	}

}
