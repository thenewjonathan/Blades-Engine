package com.thenewjonathan.test.Heros;

import com.thenewjonathan.heros.classes.*;
import com.thenewjonathan.heros.superclasses.Combatant;

import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.*;

public class NerullFollowerTest
{
	// list of combatants here
	Combatant c1, c2;

	@Before
	public void initialize()
	{
		c1 = new NerullFollower();
		c2 = c1.clone();
	}

	@Test
	public void testNerullFollower()
	{
		assertEquals(c1, c2);
		assertNotEquals(c1.hashCode(), c2.hashCode());

		assertEquals(25, c1.getStrength());
		assertEquals(50, c1.getAgility());
		assertEquals(300, c1.getIntelligence());
		assertEquals(50, c1.getAccuracy());
		assertEquals(50, c1.getWisdom());
		assertEquals(25, c1.getConstitution());
		assertEquals(350, c1.getWill());
		assertEquals(150, c1.getWeaponProficiency());
	}
}
