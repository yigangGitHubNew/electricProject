package org.spring.springboot.other;

public class ValueTrans {
	
	public static void main(String[] args) {
		String str = "aaa";
		changeStrValue(str);
		System.out.println(str);
	}

	private static void changeStrValue(String str) {
		str = new String("bbb");
	}
}
