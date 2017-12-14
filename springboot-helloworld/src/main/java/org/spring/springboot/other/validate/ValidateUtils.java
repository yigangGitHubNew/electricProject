package org.spring.springboot.other.validate;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ValidateUtils {
	
	public static List<String> getMsgs(Object obj) {
		Field[] fields = obj.getClass().getDeclaredFields();
		List<String> msgStrs = new ArrayList<String>();
		for(Field field:fields) {
			Validate validate = field.getAnnotation(Validate.class);
			if(validate != null) {
				String fieldName = field.getName();
				Object value = getFeildNameValue(obj,fieldName,field);
				boolean isNull = validate.isNull();
				String errMsg = validate.errMsg();
				if(!isNull) {
					if(value == null) {
						msgStrs.add(errMsg);
					}
				}
			}
		}
		return msgStrs;
	}
	
	public static Object getFeildNameValue(Object obj,String fieldName,Field field) {
		String name = fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
		String type = field.getGenericType().toString();
		Method m;
		try {
			if(type.equals("class java.lang.String")) {
				m = obj.getClass().getMethod("get"+name);
				String value = (String) m.invoke(obj); 
				return value;
			}else {
				m = obj.getClass().getMethod("get"+name);
				Object value = (String) m.invoke(obj); 
				return value;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
