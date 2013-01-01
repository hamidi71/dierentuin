package org.biz.dierentuin;

import static org.junit.Assert.*;

import org.junit.Test;

public class HokTest {

	@Test
	public void testHok() {
		Hok hok = new Hok();
		assertNotNull(hok);

	}

	@Test
	public void testSetHond() {
		Hok hok = new Hok();
		Hond hond = new Hond();
		hok.setHond(hond);
		assertEquals("Woef!!!",hok.getHond().praat());
	}

	@Test
	public void testGetHond() {
		testSetHond();
	}

	@Test
	public void testSetPoes() {
		Hok hok = new Hok();
		Poes poes = new Poes();
		hok.setPoes(poes);
		assertEquals("Miauw!!!",hok.getPoes().praat());
	}

	@Test
	public void testGetPoes() {
		testSetPoes();
	}

}
