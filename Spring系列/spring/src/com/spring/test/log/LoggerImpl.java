package com.spring.test.log;

public class LoggerImpl implements Logger {
	@Override
	public void start() {
		System.out.println("开始打印日志");
	}

	@Override
	public void end() {
		System.out.println("日志打印结束");
	}
}
