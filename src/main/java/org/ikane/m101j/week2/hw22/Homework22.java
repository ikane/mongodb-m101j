/**
 * 
 */
package org.ikane.m101j.week2.hw22;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.QueryBuilder;

/**
 * @author ikane
 *
 */
public class Homework22 {

	public static void main(String[] args) throws UnknownHostException {
		MongoClient client = new MongoClient();
		DB coursedb = client.getDB("students");
		DBCollection c = coursedb.getCollection("grades");
		
		QueryBuilder query = QueryBuilder.start("type").is("homework");
		DBCursor cursor = c.find(query.get()).sort(new BasicDBObject("student_id", 1).append("score", 1));
		try {
			Integer studentIdPrev = null;
			while(cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				Integer studentIdCurrent = (Integer)dbObject.get("student_id");
				
				if(studentIdPrev==null || studentIdCurrent.intValue() != studentIdPrev.intValue()) {
					//System.out.println(studentIdCurrent);
					c.remove(dbObject);
					studentIdPrev = studentIdCurrent;
				}
				//System.out.println(dbObject);
			}
		} finally {
			cursor.close();
		}
		
	}

}
