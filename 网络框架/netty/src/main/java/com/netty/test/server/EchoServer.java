package com.netty.test.server;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {
	private static final int port = 8888;

	public void start() throws Exception {
		ServerBootstrap b = new ServerBootstrap();// 初始化netty
		EventLoopGroup group = new NioEventLoopGroup();// 通过nio方式来接收连接和处理连接
		try {
			b.group(group); 
			b.channel(NioServerSocketChannel.class);// 设置nio类型的channel
			b.localAddress(new InetSocketAddress(port));// 设置监听端口
			b.childHandler(new ChannelInitializer<SocketChannel>() {// 有连接到达时会创建一个channel(通道)
				protected void initChannel(SocketChannel ch) throws Exception {
					// pipeline管理channel中的Handler，在channel队列中添加一个handler来处理业务
					ch.pipeline().addLast("myHandler", new EchoServerHandler());
				}
			});
			ChannelFuture f = b.bind().sync();// 配置完成，开始绑定server，通过调用sync同步方法阻塞直到绑定成功
			System.out.println(EchoServer.class.getName() + " started and listen on " + f.channel().localAddress());
			f.channel().closeFuture().sync();// 应用程序会一直等待，直到channel关闭
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			group.shutdownGracefully().sync();// 关闭EventLoopGroup，释放掉所有资源包括创建的线程
		}
	}

	public static void main(String[] args) throws Exception {
		try {
			new EchoServer().start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	// 1. 创建一个ServerBootstrap实例
	// 2. 创建一个EventLoopGroup来处理各种事件，如处理链接请求，发送接收数据等。
	// 3. 定义本地InetSocketAddress( port)好让Server绑定
	// 4. 创建childHandler来处理每一个链接请求
	// 5. 所有准备好之后调用ServerBootstrap.bind()方法绑定Server
}
