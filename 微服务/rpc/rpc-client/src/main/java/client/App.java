package client;

import java.net.InetSocketAddress;

import interfaces.HelloService;

public class App {
	public static void main(String[] args) {
		HelloService helloService = Client.get(HelloService.class, new InetSocketAddress("172.20.10.3", 9090));
		for(int i=0;i<10;i++) {
			System.out.println(helloService.hello("hello rpc"));
		}
	}
}
