package org.spring.springboot.other;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 测试队列的类
 * @author yigang.wu 2017年9月19日
 *
 */
public class TestQueue {
	
	public static void main(String[] args) {
		testQueue(); 
		System.out.println("-------栈--------");  
        testStack();
	}
	
	/**
	 * 测试队列
	 * 队列特点，先进先出，后进后出
	 */
	public static void testQueue() {
		Queue<String> queues = new LinkedList<String>();
		//offer和add的区别在于 如果队列满的话 add会抛异常 offer会返回false
		queues.offer("1");
		queues.offer("2");
		queues.offer("3");
		queues.offer("4");
		queues.offer("5");
		queues.add("6");
		queues.add("7");
		queues.add("8");
		queues.add("9");
		queues.add("10");
		System.out.println("队列的元素是："+queues);
		queues.poll();
		System.out.println("队列的元素是："+queues);
		String peek = queues.peek();  
        System.out.println("查看队列中首个元素，并不移除:" + peek);  
        System.out.println("队列中的元素是:" + queues); 
	}
	
	/**
	 * 测试栈
	 * 先进后出，后进先出，水桶倒水
	 */
	public static void testStack() {
		Stack<String> stacks = new Stack<String>();
		stacks.push("1");
		stacks.push("2");
		stacks.push("3");
		stacks.push("4");
		stacks.push("5");
		stacks.add("6");
		stacks.add("7");
		stacks.add("8");
		stacks.add("9");
		stacks.add("10");
		System.out.println("栈中的元素是:" + stacks);  
        // 弹出元素  
		stacks.pop();  
        System.out.println("栈中的元素是:" + stacks);  
        // 查看栈中首个元素，并不移除  
        String peek = stacks.peek();  
        System.out.println("查看栈中首个元素，并不移除:" + peek);  
        System.out.println("栈中的元素是:" + stacks);
	}
}
