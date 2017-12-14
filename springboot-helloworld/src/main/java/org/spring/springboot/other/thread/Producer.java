package org.spring.springboot.other.thread;
/**
 *  生产者
 *  @author yigang.wu
 *	@date 2017年10月19日 下午2:31:30
 *
 */
public class Producer implements Runnable{
	
	private Warehouse warehouse;
	
	private int num;
	
	public Producer(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	
	@Override
	public void run() {
		warehouse.production(getNum());
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
