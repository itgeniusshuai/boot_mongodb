package com.mongo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mongo.document.CarConditionDoc;
import com.mongo.document.CarDoc;

public interface CarService {

	public List<CarDoc> findByCondition(CarDoc carDoc);
	
	public List<CarDoc> findByCondition(CarConditionDoc carConditionDoc);
	
	public int update(CarDoc carDoc);
	
	public Page<CarDoc> findByExample(CarDoc carDoc);
}
