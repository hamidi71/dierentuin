package org.biz.dierentuin;

import static org.junit.Assert.*;
import org.junit.Test;

public class AquariumTest {

	@Test
	public void testAquarium() {
		Forel forel = new Forel();
		Aquarium aq = new Aquarium(forel);
		assertEquals("Blub!!!", aq.getForel().praat());
	}

	@Test
	public void testGetForel() {
		testAquarium();
	}

}
