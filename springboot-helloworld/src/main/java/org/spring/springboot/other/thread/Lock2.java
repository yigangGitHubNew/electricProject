package org.spring.springboot.other.thread;

public class Lock2 implements Runnable {

	@Override
	public void run() {
		while(true) {
			System.out.println("lock2 is running");
			synchronized("obj2") {
				System.out.println("lock2 is look for lock1 in out side");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized("obj1") {
					System.out.println("lock1 is look for lock2");
				}
			}
		}
	}

}
