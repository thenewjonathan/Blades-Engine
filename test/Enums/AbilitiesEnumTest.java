package com.thenewjonathan.test.Enums;

import com.thenewjonathan.enums.Abilities;
import com.thenewjonathan.heros.classes.*;
import com.thenewjonathan.heros.superclasses.Combatant;

import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.*;

public class AbilitiesEnumTest
{
	@Test
	public void testAbilitiesEnum()
	{
		assertTrue("Hurt".equals(Abilities.hurt.toString()));
		assertNull(Abilities.getAbilityByName("LongestNameInTheEntireWorld"));
	}
}
