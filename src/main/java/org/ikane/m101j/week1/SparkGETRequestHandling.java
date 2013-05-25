/**
 * 
 */
package org.ikane.m101j.week1;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * @author ikane
 *
 */
public class SparkGETRequestHandling {

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Spark.get(new Route("/") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				return "Hello World from SPARK!";
			}
		});
		
		Spark.get(new Route("/test") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				return "Hello World from SPARK with test!";
			}
		});
		

		Spark.get(new Route("/echo/:thing") {
			@Override
			public Object handle(Request request, Response response) {
				return request.params(":thing");
			}
		});
	}

}
