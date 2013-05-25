/**
 * 
 */
package org.ikane.m101j.week2;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * @author ikane
 *
 */
public class InsertTest {

	
	public static void main(String[] args) throws UnknownHostException {
		MongoClient client = new MongoClient();
		
		DB coursedb = client.getDB("course");
		
		DBCollection collection = coursedb.getCollection("insertTest");
		
		DBObject doc = new BasicDBObject("x", 1);
		
		System.out.println(doc);
		
		collection.insert(doc);
		
		System.out.println(doc);
	}

}
