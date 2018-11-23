package com.策略模式.game;
/**
* <p>角色
* @jira   TODO
* @author 贲国龙
* @date   2016年11月22日
* @see    1.5.0
* @modified TODO
*/
public abstract class Charater {
	WeaponBehavior weaponBehavior;
	
	//角色执行武器动作
	public void fight(){
		weaponBehavior.useWweapon();
	}
	
	public void setWeaponBehavior(WeaponBehavior wb){
		this.weaponBehavior=wb;
	}
}
