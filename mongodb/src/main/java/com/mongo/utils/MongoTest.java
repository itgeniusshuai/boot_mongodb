//package com.mongo.utils;
//
//
//import java.beans.BeanInfo;
//import java.beans.Introspector;
//import java.beans.PropertyDescriptor;
//
//import org.bson.Document;
//
//import com.mongo.document.CarDoc;
//import com.mongodb.MongoClient;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//
//public class MongoTest {
//	public static void main(String[] args) throws Exception {
//		MongoClient client = new MongoClient("localhost", 27017);
//		MongoDatabase db = client.getDatabase("auction");  
//	    System.out.println("Connect to database successfully");
//	    db.createCollection("car");
//	    MongoCollection<Document> collection = db.getCollection("car");
//		BeanInfo beanInfo = Introspector.getBeanInfo(CarDoc.class);
//		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
//	    for(int i = 0; i < 5000; i++){
//	    	CarDoc car = CarGenerator.Generated(i);
//	    	Document document = new Document();
//	    	for(PropertyDescriptor descriptor : propertyDescriptors){
//	    		if(descriptor.getName().equals("class")) continue;
//	    		document.append(descriptor.getName(), descriptor.getReadMethod().invoke(car));
//	    	}
//	    	System.out.println(document);
//	    	collection.insertOne(document);
//	    }
//	}
//}
