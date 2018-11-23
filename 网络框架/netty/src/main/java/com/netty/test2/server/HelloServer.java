package com.netty.test2.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
/**
 * server类，启动Netty server
 * 整体顺序为
 * 
 * client(发送消息) --->
 * (server)InboundHandler1接收并传递--->InboundHandler2接收到传递打印client发送的消息,在传递--->
 * OutboundHandler2接收并传递--->OutboundHandler1接收并回复client消息--->
 * (client)HelloClientIntHandler接收到server发送的回复,打印。
 * 
 * @author Bron
 *
 */
public class HelloServer {
	public void start(int port) throws Exception {  
        EventLoopGroup bossGroup = new NioEventLoopGroup();  
        EventLoopGroup workerGroup = new NioEventLoopGroup();  
        try {  
            ServerBootstrap b = new ServerBootstrap();  
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)  
                    .childHandler(new ChannelInitializer<SocketChannel>() {  
                        @Override  
                        public void initChannel(SocketChannel ch)  
                                throws Exception {  
                        	// 注册两个OutboundHandler，执行顺序为注册顺序的逆序，所以应该是OutboundHandler2 OutboundHandler1  
                        	ch.pipeline().addLast(new OutboundHandler1());  
                        	ch.pipeline().addLast(new OutboundHandler2());  
                            // 注册两个InboundHandler，执行顺序为注册顺序，所以应该是InboundHandler1 InboundHandler2  
                            ch.pipeline().addLast(new InboundHandler1());  
                            ch.pipeline().addLast(new InboundHandler2());  
                        }  
                    }).option(ChannelOption.SO_BACKLOG, 128)  
                    .childOption(ChannelOption.SO_KEEPALIVE, true);  
  
            ChannelFuture f = b.bind(port).sync();  //绑定端口
  
            f.channel().closeFuture().sync();  //线程监听
        } finally {  
            workerGroup.shutdownGracefully();  
            bossGroup.shutdownGracefully();  
        }  
    }  
  
    public static void main(String[] args) throws Exception {  
        HelloServer server = new HelloServer();  
        server.start(8000);  
    }  
}
