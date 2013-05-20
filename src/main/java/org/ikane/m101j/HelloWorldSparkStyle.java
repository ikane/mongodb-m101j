/**
 * 
 */
package org.ikane.m101j;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * @author ikane
 *
 */
public class HelloWorldSparkStyle {

	
	public static void main(String[] args) {
		Spark.get(new Route("/") {
			
			@Override
			public Object handle(Request arg0, Response arg1) {
				return "Hello World from SPARK!";
			}
		});
	}

}
