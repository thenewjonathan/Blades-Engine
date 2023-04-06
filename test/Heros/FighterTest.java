package com.thenewjonathan.test.Heros;

import com.thenewjonathan.heros.classes.Fighter;
import com.thenewjonathan.heros.superclasses.Combatant;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FighterTest
{
	// list of combatants here
	Combatant c1, c2;

	@Before
	public void initialize()
	{
		c1 = new Fighter();
		c2 = c1.clone();
	}

	@Test
	public void testFighter()
	{
		assertEquals(c1, c2);
		assertNotEquals(c1.hashCode(), c2.hashCode());

		assertEquals(150, c1.getStrength());
		assertEquals(150, c1.getAgility());
		assertEquals(100, c1.getIntelligence());
		assertEquals(150, c1.getAccuracy());
		assertEquals(100, c1.getWisdom());
		assertEquals(150, c1.getConstitution());
		assertEquals(100, c1.getWill());
		assertEquals(100, c1.getWeaponProficiency());
	}
}
