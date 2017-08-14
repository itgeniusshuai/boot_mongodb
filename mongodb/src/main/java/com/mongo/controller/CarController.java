package com.mongo.controller;

import java.util.List;
import java.util.Random;

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
		List<CarDoc> list = null;
		for(int i = 0; i < 500; i++){
			list = carService.findByCondition(carDoc);
		}
		return GlobalResult.ok(list);
	}
	
	@RequestMapping("/randomupdate")
	public GlobalResult randomUpdate(){
		int i = 10000000;
		CarDoc carDoc = new CarDoc();
		Random random = new Random();
		while (i-->0) {
			int j = random.nextInt(10000);
			carDoc.setId(j+"");
			carDoc.setCarModelId(random.nextInt(10000));
			carDoc.setBrandId(random.nextInt(10000));
			carDoc.setCarModelId(random.nextInt(10000));
			carService.update(carDoc);
		}
		return GlobalResult.ok("");
	}
	
}
