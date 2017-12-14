package org.spring.springboot.other.validate;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.MatchPattern;
import net.sf.oval.constraint.NotNull;

/**
 *  @author yigang.wu
 *	@date 2017年10月19日 下午7:18:38
 *	
 */
public class Student{
	
	@NotNull(errorCode="010101",message="用户ID")
	private String stuName;
	
	@NotNull
	private String name1;
	
	@NotNull(errorCode="010101",message="name2不能为空")
    @Length(min=1, max=32,errorCode="010102",message="name2长度不够")
	private String name2;
	
	@NotNull(errorCode="010101",message="name2不能为空")
	@MatchPattern(matchAll=false,pattern={"^[1-2][0-9][0-9][0-9]-([1][0-2]|0?[1-9])-([12][0-9]|3[01]|0?[1-9]) ([01][0-9]|[2][0-3]):[0-5][0-9]$"},errorCode="日期",message="格式不对")
	private String dateStr;

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
}
