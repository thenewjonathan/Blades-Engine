package com.thenewjonathan.test.Enums;

import com.thenewjonathan.enums.Genders;
import com.thenewjonathan.heros.classes.*;
import com.thenewjonathan.heros.superclasses.Combatant;

import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.*;

public class GenderTest
{
	@Test
	public void testGenders()
	{
		assertTrue("Male".equals(Genders.getGenderByString("MaLe").toString()));
		assertTrue("Female".equals(Genders.getGenderByString("female").toString()));
	}
}
