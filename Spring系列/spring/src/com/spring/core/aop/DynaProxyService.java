package com.spring.core.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类
 * 
 * @author ben
 * @ClassName: DynaProxyService
 * @Description: 在jdk1.3以后，jdk跟我们提供了一个API java.lang.reflect.InvocationHandler的类，
 *               这个类可以让我们在JVM调用某个类的方法时动态的为些方法做些什么事。
 * @date 2017年11月12日 下午4:06:25
 */
public class DynaProxyService implements InvocationHandler {

	private Object target;// 目标对象

	private Object proxy;// 切面对象

	private String proxyMethodName;// 切面方法名

	private String pointCut;// 切入方法的位置

	private String targetMethod;// 目标方法

	public void setProxyMethodName(String proxyMethodName) {
		this.proxyMethodName = proxyMethodName;
	}

	public void setPointcut(String pointcut) {
		this.pointCut = pointcut;
	}

	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}

	// 返回一个target的动态代理类
	public Object bind(Object target, Object proxy) {
		this.target = target;
		this.proxy = proxy;
		return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(),
				this);
	}

	// 调用target任何方法，都会调用动态代理类的invoke方法
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		// 反射得到切面对象的实例
		Class clazz = this.proxy.getClass();
		// 反射拿到切面对象的方法
		Method proxyMethod = clazz.getDeclaredMethod(proxyMethodName);
		// 反射执行方法
		if ("before".equals(pointCut) && (method.getName().equals(targetMethod))) {
			proxyMethod.invoke(this.proxy, null);
		}
		// 执行目标对象的方法
		method.invoke(this.target, null);
		if("after".equals(pointCut) && (method.getName().equals(targetMethod))) {
			proxyMethod.invoke(this.proxy, null);
		}
		return result;
	}

}
