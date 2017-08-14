package com.mongo.service;

import java.util.List;

import com.mongo.document.CarDoc;

public interface CarService {

	public List<CarDoc> findByCondition(CarDoc carDoc);
	
	public int update(CarDoc carDoc);
}
