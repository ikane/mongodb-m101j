/**
 * 
 */
package org.ikane.m101j.week2;

import java.sql.Date;
import java.util.Arrays;

import com.mongodb.BasicDBObject;

/**
 * @author ikane
 *
 */
public class DocumentRepresentionTest {

	
	public static void main(String[] args) {
		BasicDBObject doc = new BasicDBObject();
		doc.put("username", "ikane");
		doc.put("profession", "ingeneer");
		doc.put("birthday", new Date(123456789));
		doc.put("langages", Arrays.asList("java","c++"));
		doc.put("address", new BasicDBObject("street", "antoine de Saint Exupery")
									.append("town", "Kremlin-Bicêtre")
									.append("zip", "94270"));
		
	}

}
