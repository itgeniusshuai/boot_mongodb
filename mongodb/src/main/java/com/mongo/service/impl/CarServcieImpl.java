package com.mongo.service.impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mongo.document.CarDoc;
import com.mongo.service.CarService;

@Service
public class CarServcieImpl implements CarService{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<CarDoc> findByCondition(CarDoc carDoc) {
		BeanInfo beanInfo;
		try {
			Query query = new Query();
			beanInfo = Introspector.getBeanInfo(CarDoc.class);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for(PropertyDescriptor pdf : propertyDescriptors){
				Object result = pdf.getReadMethod().invoke(carDoc);
				if("class".equals(pdf.getName()) || StringUtils.isEmpty(result)) continue;
				Criteria criteria = Criteria.where(pdf.getName()).is(result);
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

}
