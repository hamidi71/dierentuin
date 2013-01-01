package org.biz.dierentuin3;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("/dierentuin3.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class HondTest {
	@Autowired
	protected Hond hond;

	@Test
	public void testHond() {
		Hond newhond = new Hond();	
		assertNotNull(newhond);
	}

	@Test
	public void testPraat() {
		assertEquals("Hond zegt Woef!!!", "Woef!!!", hond.praat());
	}

}
