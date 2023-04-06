package com.thenewjonathan.test.Heros;

import com.thenewjonathan.heros.classes.*;
import com.thenewjonathan.heros.superclasses.Combatant;

import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.*;

public class ElementalBladeTest
{
	// list of combatants here
	Combatant c1, c2;

	@Before
	public void initialize()
	{
		c1 = new ElementalBlade();
		c2 = c1.clone();
	}

	@Test
	public void testElementalBlade()
	{
		assertEquals(c1, c2);
		assertNotEquals(c1.hashCode(), c2.hashCode());

		assertEquals(100, c1.getStrength());
		assertEquals(100, c1.getAgility());
		assertEquals(200, c1.getIntelligence());
		assertEquals(150, c1.getAccuracy());
		assertEquals(100, c1.getWisdom());
		assertEquals(50, c1.getConstitution());
		assertEquals(150, c1.getWill());
		assertEquals(150, c1.getWeaponProficiency());
	}
}
