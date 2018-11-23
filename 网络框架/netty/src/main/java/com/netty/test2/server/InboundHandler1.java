package com.netty.test2.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class InboundHandler1 extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {  
		System.out.println("进入InboundHandler1.channelRead,带着msg开始通知下一个InboundHandler");
		ctx.fireChannelRead(msg);
	}
	
	@Override  
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {  
		System.out.println("InboundHandler1.channelReadComplete");
		ctx.flush();
	}
	
}
