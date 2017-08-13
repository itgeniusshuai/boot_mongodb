package com.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.document.CarDoc;

public interface CarRepository extends MongoRepository<CarDoc, String>{
	
	

}
