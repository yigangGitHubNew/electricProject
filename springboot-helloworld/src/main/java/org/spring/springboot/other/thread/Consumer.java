package org.spring.springboot.other.thread;
/**
 *  消费者
 *  @author yigang.wu
 *	@date 2017年10月19日 下午2:32:04
 *
 */
public class Consumer implements Runnable{
	
	private Warehouse warehouse;
	
	private int num;
	
	public Consumer(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	@Override
	public void run() {
		warehouse.consume(this.getNum());
	}
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
