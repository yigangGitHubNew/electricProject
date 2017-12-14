package org.spring.springboot.other.gather;

public class ImitateLinkedList<E> {
	
	@SuppressWarnings("unused")
	private Node<E> prev;
	
	private Node<E> end;
	
	private int size;
	
	public void add(E e) {
		Node<E> currentNode = end;
		Node<E> newNode = new Node<E>(currentNode,e,null);
		end = newNode;
		if(currentNode == null) {
			prev = newNode;
		}else {
			currentNode.last = newNode;
		}
		size++;
	}
	
	public E get(int index) {
		if (index < (size >> 1)) {
            Node<E> x = prev;
            for (int i = 0; i < index; i++)
                x = x.last;
            return x.e;
        } else {
            Node<E> x = end;
            for (int i = size - 1; i > index; i--)
                x = x.first;
            return x.e;
        }
	}
	
	
	
	private class Node<E>{
		E e;
		Node<E> first;
		Node<E> last;
		Node(Node<E> first,E e,Node<E> last){
			this.first = first;
			this.e = e;
			this.last = last;
		}
	}
}
