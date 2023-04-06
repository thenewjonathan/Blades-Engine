package com.thenewjonathan.test.Abilities;

import com.thenewjonathan.enums.Genders;
import com.thenewjonathan.enums.WeaponTypes;
import com.thenewjonathan.enums.Weapons;
import com.thenewjonathan.heros.classes.HextorFollower;
import com.thenewjonathan.heros.classes.NerullFollower;
import com.thenewjonathan.heros.classes.ObadHaiFollower;
import com.thenewjonathan.heros.classes.RaoFollower;
import com.thenewjonathan.heros.superclasses.Combatant;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
public class AbilityDivineTest
{
	Combatant hex, rao, obad, nerull;
	ArrayList<Combatant> targets;

	@Before
	public void initialize()
	{
		hex = new HextorFollower("Hex", Genders.MALE, 15, 100, 100, 100, 100, 100, 100, 100, 100, null, 1500, null,
				null);
		hex.addWeaponProficiencyTypes(WeaponTypes.AXE);
		hex.pickUpWeapon(Weapons.battleAxe.getWeapon());

		rao = new RaoFollower("Rao", Genders.MALE, 15, 100, 100, 100, 100, 100, 100, 100, 100, null, 1500, null, null);
		rao.addWeaponProficiencyTypes(WeaponTypes.FLAIL);
		rao.pickUpWeapon(Weapons.flail.getWeapon());
		rao.setCurrentLife(5000);

		obad = new ObadHaiFollower("Obad", Genders.MALE, 15, 100, 100, 100, 100, 100, 100, 100, 100, null, 100, null,
				null);
		obad.addWeaponProficiencyTypes(WeaponTypes.STAFF);
		obad.pickUpWeapon(Weapons.quarterstaff.getWeapon());

		nerull = new NerullFollower("Nerull", Genders.MALE, 15, 100, 100, 100, 100, 100, 100, 100, 100, null, 100, null,
				null);
		nerull.addWeaponProficiencyTypes(WeaponTypes.HAMMER);
		nerull.pickUpWeapon(Weapons.warHammer.getWeapon());

		targets = new ArrayList<Combatant>();
	}

	@Test
	public void testHextor()
	{
		// Magic Dart
		targets.add(rao);
		int raoLife = rao.getCurrentLife();
		hex.getAbilityByName("Magic Dart").play(hex, targets);
		assertTrue(raoLife > rao.getCurrentLife());

		// Hextor's Axe
		raoLife = rao.getCurrentLife();
		hex.getAbilityByName("Hextor's Axe").play(hex, targets);
		assertTrue(raoLife > rao.getCurrentLife());
		rao.processAbilityEffects();

		// Essence of Hextor
		int hexAttack = hex.getCurrentPower();
		int hexHitChance = hex.getCurrentHitChance();
		targets.clear();
		targets.add(hex);
		hex.getAbilityByName("Essence Of Hextor").play(hex, targets);
		assertTrue(hexAttack < hex.getCurrentPower());
		assertTrue(hexHitChance < hex.getCurrentHitChance());
		hex.processAbilityEffects();
		assertTrue(hexAttack == hex.getCurrentPower());
		assertTrue(hexHitChance == hex.getCurrentHitChance());

		// Hextor's Mace
		targets.clear();
		targets.add(rao);
		raoLife = rao.getCurrentLife();
		hex.getAbilityByName("Hextor's Mace").play(hex, targets);
		assertTrue(raoLife > rao.getCurrentLife());
		assertEquals(1, rao.getCurrentEffects().size());
		rao.processAbilityEffects();
		rao.executeEffects();
		assertEquals(0, rao.getCurrentEffects().size());
		rao.processAbilityEffects();

		// Hextor's Mantle
		raoLife = 5;
		rao.setCurrentLife(raoLife);
		hex.getAbilityByName("Hextor's Mantle").play(hex, targets);
		assertTrue(rao.isDead());
		assertFalse(hex.isDead());
		targets.clear();
		nerull.setCurrentLife(50000);
		targets.add(nerull);
		hex.getAbilityByName("Hextor's Mantle").play(hex, targets);
		assertTrue(hex.isDead());
		nerull.processAbilityEffects();
	}

