package com.策略模式.game;

/**
 * <p>
 * 
 * @jira TODO
 * @author 贲国龙
 * @date 2016年11月22日
 * @see 1.5.0
 * @modified TODO
 */
public class MinCharaterSimulator {
	public static void main(String[] args) {
		Charater king = new King();
		king.setWeaponBehavior(new BowAndArrowBehavior());
		king.fight();
		Charater knight = new Knight();
		knight.setWeaponBehavior(new AxeBehavior());
		knight.fight();
		Charater queen = new Queen();
		queen.setWeaponBehavior(new KinfeBehavior());
		queen.fight();
	}
}
