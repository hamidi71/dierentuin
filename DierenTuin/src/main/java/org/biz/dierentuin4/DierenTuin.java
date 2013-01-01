package org.biz.dierentuin4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DierenTuin {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"dierentuin4.xml"}); 

		VierVoeter dier1 = (VierVoeter)context.getBean("dier1");
		dier1.praat();

		VierVoeter dier2 = (VierVoeter)context.getBean("dier2");
		dier2.praat();
	}
}
