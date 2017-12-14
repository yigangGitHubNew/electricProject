package org.spring.springboot.other.gather;

/**
 *  双向链表
 *  @author yigang.wu
 *	@date 2017年10月26日 下午2:44:49
 *
 */
public class TwoWayLink<E> {
	
	Node<E> head;
	Node<E> tail;
	int size;
	
	private static class Node<E>{
		Node<E> pre;
		Node<E> next;
		E e;
		public Node(Node<E> pre,Node<E> next,E e) {
			this.pre = pre;
			this.next = next;
			this.e = e;
		}
	}
	
	public void add(E e) {
		Node<E> newObj = tail;
		Node<E> curObj = new Node(tail,null,e);
		tail = curObj;
		if(newObj == null) {
			head = curObj;
		}else {
			newObj.next = curObj;
		}
		size++;
	}
}
