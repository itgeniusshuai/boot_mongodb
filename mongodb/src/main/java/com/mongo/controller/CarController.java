package com.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.common.GlobalResult;
import com.mongo.document.CarDoc;
import com.mongo.repository.CarRepository;
import com.mongo.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private CarService carService;
	

	public GlobalResult add(CarDoc carDoc){
		carRepository.insert(carDoc);
		return GlobalResult.ok("");
	}
	public GlobalResult delete(){
		return null;
	}
	public GlobalResult update(CarDoc carDoc){
		carRepository.save(carDoc);
		return GlobalResult.ok("修改成功！！！");
	}
	@RequestMapping("/find")
	public GlobalResult find(CarDoc carDoc){
		List<CarDoc> list = carService.findByCondition(carDoc);
		return GlobalResult.ok(list);
	}
	
	
}
