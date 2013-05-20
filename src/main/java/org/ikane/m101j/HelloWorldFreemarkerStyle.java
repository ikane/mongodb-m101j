/**
 * 
 */
package org.ikane.m101j;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;


import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @author ikane
 *
 */
public class HelloWorldFreemarkerStyle {

	
	public static void main(String[] args) throws Exception {
		Configuration configuration = new Configuration();
		Template template = configuration.getTemplate("hello.ftl");
		
		Map<String, Object> map = new HashMap<>();
		map.put("name", "freemarker");
		StringWriter out = new StringWriter();
		
		template.process(map, out);
		
		System.out.println(out);
	}

}
