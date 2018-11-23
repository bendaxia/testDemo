package server;

import java.net.InetSocketAddress;

import impl.HelloServiceImpl;
import interfaces.HelloService;

public class App {
	public static void main(String[] args) throws Exception {
		Server server = new Server();
		server.register(HelloService.class, HelloServiceImpl.class);
		server.start(9090);
	}
}
