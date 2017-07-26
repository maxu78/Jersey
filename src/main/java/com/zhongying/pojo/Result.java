package com.zhongying.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Result {
	
	private String resCode;
	private String resDesc;
	
	public Result(){}
	
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getResDesc() {
		return resDesc;
	}
	public void setResDesc(String resDesc) {
		this.resDesc = resDesc;
	}
	@Override
	public String toString() {
		return "Result [resCode=" + resCode + ", resDesc=" + resDesc + "]";
	}
	
	
}
