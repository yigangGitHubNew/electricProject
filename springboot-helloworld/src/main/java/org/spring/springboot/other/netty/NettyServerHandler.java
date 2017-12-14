package org.spring.springboot.other.netty;

import java.io.UnsupportedEncodingException;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class NettyServerHandler extends ChannelHandlerAdapter{
	
	public void channelRead(ChannelHandlerContext ctx,Object msg) throws UnsupportedEncodingException {
		ByteBuf buf = (ByteBuf)msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		String body = new String(req,"utf-8");
		System.out.println("the netty time server receive order is "+body);
		String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? String.valueOf(System.currentTimeMillis()) : 
			"BAD ORDER";
		ByteBuf reqs = Unpooled.copiedBuffer(currentTime.getBytes());
		ctx.write(reqs);
	}
	
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();
	}
	
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		ctx.close();
	}
}
