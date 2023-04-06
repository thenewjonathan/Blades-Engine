package com.thenewjonathan.test;

import com.thenewjonathan.enums.Actions;
import com.thenewjonathan.enums.Genders;
import com.thenewjonathan.enums.WeaponTypes;
import com.thenewjonathan.enums.Weapons;
import com.thenewjonathan.heros.classes.BlackWizard;
import com.thenewjonathan.heros.classes.RedWizard;
import com.thenewjonathan.heros.superclasses.Combatant;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class AbilityTest
{
	Combatant gandalf, punchingBag;
	ArrayList<Combatant> targets = new ArrayList<Combatant>();

	@Before
	public void initialize()
	{
		gandalf =
				new RedWizard("Gandalf", Genders.MALE, 15, 50, 50, 150, 500, 150, 50, 200, 50, null, 13000, null, null);
		gandalf.addWeaponProficiencyTypes(WeaponTypes.STAFF);
		gandalf.pickUpWeapon(Weapons.quarterstaff.getWeapon());

		punchingBag =
				new BlackWizard("Sauron", Genders.MALE, 15, 50, 50, 150, 500, 150, 50, 200, 50, null, 13000, null, null);
		punchingBag.addWeaponProficiencyTypes(WeaponTypes.STAFF);
		punchingBag.pickUpWeapon(Weapons.quarterstaff.getWeapon());
		targets.add(punchingBag);
	}

	@Test
	public void testFaceThrust()
	{
		int pbLife = punchingBag.getCurrentLife();
		gandalf.dropWeapon(Weapons.quarterstaff.getWeapon());
		Actions.faceThrust.getAction().play(gandalf,targets);
		assertEquals(pbLife, punchingBag.getCurrentLife());
		gandalf.pickUpWeapon(Weapons.quarterstaff.getWeapon());
		Actions.faceThrust.getAction().play(gandalf, targets);
		assertTrue(pbLife > punchingBag.getCurrentLife());
	}

	@Test
	public void testTaunt()
	{
		int pbAccuracy = punchingBag.getAccuracy();
		Actions.taunt.getAction().play(gandalf, targets);
		assertTrue(pbAccuracy > punchingBag.getAccuracy());
	}
}
