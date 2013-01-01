package org.biz.dierentuin3;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("/dierentuin3.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PoesTest {

	@Autowired
	protected Poes poes;

	@Test
	public void testPraat() {
		assertEquals("Poes zegt Miauw!!!", "Miauw!!!", poes.praat());
	}
}
