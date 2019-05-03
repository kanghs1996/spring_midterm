package org.kanghs.subsc;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SubscMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("subsc-context.xml");
		SubscService subscService = ctx.getBean("subscService", SubscService.class);
		
		subscService.subscribe();
		subscService.list();
		ctx.close();
	}

}
