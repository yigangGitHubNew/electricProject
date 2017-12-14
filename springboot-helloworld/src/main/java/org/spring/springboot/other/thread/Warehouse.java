package org.spring.springboot.other.thread;
/**
 *  仓库
 *  @author yigang.wu
 *	@date 2017年10月19日 下午2:35:54
 *
 */

import java.util.LinkedList;

public class Warehouse {
	
	private static int MAX_NUM = 100;
	
	private LinkedList<Object> products = new LinkedList<Object>();
	
	
	/**
	 * 生产产品
	 * @param num
	 */
	public void production(int num) {
		try {
			synchronized(products) {
				while(products.size() + num > MAX_NUM) {
					System.out.println("该产品目前的库存是："+products.size()+"，满足最大量的要求，暂时不生产！");
					products.wait();
				}
				
				for(int i=0;i < num;i++) {
					products.add(new Object());
				}
				products.notify();
				System.out.println("当前的生产了"+num+"个产品，现在总的库存量是："+products.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 消耗产品
	 * @param num
	 */
	public void consume(int num) {
		try {
			synchronized(products) {
				while(products.size() < num) {
					System.out.println("该产品目前的库存是："+products.size()+"，不满足消耗的需求，暂时生产！");
					products.wait();
				}
				for(int i=0;i<num;i++) {
					products.remove();
				}
				products.notify();
				System.out.println("当前的消费了"+num+"个产品，现在总的库存量是："+products.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public LinkedList<Object> getProducts() {
		return products;
	}

	public void setProducts(LinkedList<Object> products) {
		this.products = products;
	}

}
