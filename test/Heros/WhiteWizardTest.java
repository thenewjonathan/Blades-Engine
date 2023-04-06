package com.thenewjonathan.test.Heros;

import com.thenewjonathan.heros.classes.*;
import com.thenewjonathan.heros.superclasses.Combatant;

import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.*;

public class WhiteWizardTest
{
	// list of combatants here
	Combatant c1, c2;

	@Before
	public void initialize()
	{
		c1 = new WhiteWizard();
		c2 = c1.clone();
	}

	@Test
	public void testWhiteWizard()
	{
		assertEquals(c1, c2);
		assertNotEquals(c1.hashCode(), c2.hashCode());

		assertEquals(50, c1.getStrength());
		assertEquals(50, c1.getAgility());
		assertEquals(350, c1.getIntelligence());
		assertEquals(50, c1.getAccuracy());
		assertEquals(200, c1.getWisdom());
		assertEquals(50, c1.getConstitution());
		assertEquals(250, c1.getWill());
		assertEquals(0, c1.getWeaponProficiency());
	}
}
