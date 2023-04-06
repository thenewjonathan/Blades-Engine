package com.thenewjonathan.test.Abilities;

import com.thenewjonathan.heros.classes.*;
import com.thenewjonathan.heros.superclasses.Combatant;

import java.util.ArrayList;

import static org.junit.Assert.*;

import com.thenewjonathan.objects.usables.Ability;
import org.junit.*;

public class AbilityTest
{
	Ability a;

	@Before
	public void initialize()
	{
		a = new Ability("Test Ability", "To test with", 1, 1, 1);
	}

	@Test
	public void testAbility()
	{

	}
}
