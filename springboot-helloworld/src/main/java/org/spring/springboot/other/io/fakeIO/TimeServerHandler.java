package org.spring.springboot.other.io.fakeIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeServerHandler implements Runnable{
	
	Socket socket;
	
	public TimeServerHandler(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(this.socket.getOutputStream(),true);
			String currentTime = null;
			String body = null;
			while(true) {
				body = in.readLine();
				if(body == null) {
					break;
				}
				System.out.println("the time server order is "+body);
				currentTime = String.valueOf(System.currentTimeMillis());
			}
		} catch (Exception e) {
			try {
				if(in != null) {
					in.close();
				}
				if(out != null) {
					out.close();
				}
				if(this.socket != null ) {
					this.socket.close();
					this.socket = null;
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
	}

}
