package com.thenewjonathan.test.Heros;

import com.thenewjonathan.heros.classes.RaoFollower;
import com.thenewjonathan.heros.superclasses.Combatant;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RaoFollowerTest
{
	// list of combatants here
	Combatant c1, c2;

	@Before
	public void initialize()
	{
		c1 = new RaoFollower();
		c2 = c1.clone();
	}

	@Test
	public void testRaoFollower()
	{
		assertEquals(c1, c2);
		assertNotEquals(c1.hashCode(), c2.hashCode());

		assertEquals(50, c1.getStrength());
		assertEquals(50, c1.getAgility());
		assertEquals(150, c1.getIntelligence());
		assertEquals(50, c1.getAccuracy());
		assertEquals(150, c1.getWisdom());
		assertEquals(250, c1.getConstitution());
		assertEquals(250, c1.getWill());
		assertEquals(50, c1.getWeaponProficiency());
	}
}
