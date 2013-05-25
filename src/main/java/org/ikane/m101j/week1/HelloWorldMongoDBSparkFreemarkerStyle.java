/**
 * 
 */
package org.ikane.m101j.week1;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @author ikane
 *
 */
public class HelloWorldMongoDBSparkFreemarkerStyle {

	public static void main(String[] args) throws Exception {
		final Configuration conf = new Configuration();
		conf.setClassForTemplateLoading(HelloWorldSparkFreemarkerStyle.class, "/");
		
		MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
		final DB database = client.getDB("course");
		
		Spark.get(new Route("/") {
			
			@Override
			public Object handle(Request request, Response response) {
				StringWriter writer = new StringWriter();
				
				try {
					Template t = conf.getTemplate("hello.ftl");
					
					DBCollection collection = database.getCollection("hello");
					DBObject document = collection.findOne();
					
					t.process(document, writer);
				} catch (Exception e) {
					halt(500);
					e.printStackTrace();
				}
				return writer;
			}
		});
	}
}
