package com.netty.test2.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class InboundHandler2 extends ChannelInboundHandlerAdapter {
	
	// 读取客户端消息
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("进入InboundHandler2.channelRead,开始读取客户端消息");
		ByteBuf byteBufMsg = (ByteBuf) msg;
		byte[] b = new byte[byteBufMsg.readableBytes()];
		byteBufMsg.readBytes(b);
		String msgStr = new String(b);
		System.out.println("Client said:" + msgStr);
		byteBufMsg.release();
		ctx.write(msg);  
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		System.out.println("InboundHandler2.channelReadComplete");
		ctx.flush();
	}

}
