/**
 * 
 */
package org.ikane.m101j;

import java.io.IOException;
import java.io.StringWriter;
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
public class HelloWorldSparkFreemarkerStyle {

	
	public static void main(String[] args) throws Exception {
		final Configuration conf = new Configuration();
		conf.setClassForTemplateLoading(HelloWorldSparkFreemarkerStyle.class, "/");
		
		Spark.get(new Route("/") {
			
			@Override
			public Object handle(Request request, Response response) {
				StringWriter writer = new StringWriter();
				Map<String, Object> map = new HashMap<>();
				map.put("name", "freemarker");
				try {
					Template t = conf.getTemplate("hello.ftl");
					t.process(map, writer);
				} catch (Exception e) {
					halt(500);
					e.printStackTrace();
				}
				return writer;
			}
		});
	}

}
