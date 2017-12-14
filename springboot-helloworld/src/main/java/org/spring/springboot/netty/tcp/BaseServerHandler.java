package org.spring.springboot.netty.tcp;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class BaseServerHandler extends ChannelHandlerAdapter{
	
	private int counter;  
    
    
    @Override  
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {  
          
        String body = (String)msg;  
        System.out.println("server receive order : " + body + ";the counter is: " + ++counter);  
    }  
      
      
    @Override  
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {  
        cause.printStackTrace();  
        ctx.close();  
    } 
}
