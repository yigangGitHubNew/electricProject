package org.spring.springboot.other.validate;

import java.util.List;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

public class TestOval {
	public static void main(String[] args) {
		Student stu = new Student();
		stu.setName2("123456789009876543212345678909876543212345678");
		stu.setDateStr("2000-02-01 15:32");
		Validator validator = new Validator();
		List<ConstraintViolation> rets = validator.validate(stu);
		if(null != rets && rets.size() != 0){
			for(ConstraintViolation ret:rets) {
				System.out.println(ret.getErrorCode()+"==="+ret.getMessage());
			}
		 }else{
			 System.out.println(2);
	     }
	}
}
