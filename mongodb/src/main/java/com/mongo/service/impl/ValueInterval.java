package com.mongo.service.impl;

public class ValueInterval <T>{
	private T startValue;
	private T endValue;
	
	public ValueInterval() {
		super();
	}
	public ValueInterval(T startValue, T endValue) {
		super();
		this.startValue = startValue;
		this.endValue = endValue;
	}
	public T getStartValue() {
		return startValue;
	}
	public void setStartValue(T startValue) {
		this.startValue = startValue;
	}
	public T getEndValue() {
		return endValue;
	}
	public void setEndValue(T endValue) {
		this.endValue = endValue;
	}
}
