package org.spring.springboot.other.io.fakeIO;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *  伪异步IO的通信服务端
 *  @author yigang.wu
 *	@date 2017年11月9日 下午2:14:01
 *
 */
public class TimeServer {
	public static void main(String[] args) throws Exception {
		int port = 8080;
		if(args != null && args.length > 0 ) {
			port = Integer.parseInt(args[0]);
		}
		
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("the time server start with port is : "+ port);
			Socket socket = serverSocket.accept();
			TimeServerHandlerExcutePool executePool = new TimeServerHandlerExcutePool(50, 100);
			while(true) {
				executePool.execute(new TimeServerHandler(socket));
			}
		}finally {
			if(serverSocket != null) {
				System.out.println("the server socket is closed");
				serverSocket.close();
				serverSocket = null;
			}
		}
	}
}
