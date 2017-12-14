package org.spring.springboot.other.thread;

public class TestProductionAndConsume {
	public static void main(String[] args) {
		Warehouse w = new Warehouse();
		Producer p11 = new Producer(w);
		Producer p12 = new Producer(w);
		Producer p13 = new Producer(w);
		Producer p14 = new Producer(w);
		Producer p15 = new Producer(w);
		p11.setNum(30);
		p12.setNum(30);
		p13.setNum(30);
		p14.setNum(30);
		p15.setNum(30);
		Thread p1 = new Thread(p11);
		Thread p2 = new Thread(p12);
		Thread p3 = new Thread(p13);
		Thread p4 = new Thread(p14);
		Thread p5 = new Thread(p15);
		
		Consumer c11 = new Consumer(w);
		Consumer c12 = new Consumer(w);
		Consumer c13 = new Consumer(w);
		c11.setNum(40);
		c12.setNum(40);
		c13.setNum(40);
		Thread c1 = new Thread(c11);
		Thread c2 = new Thread(c12);
		Thread c3 = new Thread(c13);
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		c1.start();
		c2.start();
		c3.start();
	}
}

