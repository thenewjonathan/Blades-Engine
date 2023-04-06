package com.thenewjonathan.test;

import com.thenewjonathan.enums.Genders;
import com.thenewjonathan.heros.classes.*;
import com.thenewjonathan.heros.superclasses.Combatant;

import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.*;

public class CustomSpellTest
{
	// list of combatants here
	Combatant wiz, barb, rogue, hex, punchingBag;
	ArrayList<Combatant> targets = new ArrayList<Combatant>();

	@Before
	public void initialize()
	{
		wiz = new RedWizard();
		wiz.setName("Wiz");
		wiz.setLevel(15);
	}

	@Test
	public void test()
	{

	}
}
