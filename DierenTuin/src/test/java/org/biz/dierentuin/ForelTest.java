package org.biz.dierentuin;

import static org.junit.Assert.*;

import org.junit.Test;

public class ForelTest {

	@Test
	public void testPraat() {
		Forel forel = new Forel();		
		assertEquals("Forel zegt Blub!!!", "Blub!!!", forel.praat());
	}

}
