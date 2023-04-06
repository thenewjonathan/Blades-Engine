package com.thenewjonathan.test.Heros;

import com.thenewjonathan.heros.classes.*;
import com.thenewjonathan.heros.superclasses.Combatant;

import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.*;

public class RangerTest
{
	// list of combatants here
	Combatant c1, c2;

	@Before
	public void initialize()
	{
		c1 = new Ranger();
		c2 = c1.clone();
	}

	@Test
	public void testRanger()
	{
		assertEquals(c1, c2);
		assertNotEquals(c1.hashCode(), c2.hashCode());

		assertEquals(100, c1.getStrength());
		assertEquals(250, c1.getAgility());
		assertEquals(100, c1.getIntelligence());
		assertEquals(150, c1.getAccuracy());
		assertEquals(100, c1.getWisdom());
		assertEquals(100, c1.getConstitution());
		assertEquals(50, c1.getWill());
		assertEquals(150, c1.getWeaponProficiency());
	}
}
