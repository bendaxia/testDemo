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
public class King extends Charater {
	public King() {
		weaponBehavior = new AxeBehavior();//非动态设置动作
		this.display();
	}

	public void display() {
		System.out.println("<国王>");
	}
}
