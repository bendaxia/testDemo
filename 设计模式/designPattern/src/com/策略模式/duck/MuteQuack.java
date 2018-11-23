package com.策略模式.duck;
/**
* <p>
* @jira   TODO
* @author 贲国龙
* @date   2016年11月14日
* @see    1.5.0
* @modified TODO
*/
public class MuteQuack implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("无法嘎嘎嘎");
	}

}