	@Test
	public void testRao()
	{
		// Reason
		targets.add(hex);
		rao.getAbilityByName("Reason").play(rao, targets);
		targets.remove(hex);
		targets.add(rao);
		int raoLife = rao.getCurrentLife();
		for(int i = 0; i < 30; i++)
		{
			hex.attack(rao);
			hex.setAttackedThisRound(false);
			assertEquals("attack on rao should not be successful", raoLife, rao.getCurrentLife());
		}
		hex.processAbilityEffects();
		hex.setCurrentHitChance(5000);
		for(int i = 0; i < 30; i++)
		{
			hex.attack(rao);
			hex.setAttackedThisRound(false);
			if(raoLife > rao.getCurrentLife())
			{
				break;
			}
		}
		assertTrue("attack should be ok now", raoLife > rao.getCurrentLife());
		// Rao's Blessing
		targets.remove(rao);
		targets.add(hex);
		int hexDefense = hex.getCurrentDefense();
		rao.getAbilityByName("Rao's Blessing").play(rao, targets);
		assertEquals(hexDefense + 5, hex.getCurrentDefense());
		hex.processAbilityEffects();
		assertEquals(hexDefense, hex.getCurrentDefense());
		// Edoira's Wisdom
		int hexPower = hex.getCurrentPower();
		int hexAccuracy = hex.getAccuracyMod();
		rao.getAbilityByName("Edoira's Wisdom").play(rao, targets);
		assertEquals(hexPower + 5, hex.getCurrentPower());
		assertEquals(hexAccuracy + 5, hex.getAccuracyMod());
		hex.processAbilityEffects();
		assertEquals(hexPower, hex.getCurrentPower());
		assertEquals(hexAccuracy, hex.getAccuracyMod());
		// Swordless Scabbard
		hex.setCurrentLife(5000);
		int hexLife = hex.getCurrentLife();
		raoLife = rao.getCurrentLife();
		rao.getAbilityByName("Swordless Scabbard").play(rao, targets);
		assertEquals(hexLife - (int) (150 * 0.75), hex.getCurrentLife());
		assertEquals(raoLife + (int) (150 * 0.75), rao.getCurrentLife());
		hex.processAbilityEffects();
		// Crook of Rao
		hex.setAttackedThisRound(false);
		obad.setAttackedThisRound(false);
		targets.add(obad);
		rao.getAbilityByName("Crook Of Rao").play(rao, targets);
		for (Combatant c : targets)
		{
			assertFalse(c.hasAttackedThisRound());
			c.processAbilityEffects();
			assertTrue(c.hasAttackedThisRound());
		}
	}

	@Test
	public void testObadHai()
	{
		// Ensnare
		targets.add(obad);
		hex.setCurrentLife(5000);
		obad.getAbilityByName("Ensnare").play(obad, targets);
		int obadLife = obad.getCurrentLife();
		hex.attack(obad);
		assertEquals(obadLife, obad.getCurrentLife());
		assertTrue(hex.isStunned());
		assertEquals(0, obad.getCurrentTraps().size());
		obad.processAbilityEffects();
		hex.setStunned(false); // will have to do this in the game logic for the play loop
		// Shape Shift
		obad.setLevel(5); // giant rat
		targets.remove(obad);
		targets.add(hex);
		int hexLife = hex.getCurrentLife();
		obad.getAbilityByName("Shape Shift").play(obad, targets);
		assertTrue(hexLife > hex.getCurrentLife());
		hex.processAbilityEffects();
		hexLife = hex.getCurrentLife();
		obad.setLevel(8); // giant spider
		obad.getAbilityByName("Shape Shift").play(obad, targets);
		assertTrue(hexLife > hex.getCurrentLife());
		hex.processAbilityEffects();
		assertEquals(1, hex.getCurrentEffects().size());
		hex.executeEffects();
		hex.executeEffects();
		hexLife = hex.getCurrentLife();
		obad.setLevel(11); // panther
		obad.getAbilityByName("Shape Shift").play(obad, targets);
		assertTrue(hexLife > hex.getCurrentLife());
		hex.processAbilityEffects();
		assertEquals(1, hex.getCurrentEffects().size());
		hex.executeEffects();
		hexLife = hex.getCurrentLife();
		obad.setLevel(15); // bear
		obad.getAbilityByName("Shape Shift").play(obad, targets);
		assertTrue(hexLife > hex.getCurrentLife());
		hex.processAbilityEffects();
		assertEquals(1, hex.getCurrentEffects().size());
		hex.executeEffects();
		hex.executeEffects();
		// Shalm Song
		obad.getAbilityByName("Shalm Song").play(obad, targets);
		assertTrue(hex.isStunned());
		hex.processAbilityEffects();
		hex.setStunned(false);
	}

