package org.spring.springboot.netty.hello;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class HelloWorldServerHandler extends ChannelHandlerAdapter {
	
  	@Override  
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {  
        System.out.println("server channelRead..");  
        System.out.println(ctx.channel().remoteAddress()+"->Server :"+ msg.toString());  
        ctx.write("server write"+msg);  
        ctx.flush();  
    }
  
  	@Override  
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {  
        cause.printStackTrace();  
        ctx.close();  
    }  
}
