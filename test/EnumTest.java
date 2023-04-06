package com.thenewjonathan.test;

import com.thenewjonathan.enums.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnumTest
{

	@Test
	public void test()
	{
		assertEquals("heavy armor should come out Heavy", ArmorTypes.HEAVY.toString(), "Heavy");
		assertEquals("ice damage should come out Ice", DamageTypes.ICE.toString(), "Ice");
		assertEquals("burning effect should come out Burning", EffectTypes.BURNING.toString(), "Burning");
		assertEquals("defender magic wall should come out Magic Wall", Defenders.magicWall.toString(), "Magic Wall");
		assertEquals("attack card type should come out Attack", CardType.ATTACK.toString(), "Attack");
		assertEquals("male gender should come out Male", Genders.MALE.toString(), "Male");
		assertEquals("mace weapon type should come out Mace", WeaponTypes.MACE.toString(), "Mace");
		assertEquals("checking defenders description", "Basic magic wall summoned to protect a hero",
				Defenders.magicWall.getDescription());
	}

}
