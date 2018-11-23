package com.策略模式.game;
/**
* <p>
* @jira   TODO
* @author 贲国龙
* @date   2016年11月22日
* @see    1.5.0
* @modified TODO
*/
public class AxeBehavior implements WeaponBehavior{

	@Override
	public void useWweapon() {
		System.out.println("斧头狂砍!");
	}

}
