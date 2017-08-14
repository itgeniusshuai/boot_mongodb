package com.mongo.common;

public class GlobalResult {
	private int code;
	private String msg;
	private Object data;
	
	public static GlobalResult ok(Object data){
		return new GlobalResult(1, data);
	}
	
	public static GlobalResult error(int code, String msg){
		return new GlobalResult(code, msg);
	}
	
	public GlobalResult(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}



	public GlobalResult() {
		super();
	}



	public GlobalResult(int code, Object data) {
		super();
		this.code = code;
		this.data = data;
	}



	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
