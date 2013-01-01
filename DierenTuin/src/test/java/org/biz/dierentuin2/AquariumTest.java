package org.biz.dierentuin2;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockExpressionEvaluator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("/dierentuin2.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AquariumTest {

	@Autowired
	protected Aquarium aq;

	@Test
	public void testAquarium() {
		Forel forel = new Forel();
		Aquarium newaq = new Aquarium(forel);
		assertEquals("Blub!!!", newaq.getForel().praat());
	}

	@Test
	public void testGetForel() {
		assertEquals("Blub!!!", aq.getForel().praat());
	}
	
	@Test
	public void testAquariumMockedVerify() {
		Forel forel = mock(Forel.class);
		Aquarium newaq = new Aquarium(forel);
		newaq.getForel().praat();
		verify(forel).praat();
		//assertEquals("Blub!!!", newaq.getForel().praat());
	}
	
	@Test
	public void testAquariumMockedWhen() {
		Forel forel = mock(Forel.class);
		Aquarium newaq = new Aquarium(forel);
		when(forel.praat()).thenReturn("BlubBlub!!!");
		newaq.getForel().praat();
		verify(forel).praat();
		assertEquals("BlubBlub!!!", newaq.getForel().praat());
		assertEquals("Blub!!!", aq.getForel().praat());
	}
	
	@Test(expected=Exception.class)
	public void testAquariumMockedPlantWhenVoidException() throws Exception {
		Forel forel = mock(Forel.class);
		Plant plant = mock(Plant.class);
		Aquarium newaq = new Aquarium(forel);
		doThrow(new Exception()).when(plant).praat();
		newaq.getPlant().praat();
	}
	
	@Test
	public void testAquariumMockedPlant() {
		Forel forel = mock(Forel.class);
		Plant plant = mock(Plant.class);
		assertEquals (0, plant.getSize());
		Aquarium newaq = new Aquarium(forel);
		newaq.setPlant(plant);
		assertEquals (0, newaq.getPlant().getSize());
		verify(newaq.getPlant()).groei(10);
	}


}
