package org.biz.dierentuin2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("/dierentuin2.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class HokTest {

	@Autowired
	protected Hok hok;

	@Test
	public void testHok() {
		Hok newhok = new Hok();
		assertNotNull(newhok);
	}

	@Test
	public void testSetHond() {
		Hond newhond = new Hond();
		hok.setHond(newhond);
		assertEquals("Woef!!!",hok.getHond().praat());
	}

	@Test
	public void testGetHond() {
		assertEquals("Woef!!!",hok.getHond().praat());
	}

	@Test
	public void testSetPoes() {
		Poes newpoes = new Poes();
		hok.setPoes(newpoes);
		assertEquals("Miauw!!!",hok.getPoes().praat());
	}

	@Test
	public void testGetPoes() {
		assertEquals("Miauw!!!",hok.getPoes().praat());
	}

}
