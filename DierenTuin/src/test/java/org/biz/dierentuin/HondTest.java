package org.biz.dierentuin;

import static org.junit.Assert.*;

import org.junit.Test;

public class HondTest {

	@Test
	public void testHond() {
		Hond hond = new Hond();	
		assertNotNull(hond);
	}

	@Test
	public void testPraat() {
		Hond hond = new Hond();		
		assertEquals("Hond zegt Woef!!!", "Woef!!!", hond.praat());
	}

}
