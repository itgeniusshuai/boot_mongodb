package com.mongo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
public class MongoConfig {
	@Value("${spring.data.mongodb.host}")
	private String host;
	@Value("${spring.data.mongodb.port}")
	private int port;
	@Value("${spring.data.mongodb.database}")
	private String database;
	@Value("${spring.data.mongodb.username}")
	private String username;
	@Value("${spring.data.mongodb.password}")
	private String password;
	
	 @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {

        List<ServerAddress> addresses = new ArrayList<ServerAddress>();
        ServerAddress addr = new ServerAddress(host,port);
//        ServerAddress addr2 = new ServerAddress("10.100.138.95", 27017);
//        ServerAddress addr3 = new ServerAddress("10.100.138.96", 27018);
        addresses.add(addr);
//        addresses.add(addr2);
//        addresses.add(addr3);
        //MongoCredential mongoCredential = MongoCredential.createMongoCRCredential(username,database,password.toCharArray());
        List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
       // credentialsList.add(mongoCredential);
        MongoDbFactory mongoDbFactory =   new SimpleMongoDbFactory(new MongoClient(addresses, credentialsList),
        		database);
        return mongoDbFactory;
    }
	 
	 public MongoTemplate primaryMongoTemplate() throws Exception {
	        return new MongoTemplate(mongoDbFactory());
	    }


}
