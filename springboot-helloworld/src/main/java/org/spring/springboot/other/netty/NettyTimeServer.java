package org.spring.springboot.other.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 *  netty 的基础入门
 *  @author yigang.wu
 *	@date 2017年11月10日 上午11:12:30
 *
 */
public class NettyTimeServer {
	
	public void bind(int port) throws InterruptedException {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup,workGroup).channel(NioServerSocketChannel.class).
			option(ChannelOption.SO_BACKLOG, 1024).childHandler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new NettyServerHandler());
				};
			});
			ChannelFuture f = b.bind(port).sync();
			f.channel().close().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		int port = 8080;
		if(args != null && args.length > 0) {
			port = Integer.parseInt(args[0]);
		}
		
		new NettyTimeServer().bind(port);
	}
}
