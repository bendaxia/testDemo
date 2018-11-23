package com.netty.test2.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class OutboundHandler1 extends ChannelOutboundHandlerAdapter {

	@Override
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
		System.out.println("OutboundHandler1.write,开始回复客户端消息");
		String response = "I am ok!";
		ByteBuf byteBuf = ctx.alloc().buffer(4 * response.length());
		byteBuf.writeBytes(response.getBytes());
		ctx.write(byteBuf);
		ctx.flush();
	}

}
