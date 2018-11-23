package com.策略模式.duck;
/**
* <p>
* @jira   TODO
* @author 贲国龙
* @date   2016年11月14日
* @see    1.5.0
* @modified TODO
*/
public class FlyNoWway implements FlyBehavior{

	@Override
	public void fly() {
		System.out.println("不能飞");
	}
	/**
	* <p>
	* @jira   TODO
	* @author 贲国龙
	* @date   2016年11月14日
	* @see    1.5.0
	* @modified TODO
	*/
}
