package com.mongo;


import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoTest {
	public static void main(String[] args) {
		MongoClient client = new MongoClient("192.168.1.107", 27017);
		MongoDatabase db = client.getDatabase("auction");  
	    System.out.println("Connect to database successfully");
	    db.createCollection("user");
	    for(int i = 0; i < 10000; i++){
	    	Document document = new Document("id", i);
	    }

	}
}
