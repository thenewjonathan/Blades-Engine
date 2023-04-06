package com.thenewjonathan.test.Heros;

import com.thenewjonathan.heros.classes.*;
import com.thenewjonathan.heros.superclasses.Combatant;

import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.*;

public class ShadowDancerTest
{
	// list of combatants here
	Combatant c1, c2;

	@Before
	public void initialize()
	{
		c1 = new ShadowDancer();
		c2 = c1.clone();
	}

	@Test
	public void testShadowDancer()
	{
		assertEquals(c1, c2);
		assertNotEquals(c1.hashCode(), c2.hashCode());

		assertEquals(50, c1.getStrength());
		assertEquals(325, c1.getAgility());
		assertEquals(100, c1.getIntelligence());
		assertEquals(200, c1.getAccuracy());
		assertEquals(50, c1.getWisdom());
		assertEquals(25, c1.getConstitution());
		assertEquals(100, c1.getWill());
		assertEquals(150, c1.getWeaponProficiency());
	}
}
