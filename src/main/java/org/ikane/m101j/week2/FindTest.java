/**
 * 
 */
package org.ikane.m101j.week2;

import java.net.UnknownHostException;
import java.util.Random;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * @author ikane
 *
 */
public class FindTest {

	
	public static void main(String[] args) throws UnknownHostException {
		MongoClient client = new MongoClient();
		
		DB coursedb = client.getDB("course");
		
		DBCollection collection = coursedb.getCollection("findTest");
		collection.drop();
		
		for (int i = 0; i < 10; i++) {
			DBObject doc = new BasicDBObject("x", new Random().nextInt(100));
			collection.insert(doc);
		}
		
		System.out.println("Find one:");
		System.out.println(collection.findOne());
		
		System.out.println("Find ALL");
		DBCursor cursor = collection.find();
		try {
			while(cursor.hasNext())
				System.out.println(cursor.next());
		} finally {
			cursor.close();
		}
		
		System.out.println("Count");
		System.out.println(collection.count());
	}

}
