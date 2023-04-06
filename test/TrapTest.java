package com.thenewjonathan.test;

import com.thenewjonathan.enums.Genders;
import com.thenewjonathan.enums.Traps;
import com.thenewjonathan.enums.WeaponTypes;
import com.thenewjonathan.heros.classes.*;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.objects.usables.customtraps.Snare;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrapTest
{
	Combatant c1, c2, c3, c4, c5, c6;

	@Before
	public void initialize()
	{
		c1 = new WhiteWizard("Gandalf", Genders.MALE, 15, 50, 50, 150, 50, 150, 50, 200, 50, null, 13000, null, null);
		c1.addWeaponProficiencyTypes(WeaponTypes.STAFF);
		c2 = new BlueWizard("Saroun", Genders.MALE, 5, 50, 50, 150, 50, 150, 50, 200, 50, null, 13000, null, null);
		c2.addWeaponProficiencyTypes(WeaponTypes.STAFF);
		c3 = new Rogue("Sevarious", Genders.MALE, 13, 200, 200, 100, 200, 150, 150, 100, 150, null, 13000, null, null);
		c3.addWeaponProficiencyTypes(WeaponTypes.STAFF);
		c4 = new RaoFollower("Ang", Genders.MALE, 12, 150, 100, 200, 200, 100, 100, 250, 200, null, 12000, null, null);
		c4.addWeaponProficiencyTypes(WeaponTypes.HEAVYBLADE);
		c4.addWeaponProficiencyTypes(WeaponTypes.MACE);
		c5 = new Ranger("Shadow", Genders.MALE, 12, 150, 100, 200, 200, 100, 100, 250, 200, null, 12000, null, null);
		c5.addWeaponProficiencyTypes(WeaponTypes.HEAVYBLADE);
		c5.addWeaponProficiencyTypes(WeaponTypes.LIGHTBLADE);
		c6 = new HextorFollower("Grethor", Genders.MALE, 12, 150, 100, 200, 200, 100, 100, 250, 200, null, 12000, null,
				null);
		c6.addWeaponProficiencyTypes(WeaponTypes.HEAVYBLADE);
		c6.addWeaponProficiencyTypes(WeaponTypes.CROSSBOW);
	}

	@Test
	public void testSpringTrap()
	{
		int c2Life = c2.getCurrentLife();
		Traps.springTrap.getTrap().executeTrap(c4);
		springtrap:
		for (int i = 0; i < 15; i++)
		{
			Traps.springTrap.getTrap().executeTrap(c2);
			if (i == 0)
			{
				assertEquals("c2's life should be down by 5", c2Life - 5, c2.getCurrentLife());
			}
			if (c2.isStunned())
			{
				break springtrap;
			}
		}
		assertTrue("c2 should be stunned", c2.isStunned());
		assertFalse("c4's agi is over 100 so he should not be affected by this trap", c4.isStunned());
	}

	@Test
	public void testSnare()
	{
		c6.addTrap(Traps.snare.getTrap());
		int c6Life = c6.getCurrentLife();
		c5.attack(c6);
		assertEquals(c6Life, c6.getCurrentLife());
	}

}
