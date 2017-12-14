package org.spring.springboot.other.io.bio;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *  传统的BIO（同步阻塞式I/O）的通信服务端
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
			while(true) {
				new Thread(new TimeServerHandler(socket)).start();
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
