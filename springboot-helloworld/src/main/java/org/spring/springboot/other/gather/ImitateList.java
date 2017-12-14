package org.spring.springboot.other.gather;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *  模仿list集合
 *  @author yigang.wu
 *	@date 2017年10月24日 下午5:54:26
 *
 */
public class ImitateList<E> implements List<E>{
	
	private static final int totalNum = 2;
	
	private int size;
	
	private Object[] objects = new Object[totalNum];

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return new iteratorDemo();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		if(size < totalNum) {
			objects[size] = e;
		}else {
			int newCount = size+totalNum;
			objects = Arrays.copyOf(objects, newCount);
			objects[size] = e;
		}
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		return (E) objects[index];
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		int moveLength = size - index -1;
		System.arraycopy(objects, index+1, objects, index, moveLength);
		size--;
		return (E) objects[index];
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class iteratorDemo implements Iterator<E>{
		
		private int target;
		
		@Override
		public boolean hasNext() {
			if(target >= size) {
				return false;
			}
			target++;
			return true;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			int index = target -1;
			return (E) objects[index];
		}
		
	}
}
