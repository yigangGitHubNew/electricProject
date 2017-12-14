package org.spring.springboot.other.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeClient {
	
	public static void main(String[] args) throws IOException {
		int port = 8080;
		if(args != null && args.length > 0) {
			port = Integer.parseInt(args[0]);
		}
		
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			socket = new Socket("127.0.0.1", port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(),true);
			String resq = null;
			resq = in.readLine();
			System.out.println("receive body is "+resq);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(in != null) {
				in.close();
			}
			if(out != null) {
				out.close();
			}
			if(socket != null) {
				socket.close();
			}
		}
	}
}