	@Test
	public void testNerull()
	{
		obad.setCurrentLife(5000);
		targets.add(obad);
		// Poison
		nerull.getAbilityByName("Poison").play(nerull, targets);
		assertEquals(1, obad.getCurrentEffects().size());
		obad.executeEffects();
		obad.executeEffects();
		obad.executeEffects();
		obad.processAbilityEffects();
		// Soul Spider
		int obadStam = obad.getCurrentStamina();
		int nerullStam = nerull.getCurrentStamina();
		nerull.getAbilityByName("Soul Spider").play(nerull, targets);
		assertTrue(obadStam > obad.getCurrentStamina());
		assertTrue(nerullStam < nerull.getCurrentStamina());
		assertEquals(obadStam - obad.getCurrentStamina(), nerull.getCurrentStamina() - nerullStam);
		// Miasma
		targets.add(hex);
		targets.add(rao);
		hex.setCurrentLife(5000);
		rao.setCurrentLife(5000);
		nerull.getAbilityByName("Miasma").play(nerull, targets);
		assertEquals(1, obad.getCurrentEffects().size());
		assertEquals(1, rao.getCurrentEffects().size());
		assertEquals(1, hex.getCurrentEffects().size());
		for (int i = 0; i < 3; i++)
		{
			obad.executeEffects();
			hex.executeEffects();
			rao.executeEffects();
		}
		obad.processAbilityEffects();
		hex.processAbilityEffects();
		rao.processAbilityEffects();
		targets.remove(rao);
		// Blood Spider
		int obadLife = obad.getCurrentLife();
		int hexLife = hex.getCurrentLife();
		int nerullLife = nerull.getCurrentLife();
		nerull.getAbilityByName("Blood Spider").play(nerull, targets);
		assertTrue(obadLife > obad.getCurrentLife());
		assertTrue(hexLife > hex.getCurrentLife());
		assertTrue(nerullLife < nerull.getCurrentLife());
		obad.processAbilityEffects();
		hex.processAbilityEffects();
		// Call of the Grave
		targets.remove(obad);
		hex.setConstitution(400);
		hex.setStrength(400);
		hex.setAgility(400);
		int hexCon = 400;
		int hexStr = hex.getStrength();
		int hexAgi = hex.getAgility();
		nerull.setCurrentStamina(5000);
		nerull.getAbilityByName("Call Of The Grave").play(nerull, targets);
		assertEquals(Math.max(0, hexCon - 200), hex.getConstitution());
		assertEquals(Math.max(0, hexStr - 200), hex.getStrength());
		assertEquals(Math.max(0, hexAgi - 200), hex.getAgility());
		assertFalse(hex.isDead());
		hex.processAbilityEffects();
		assertEquals(hexCon, hex.getConstitution());
		assertEquals(hexStr, hex.getStrength());
		assertEquals(hexAgi, hex.getAgility());
		hex.setConstitution(50);
		nerull.getAbilityByName("Call Of The Grave").play(nerull, targets);
		assertTrue(hex.isDead());
		assertEquals(nerull.getMaxLife(), nerull.getCurrentLife());
		hex.processAbilityEffects();
	}
}
