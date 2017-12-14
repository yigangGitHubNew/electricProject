package org.spring.springboot.other.validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
	
	/**
	 * 错误信息
	 * @return
	 */
	String errMsg() default "";
	
	/**
	 * 是否为空
	 * @return
	 */
	boolean isNull() default false;
	
	/**
	 * 校验的格式
	 * @return
	 */
	String formatStr() default "";
}
