package org.spring.springboot.other.gather;

import java.util.Iterator;

public class TestCollections {
	public static void main(String[] args) {
		ImitateList<String> strList = new ImitateList<String>();
		strList.add("1");
		strList.add("2");
		strList.add("3");
		strList.add("4");
		/*System.out.println("未使用remove方法list的长度:"+strList.size());
		
		for(int i = 0; i < strList.size(); i++) {
			System.out.println("没有使用remove方法时候的参数："+strList.get(i));
		}
		
		strList.remove(0);
		
		System.out.println("未使用remove方法list的长度:"+strList.size());
		
		for(int i = 0; i < strList.size(); i++) {
			System.out.println("使用remove方法时候的参数："+strList.get(i));
		}*/
		Iterator<String> strs = strList.iterator();
		while(strs.hasNext()) {
			System.out.println(strs.next());
		}
	}
}
