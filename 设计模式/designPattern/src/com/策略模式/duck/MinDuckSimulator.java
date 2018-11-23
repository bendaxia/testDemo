package com.策略模式.duck;
/**
* <p>
* @jira   TODO
* @author 贲国龙
* @date   2016年11月14日
* @see    1.5.0
* @modified TODO
*/
public class MinDuckSimulator {
	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		mallard.performFly();
		mallard.setQuackBehavior(new Quack());
		mallard.performQuack();
//		mallard.performQuack();
//		Duck duck = new ModelDuck();
//		duck.performFly();//这个时候这个鸭子不能飞
//		duck.performQuack();//这个时候鸭子是嘎嘎叫的
//		duck.setFlyBehavior(new FlyRocketPowered());//为期装载火箭飞行动力
//		duck.setQuackBehavior(new Squeak());//为他装载叫哇哇叫的能力
//		//感受下
//		duck.performFly();
//		duck.performQuack();
		
		//鸭鸣器
//		DuckCall duckCall = new DuckCall();
//		duckCall.setQuackBehavior(new Squeak());
//		duckCall.quackBehavior.quack();
	}
}
