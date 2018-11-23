package com.策略模式.duck;

/**
 * <p>
 * 
 * @jira TODO
 * @author 贲国龙
 * @date 2016年11月14日
 * @see 1.5.0
 * @modified TODO
 */
public abstract class Duck {
	FlyBehavior behavior;
	QuackBehavior quackBehavior;

	public Duck() {
	}

	public void performFly() {
		behavior.fly();
	}

	public void performQuack() {
		quackBehavior.quack();
	}

	public void swim() {
		System.out.println("all什么来着");
	}

	public void setFlyBehavior(FlyBehavior fb) {
		behavior = fb;
	}

	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}
}
