package org.spring.springboot.other.validate;

import java.util.List;

public class TestValidateUtil {
	public static void main(String[] args) {
		User user = new User();
		List<String> strs = ValidateUtils.getMsgs(user);
		for(String str:strs) {
			System.out.println("返回的错误信息："+str);
		}
	}
}
