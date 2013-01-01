package org.biz.dierentuin;

import static org.junit.Assert.*;

import org.junit.Test;

public class PoesTest {

	@Test
	public void testPraat() {
		Poes poes = new Poes();		
		assertEquals("Poes zegt Miauw!!!", "Miauw!!!", poes.praat());
	}
}
