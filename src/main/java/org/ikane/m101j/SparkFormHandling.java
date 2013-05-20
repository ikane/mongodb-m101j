/**
 * 
 */
package org.ikane.m101j;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
public class SparkFormHandling {

	public static void main(String[] args) {

		final Configuration conf = new Configuration();
		conf.setClassForTemplateLoading(SparkFormHandling.class, "/");

		Spark.get(new Route("/") {

			@Override
			public Object handle(Request request, Response response) {
				StringWriter writer = new StringWriter();
				try {
					Template t = conf.getTemplate("favorite_fruit.ftl");
					Map<String, Object> map = new HashMap<>();
					map.put("fruits", Arrays.asList("pomme", "banane",
							"orange", "clementine"));
					t.process(map, writer);
				} catch (Exception e) {
					halt(500);
					e.printStackTrace();
				}
				return writer;
			}
		});
		
		Spark.post(new Route("/favorite_fruit") {
			
			@Override
			public Object handle(Request request, Response response) {
				return "Your favorite fruit is " + request.params("fruit");
			}
		});
	}

}