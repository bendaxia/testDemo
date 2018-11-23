package com.策略模式.duck;

/**
 * <p>
 * 
 * @jira TODO
 * @author 贲国龙
 * @date 2016年11月22日
 * @see 1.5.0
 * @modified TODO
 */
public class DuckCall {
	QuackBehavior quackBehavior;

	public DuckCall() {
		System.out.println("鸭鸣器装置");
	}
	
	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}
}
