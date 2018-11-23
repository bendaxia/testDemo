package com.spring.test.time;

public class TimeServiceImpl implements TimeService{
	private long startTime;
	
	@Override
	public void start() {
		startTime = System.currentTimeMillis();
		System.out.println("开始计时");
	}

	@Override
	public void end() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long time = System.currentTimeMillis()-startTime;
		System.out.println("计时结束，总耗时:"+time);
	}

}
