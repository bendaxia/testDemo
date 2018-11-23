package com.spring.core.ioc;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import com.spring.core.aop.DynaProxyService;

public class ClassPathXmlApplicationContext implements BeanFactory{
	private Map<String, Object> beans = new HashMap<String, Object>(); // ioc 容器
    private Map<String,String> beansXml = new HashMap<String,String>();  

	public ClassPathXmlApplicationContext() throws Exception {
		SAXBuilder sb = new SAXBuilder();
		Document xmlDoc = sb
				.build(this.getClass().getClassLoader().getResourceAsStream("com/spring/config/beans.xml"));// 获取构造文档对象
		Element root = xmlDoc.getRootElement();// 获取根元素(beans)
		List<Element> list = root.getChildren("bean");// 获取beans下所有的bean元素
		for (Element bean : list) {
			String id = bean.getAttributeValue("id");//获取bean的id
			String clazz = bean.getAttributeValue("class");//bean的class
			Object o = Class.forName(clazz).newInstance();// 利用反射生成一个实例
			System.out.println("id:"+id+",class:"+clazz);
			beans.put(id, o);//放入容器
			beansXml.put(clazz, id);
			if(bean.getChild("property")!=null) {
				for(Element property : (List<Element>)bean.getChildren("property")){//遍历所有property
					String name = property.getAttributeValue("name");//获取property下的name
					String beanName = property.getAttributeValue("bean");//获取property下的bean
					Object beanObject = beans.get(beanName);//在容器中找到对应的属性
					String methodName = "set" + name.substring(0,1).toUpperCase()+name.substring(1);
					System.out.println("setter method name = " +methodName);
					Method m = o.getClass().getMethod(methodName, beanObject.getClass().getInterfaces());
					m.invoke(o, beanObject);//调用setter方法
				}
			}
		}
		
		Element aop = root.getChild("aop");
		//判断容器是否使用了aop
		if(aop!=null) {
			List<Element> aspects = aop.getChildren("aspect");
			for(Element aspect:aspects) {
				String id = aspect.getAttributeValue("id");
				String ref = aspect.getAttributeValue("ref");
				//从ioc容器取出要切入的类
				Object proxy = beans.get(ref);
				//获取前置通知
				Element before = aspect.getChild("before");
				//获取后置通知
				Element after = aspect.getChild("after");
				if(before!=null) {
					String pointcutRef = before.getAttributeValue("pointcut-ref");
					int subscript1 = pointcutRef.indexOf("(");
					int subscript2 = pointcutRef.indexOf(")");
					//获取目标类的名字
					String targetClassName = pointcutRef.substring(0,subscript1);
					//获取目标类的方法名字
					String targetMethodName = pointcutRef.substring(subscript1+1,subscript2);
					//获取目标类的id
					String targetId=beansXml.get(targetClassName); 
					//获取目标类
					Object target = beans.get(targetId);
					//获取切面类的方法
					String proxyMethodName = before.getAttributeValue("method");
					//生成代理类，并替换beans中对应id的value
					DynaProxyService dys = new DynaProxyService();
					dys.setPointcut("before");
					dys.setProxyMethodName(proxyMethodName);
					dys.setTargetMethod(targetMethodName);
					beans.put(targetId, dys.bind(target, proxy));
				}
				if(after!=null) {
					String pointcutRef = after.getAttributeValue("pointcut-ref");
					int subscript1 = pointcutRef.indexOf("(");
					int subscript2 = pointcutRef.indexOf(")");
					//获取目标类的名字
					String targetClassName = pointcutRef.substring(0,subscript1);
					//获取目标类的方法名字
					String targetMethodName = pointcutRef.substring(subscript1+1,subscript2);
					//获取目标类的id
					String targetId=beansXml.get(targetClassName); 
					//获取目标类
					Object target = beans.get(targetId);
					//获取切面类的方法
					String proxyMethodName = after.getAttributeValue("method");
					//生成代理类，并替换beans中对应id的value
					DynaProxyService dys = new DynaProxyService();
					dys.setPointcut("after");
					dys.setProxyMethodName(proxyMethodName);
					dys.setTargetMethod(targetMethodName);
					beans.put(targetId, dys.bind(target, proxy));
				}
			}
		}
	}

	@Override
	public Object getBean(String id) {
	  return beans.get(id);
	}
		
}
