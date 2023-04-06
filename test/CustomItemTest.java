package com.thenewjonathan.test;

import com.thenewjonathan.enums.Armors;
import com.thenewjonathan.enums.Genders;
import com.thenewjonathan.enums.WeaponTypes;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.objects.usables.Armor;
import com.thenewjonathan.objects.usables.Weapon;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CustomItemTest
{
	Combatant punchingBag = new Combatant("Punching Bag 1", Genders.MALE, 15, 100, 100, 50, 100, 50, 50, 50, 100,
			new ArrayList<WeaponTypes>(), 500, new ArrayList<Weapon>(), new ArrayList<Armor>());

	@Test
	public void testCursedGlovesOfGiantStrength()
	{
		punchingBag.setCurrentLife(500);
		int bagLife = punchingBag.getCurrentLife();
		int bagStrength = punchingBag.getStrength();
		System.out.println(punchingBag.putOnArmor(Armors.cursedGlovesOfGiantStrength.getArmor()));
		assertEquals("took 10 damage", bagLife - 10, punchingBag.getCurrentLife());
		assertEquals("+200 str", bagStrength + 200, punchingBag.getStrength());
		assertEquals("poison effect given", 1, punchingBag.getCurrentEffects().size());
	}
}
