package com.thenewjonathan.test.Enums;

import com.thenewjonathan.enums.Monsters;
import com.thenewjonathan.heros.classes.*;
import com.thenewjonathan.heros.superclasses.Combatant;

import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.*;

public class MonstersEnumTest
{
	@Test
	public void testMonstersEnum()
	{
		assertTrue("Wolf".equals(Monsters.wolf.toString()));
	}
}
