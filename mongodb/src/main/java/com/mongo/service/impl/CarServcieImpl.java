package com.mongo.service.impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mongo.document.CarConditionDoc;
import com.mongo.document.CarDoc;
import com.mongo.repository.CarRepository;
import com.mongo.service.CarService;

@Service
public class CarServcieImpl implements CarService{

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private CarRepository carRepository;
	
	@Override
	public List<CarDoc> findByCondition(CarDoc carDoc) {
		BeanInfo beanInfo;
		try {
			Query query = new Query();
			beanInfo = Introspector.getBeanInfo(CarDoc.class);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for(PropertyDescriptor pdf : propertyDescriptors){
				Criteria criteria = null;
				Object result = pdf.getReadMethod().invoke(carDoc);
				if("class".equals(pdf.getName()) || StringUtils.isEmpty(result)) continue;
				if(pdf.getPropertyType().equals(Long.class)){
					
					 criteria = Criteria.where(pdf.getName()).lt(50000);
				}else {
					criteria = Criteria.where(pdf.getName()).is(result);
					
				}
				query.addCriteria(criteria);
			}
//			mongoTemplate.count(query, CarDoc.class);
			List<CarDoc> list = mongoTemplate.find(query, CarDoc.class);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public int update(CarDoc carDoc) {
		try {
			Query query = new Query(Criteria.where("id").is(carDoc.getId()));
			Update update = new Update();
			BeanInfo beanInfo = Introspector.getBeanInfo(CarDoc.class);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for(PropertyDescriptor pdf : propertyDescriptors){
				Object result = pdf.getReadMethod().invoke(carDoc);
				if("class".equals(pdf.getName()) || StringUtils.isEmpty(result)) continue;
				update.set(pdf.getName(), result);
			}
			mongoTemplate.updateFirst(query, update, CarDoc.class);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Page<CarDoc> findByExample(CarDoc carDoc) {
		return null;
	}

	@Override
	public List<CarDoc> findByCondition(CarConditionDoc carConditionDoc) {
		Query query = new Query();
		Criteria criteria = new Criteria();
		List<Criteria> orList = new ArrayList<>();
		for(ValueInterval<Double> valueInterval : carConditionDoc.getPriceList()){
			Criteria criteria1 = Criteria.where("price").lt(valueInterval.getEndValue()).gt(valueInterval.getStartValue());
			orList.add(criteria1);
		}
		Criteria criteria2 = criteria.orOperator(orList.get(0));
		Criteria criteria4 = orList.get(1).orOperator(criteria2);
		Criteria criteria3 = new Criteria();
		criteria3.andOperator(Criteria.where("conditionGrade").gt(2),criteria4);
		query.addCriteria(criteria3);
		List<CarDoc> list = mongoTemplate.find(query, CarDoc.class);
		return list;
	}

}
