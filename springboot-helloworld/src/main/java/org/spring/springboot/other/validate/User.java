package org.spring.springboot.other.validate;

/**
 *  @author yigang.wu
 *	@date 2017年10月19日 下午5:10:17
 *	
 */
public class User {
	
	@Validate(errMsg="不能为空",isNull=false)
	private String userName;
	
	private Integer age;
	
	private String birthDay;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
}
