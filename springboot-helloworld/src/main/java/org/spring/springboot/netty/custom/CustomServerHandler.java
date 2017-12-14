package org.spring.springboot.netty.custom;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class CustomServerHandler extends ChannelHandlerAdapter{
	
	 protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {  
	        if(msg instanceof CustomMsg) {  
	            CustomMsg customMsg = (CustomMsg)msg;  
	            System.out.println("Client->Server:"+ctx.channel().remoteAddress()+" send "+customMsg.getBody());  
	        }  
	          
	    }
}
