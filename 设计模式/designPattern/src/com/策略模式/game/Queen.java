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
public class Queen extends Charater {
	public Queen() {
		weaponBehavior = new BowAndArrowBehavior();//非动态设置动作
		this.display();
	}

	public void display() {
		System.out.println("<国王的老婆>");
	}
}
