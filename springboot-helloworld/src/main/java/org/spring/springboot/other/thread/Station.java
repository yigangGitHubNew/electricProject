package org.spring.springboot.other.thread;

public class Station extends Thread{
	
	static int ticketNum = 200;
	
	public Station(String name) {
		super(name);
	}
	
	public void run() {
		while(ticketNum > 0) {
			synchronized("aa") {
				if(ticketNum > 0) {
					System.out.println("窗口"+getName()+"卖了第"+ticketNum+"张票了");
					ticketNum--;
				}else {
					System.out.println("票已经卖完了");
				}
			}
			try {
				sleep(1000);//休息一秒
			} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	}
}
