package org.biz.dierentuin3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DierenTuin {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"dierentuin3.xml"}); 
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//context.scan("org.biz.dierentuin3");
		//context.refresh();
		
		Hok hok = (Hok)context.getBean("hok");
		hok.getHond().praat();
		hok.getPoes().praat();		
		
		Aquarium aquarium = (Aquarium)context.getBean("aquarium");
		aquarium.getForel().praat();
	}
}
