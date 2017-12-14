package org.spring.springboot.other.thread;
/**
 *  死锁
 *  @author yigang.wu
 *	@date 2017年10月19日 上午11:44:28
 *
 */
public class DeadLock {
	public static void main(String[] args) {
		Thread lock1 = new Thread(new Lock1());
		Thread lock2 = new Thread(new Lock2());
		lock1.start();
		lock2.start();
	}
}
