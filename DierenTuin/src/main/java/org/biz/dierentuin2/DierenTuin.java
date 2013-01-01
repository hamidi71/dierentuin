package org.biz.dierentuin2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DierenTuin {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"dierentuin2.xml"}); 

		Aquarium aq = (Aquarium)context.getBean("aquarium");
		aq.getForel().praat();

		Hok hok = (Hok)context.getBean("hok");
		hok.getHond().praat();
		hok.getPoes().praat();		
	}
}
