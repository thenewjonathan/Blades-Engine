package com.thenewjonathan.test;

import com.thenewjonathan.enums.*;
import com.thenewjonathan.heros.classes.*;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.objects.usables.Armor;
import com.thenewjonathan.objects.usables.Effect;
import com.thenewjonathan.objects.usables.Weapon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WeaponTest
{
	Combatant gandalf, saroun, sevarious, ang, shadow, grethor;
	Armor fakeArmor;

	@Before
	public void initialize()
	{
		ArrayList<Weapon> gandalfWeapons = new ArrayList<Weapon>();
		gandalfWeapons.add(Weapons.frostStaff.getWeapon());
		gandalf = new RedWizard("Gandalf", Genders.MALE, 15, 50, 50, 150, 500, 150, 50, 200, 50, null, 13000,
				gandalfWeapons, null);
		gandalf.addWeaponProficiencyTypes(WeaponTypes.STAFF);
		gandalf.pickUpWeapon(Weapons.frostStaff.getWeapon());
		saroun = new NerullFollower("Saroun", Genders.MALE, 5, 50, 50, 150, 500, 150, 50, 200, 50, null, 13000, null,
				null);
		saroun.addWeaponProficiencyTypes(WeaponTypes.STAFF);
		saroun.pickUpWeapon(Weapons.quarterstaff.getWeapon());
		sevarious =
				new Fighter("Sevarious", Genders.MALE, 13, 200, 200, 100, 500, 150, 150, 100, 150, null, 13000, null,
						null);
		sevarious.addWeaponProficiencyTypes(WeaponTypes.UNARMEDAUGMENT);
		sevarious.pickUpWeapon(Weapons.fireFists.getWeapon());
		ang = new Barbarian("Ang", Genders.MALE, 12, 150, 100, 200, 500, 100, 100, 250, 200, null, 12000, null, null);
		ang.addWeaponProficiencyTypes(WeaponTypes.HEAVYBLADE);
		ang.addWeaponProficiencyTypes(WeaponTypes.MACE);
		ang.pickUpWeapon(Weapons.crackle.getWeapon());
		shadow = new ObadHaiFollower("Shadow", Genders.MALE, 12, 150, 100, 200, 500, 100, 100, 250, 200, null, 12000,
				null, null);
		shadow.addWeaponProficiencyTypes(WeaponTypes.HEAVYBLADE);
		shadow.addWeaponProficiencyTypes(WeaponTypes.LIGHTBLADE);
		shadow.pickUpWeapon(Weapons.snakeTooth.getWeapon());
		grethor = new Ranger("Grethor", Genders.MALE, 12, 150, 100, 200, 500, 100, 100, 250, 200, null, 12000, null,
				null);
		grethor.addWeaponProficiencyTypes(WeaponTypes.AXE);
		grethor.addWeaponProficiencyTypes(WeaponTypes.CROSSBOW);
		grethor.pickUpWeapon(Weapons.jaggedAxe.getWeapon());
		fakeArmor =
				new Armor("The Force", "Meant to block anything unless it ignores armor", 1, ArmorTypes.LIGHT, 50000,
						500);
	}

	@Test
	public void testMagicWeapons()
	{
		gandalf.gainLife(25000);
		saroun.gainLife(25000);
		sevarious.gainLife(25000);
		ang.gainLife(25000);
		shadow.gainLife(25000);
		grethor.gainLife(25000);
		int c2Life = saroun.getCurrentLife();
		System.out.println("frost staff:");
		froststaff:
		for (int i = 0; i < 20; i++)
		{
			gandalf.attack(saroun);
			gandalf.setAttackedThisRound(false);
			if (c2Life > saroun.getCurrentLife())
			{
				break froststaff;
			}
		}
		assertTrue("c2 took at least 10 damage from frost", c2Life - 10 >= saroun.getCurrentLife());
		c2Life = saroun.getCurrentLife();
		System.out.println("snake tooth:");
		snaketooth:
		for (int i = 0; i < 20; i++)
		{
			shadow.attack(saroun);
			shadow.setAttackedThisRound(false);
			if (c2Life > saroun.getCurrentLife())
			{
				break snaketooth;
			}
		}
		assertTrue("c2 is poisoned", saroun.getCurrentEffects().get(0).getType().equals(EffectTypes.POISON));
		clearEffects();
		System.out.println("crackle:");
		crackle:
		for (int i = 0; i < 20; i++)
		{
			ang.attack(gandalf);
			ang.setAttackedThisRound(false);
			if (gandalf.isStunned())
			{
				break crackle;
			}
		}
		assertTrue("c1 should be stunned", gandalf.isStunned());
		gandalf.setStunned(false);
		firefists:
		for (int i = 0; i < 20; i++)
		{
			sevarious.attack(ang);
			sevarious.setAttackedThisRound(false);
			sevarious.setStunned(false);
			if (ang.getCurrentEffects().size() > 0)
			{
				break firefists;
			}
		}
		assertTrue("c4 should be burning", ang.getCurrentEffects().get(0).getType().equals(EffectTypes.BURNING));
		clearEffects();
		jaggedaxe:
		for (int i = 0; i < 20; i++)
		{
			grethor.attack(saroun);
			grethor.setAttackedThisRound(false);
			if (saroun.getCurrentEffects().size() > 0)
			{
				break jaggedaxe;
			}
		}
		assertTrue("c2 is bleeding", saroun.getCurrentEffects().get(0).getType().equals(EffectTypes.BLEEDING));
		clearEffects();
		// check the alternate path for a defender swing
		saroun.addDefender(Defenders.magicWall.getDefender());
		c2Life = saroun.getCurrentLife();
		gandalf.attack(saroun);
		assertEquals("c2 shouldn't have been hit", c2Life, saroun.getCurrentLife());
		if (saroun.isHasDefender())
		{
			saroun.removeDefender();
		}
		// ignore armor attribute
		while (grethor.getWeaponsInPlay().size() > 0)
		{
			grethor.dropWeapon(grethor.getWeaponsInPlay().get(0));
		}
		grethor.pickUpWeapon(Weapons.piercingSpear.getWeapon());
		sevarious.putOnArmor(fakeArmor);
		int c3Life = sevarious.getCurrentLife();
		ignorearmor:
		for (int i = 0; i < 10; i++)
		{
			grethor.attack(sevarious);
			grethor.setAttackedThisRound(false);
			if (c3Life > sevarious.getCurrentLife())
			{
				break ignorearmor;
			}
		}
		assertTrue("c3 should have been hit even with the crazy armor", c3Life > sevarious.getCurrentLife());
		sevarious.takeOffArmor(fakeArmor);
		// crit hit mod
//		while (shadow.getWeaponsInPlay().size() > 0)
//		{
//			shadow.dropWeapon(shadow.getWeaponsInPlay().get(0));
//		}
//		shadow.pickUpWeapon(Weapons.katar.getWeapon());
//		int minimumDamage = 7 + shadow.getCurrentPower();
//		boolean critHit = false;
//		int grethorLife = grethor.getCurrentLife();
//		shadow.setStunned(false);
//		shadow.setAccuracy(5000);
//		crithit:
//		for (int i = 0; i < 500; i++)
//		{
//			shadow.attack(grethor);
//			shadow.setAttackedThisRound(false);
//			if (grethor.getCurrentLife() < grethorLife - minimumDamage)
//			{
//				critHit = true;
//				break crithit;
//			}
//			if (grethor.isDead())
//			{
//				grethor.gainLife(50000);
//				grethor.setDead(false);
//			}
//		}
//		assertTrue("after 500 strokes, we should get at least one crithit", critHit);
	}

	@Test
	public void testMultipleEffectsFromMagicWeapons()
	{
		// multiple effects of same type
		sevarious.setCurrentEffects(null);
		sevarious.setCurrentLife(400);
		boolean lessThanTwo = true;
		//TODO find out why the effect array suddenly wasn't populated.
		sevarious.setCurrentEffects(new ArrayList<Effect>());
		while (lessThanTwo)
		{
			shadow.attack(sevarious);
			shadow.setAttackedThisRound(false);
			if (sevarious.hasEffects() && sevarious.getCurrentEffects().size() >= 2)
			{
				lessThanTwo = false;
			}
		}
		assertTrue(sevarious.getCurrentEffects().size() == 2);

		int life = sevarious.getCurrentLife();
		sevarious.executeEffects();
		assertEquals(life - 20, sevarious.getCurrentLife());
		sevarious.executeEffects();
		assertEquals(life - 30, sevarious.getCurrentLife());
	}

	@Test
	public void testImmuneToDamage()
	{
		int angLife = ang.getCurrentLife();
		ang.setIgnoreDamage(true);
		ang.dropWeapon(Weapons.crackle.getWeapon());
		ang.pickUpWeapon(Weapons.mace.getWeapon());
		shadow.attack(ang);
		assertEquals("ang should have ignored the damage from shadow's weapon", angLife, ang.getCurrentLife());
		clearEffects();
		shadow.dropWeapon(Weapons.snakeTooth.getWeapon());
		shadow.pickUpWeapon(Weapons.dagger.getWeapon());
		angLife = ang.getCurrentLife();
		shadow.attack(ang);
		assertEquals("again, no damage to ang as he ignores it", angLife, ang.getCurrentLife());
	}

	private void clearEffects()
	{
		clearEffect(gandalf);
		clearEffect(saroun);
		clearEffect(sevarious);
		clearEffect(ang);
		clearEffect(shadow);
		clearEffect(grethor);
	}

	private void clearEffect(Combatant c)
	{
		for (int i = 0; i < c.getCurrentEffects().size(); i++)
		{
			Effect e = c.getCurrentEffects().get(i);
			while (!e.execute(c))
			{
			}
			c.getCurrentEffects().remove(e);
		}
	}
}
