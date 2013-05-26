/**
 * 
 */
package org.ikane.m101j.week2;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
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
public class UpdateTest {

	
	public static void main(String[] args)  throws UnknownHostException {
		MongoClient client = new MongoClient();
		DB coursedb = client.getDB("course");
		
		DBCollection collection = coursedb.getCollection("updateTest");
		collection.drop();
		
		List<String> users = Arrays.asList("alice","bobby","cathy","david", "ethan");
		
		for (String user: users) {
			collection.insert(new BasicDBObject("_id", user));
		}
		
		collection.update(new BasicDBObject("_id","alice"), new BasicDBObject("age",24));
		
		collection.update(new BasicDBObject("_id","alice"), new BasicDBObject("$set",new BasicDBObject("gender", "F")));
		
		collection.update(new BasicDBObject("_id","franck"), new BasicDBObject("$set",new BasicDBObject("gender", "M")),true,false);
		
		DBCursor cursor = collection.find();
		try {
			while(cursor.hasNext())
				System.out.println(cursor.next());
		} finally {
			cursor.close();
		}
	}

}
