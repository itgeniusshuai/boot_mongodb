package com.mongo.document;

import java.util.List;
import java.util.Map;

import com.mongo.service.impl.ValueInterval;

public class CarConditionDoc extends CarDoc{

	/**
	 * 查询条件
	 */
	private static final long serialVersionUID = 1L;

	List<ValueInterval<Double>> priceList;

	public List<ValueInterval<Double>> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<ValueInterval<Double>> priceList) {
		this.priceList = priceList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
