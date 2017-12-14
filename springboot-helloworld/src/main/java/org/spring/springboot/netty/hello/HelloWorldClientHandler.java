package org.spring.springboot.netty.hello;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class HelloWorldClientHandler extends ChannelHandlerAdapter{
	 
	@Override  
     public void channelActive(ChannelHandlerContext ctx) {  
         System.out.println("HelloWorldClientHandler Active");  
     }  
   
     @Override  
     public void channelRead(ChannelHandlerContext ctx, Object msg) {  
        System.out.println("HelloWorldClientHandler read Message:"+msg);  
     }  
   
   
    @Override  
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {  
        cause.printStackTrace();  
        ctx.close();  
     }
}
