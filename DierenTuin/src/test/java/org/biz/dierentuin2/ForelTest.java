package org.biz.dierentuin2;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("/dierentuin2.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ForelTest
{
	@Autowired
	protected Forel forel;
	
	@Test
	public void testPraat() {
		assertEquals("Forel zegt Blub!!!", "Blub!!!", forel.praat());
	}
}
