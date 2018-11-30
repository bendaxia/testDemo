package com.datastructure.linkedlist;

import com.datastructure.utils.JsonUtils;

public class Test {
	public static void main(String[] args) throws Exception {
		int n = 0;
		LinkedList k = new LinkedList();
		LinkedList f1 = new LinkedList();
		LinkedList f2 = new LinkedList();
		LinkedList f3 = null;
		f1.setData(1);
		f2.setData(1);
		k = f1;
		f1.setNext(f2);
		for(n=3;n<=10;n++) {
			f3 = new LinkedList();//新增一个节点
			f3.setData((Integer.valueOf(f1.getData().toString())+Integer.valueOf(f2.getData().toString())));
			f2.setNext(f3);//这里的f2其实就是上一轮的f3
			System.out.println("-------------------f1=f2前-----------------------");
			System.out.println("f1:"+JsonUtils.toJson(f1));
			System.out.println("f2:"+JsonUtils.toJson(f2));
			System.out.println("f3:"+JsonUtils.toJson(f3));
			System.out.println("k:"+JsonUtils.toJson(k));
			f1 = f2;//把f2的内存地址赋予f1,让下一轮f1操纵上一轮的f2
			System.out.println("-------------------f1=f2后-----------------------");
			System.out.println("f1:"+JsonUtils.toJson(f1));
			System.out.println("f2:"+JsonUtils.toJson(f2));
			System.out.println("f3:"+JsonUtils.toJson(f3));
			System.out.println("k:"+JsonUtils.toJson(k));
			f2 = f3;//把f3的内存地址赋予f2,让下一轮f2操纵上一轮的f3
			System.out.println("-------------------f2=f3后-----------------------");
			System.out.println("f1:"+JsonUtils.toJson(f1));
			System.out.println("f2:"+JsonUtils.toJson(f2));
			System.out.println("f3:"+JsonUtils.toJson(f3));
			System.out.println("k:"+JsonUtils.toJson(k));
		}
		f3.setNext(null);
		System.out.println(JsonUtils.toJson(k));
	}
}
