package com.thenewjonathan.test.Abilities;

import com.thenewjonathan.enums.Defenders;
import com.thenewjonathan.enums.Weapons;
import com.thenewjonathan.heros.classes.*;
import com.thenewjonathan.heros.superclasses.Combatant;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AbilitySpeedTest
{
	Combatant punchingBag, drizt, dancer, rogue, fighter, gandalf;
	ArrayList<Combatant> targets = new ArrayList<Combatant>();

	@Before
	public void initialize()
	{
		punchingBag = new Fighter();
		punchingBag.setCurrentLife(5000);
		punchingBag.pickUpWeapon(Weapons.lightClub.getWeapon());
		drizt = new Ranger();
		drizt.setLevel(15);
		drizt.pickUpWeapon(Weapons.scimitar.getWeapon());
		drizt.pickUpWeapon(Weapons.scimitar.getWeapon());
		dancer = new ShadowDancer();
		dancer.setLevel(15);
		dancer.pickUpWeapon(Weapons.dagger.getWeapon());
		rogue = new Rogue();
		rogue.setLevel(15);
		rogue.pickUpWeapon(Weapons.bow.getWeapon());
		fighter = new Fighter();
		fighter.setLevel(15);
		fighter.pickUpWeapon(Weapons.longSword.getWeapon());
		gandalf = new WhiteWizard();
		gandalf.setCurrentLife(5000);
		gandalf.pickUpWeapon(Weapons.quarterstaff.getWeapon());
		targets.add(punchingBag);
	}

	@Test
	public void testRanger()
	{
		// Focused Strike
		targets.clear();
		targets.add(drizt);
		int driztAgi = 400;
		drizt.setAgility(driztAgi);
		int driztAcc = drizt.getAccuracy();
		drizt.getAbilityByName("Focused Strike").play(drizt, targets);
		assertEquals(driztAgi - 100, drizt.getAgility());
		assertEquals(driztAcc + 100, drizt.getAccuracy());
		drizt.processAbilityEffects();
		assertEquals(driztAgi, drizt.getAgility());
		assertEquals(driztAcc, drizt.getAccuracy());
		// Jump Attack
		targets.clear();
		targets.add(punchingBag);
		int pLife = punchingBag.getCurrentLife();
		punchingBag.addDefender(Defenders.magicWall.getDefender());
		drizt.getAbilityByName("Jump Attack").play(drizt, targets);
		assertTrue(pLife > punchingBag.getCurrentLife());
		// should test stun here but not sure how because of percentage
		punchingBag.processAbilityEffects();
		// Throwing Knife
		pLife = punchingBag.getCurrentLife();
		drizt.getAbilityByName("Throwing Knife").play(drizt, targets);
		assertTrue(pLife > punchingBag.getCurrentLife());
		// again, should test stun
		punchingBag.processAbilityEffects();
		// Tip of the Blade
		pLife = punchingBag.getCurrentLife();
		drizt.getAbilityByName("Tip of the Blade").play(drizt, targets);
		assertTrue(pLife > punchingBag.getCurrentLife());
		assertTrue(punchingBag.isStunned());
		punchingBag.processAbilityEffects();
		assertFalse(punchingBag.isStunned());
	}

	@Test
	public void testRogue()
	{
		// Disarm
		punchingBag.pickUpWeapon(Weapons.lightClub.getWeapon());
		assertTrue(punchingBag.hasWeapon());
		for (int i = 0; i < 50; i++)
		{
			rogue.getAbilityByName("Demilitarize").play(rogue, targets);
			if (!punchingBag.hasWeapon())
			{
				break;
			}
		}
		assertFalse(punchingBag.hasWeapon());
		punchingBag.processAbilityEffects();
		// Death by 1000 Cuts
		int pLife = punchingBag.getCurrentLife();
		rogue.getAbilityByName("Death by 1000 Cuts").play(rogue, targets);
		assertTrue(pLife > punchingBag.getCurrentLife());
		punchingBag.processAbilityEffects();
		// Slay
		assertFalse(punchingBag.isDead());
		for (int i = 0; i < 50; i++)
		{
			rogue.getAbilityByName("Slay").play(rogue, targets);
			if (punchingBag.isDead())
			{
				break;
			}
		}
		assertTrue(punchingBag.isDead());
	}

	@Test
	public void testShadowDancer()
	{
		int pLife = punchingBag.getCurrentLife();
		punchingBag.addDefender(Defenders.magicWall.getDefender());
		dancer.getAbilityByName("Acrobatic Strike").play(dancer, targets);
		assertTrue(pLife > punchingBag.getCurrentLife());
		punchingBag.processAbilityEffects();
		targets.clear();
		targets.add(gandalf);
		dancer.getAbilityByName("Garrote").play(dancer, targets);
		gandalf.processAbilityEffects();
		assertTrue(gandalf.hasAttackedThisRound());
	}

	@Test
	public void testFighter()
	{
		// Parry
		targets.clear();
		targets.add(fighter);
		fighter.getAbilityByName("Parry").play(fighter, targets);
		int fLife = fighter.getCurrentLife();
		rogue.setLevel(15);
		rogue.pickUpWeapon(Weapons.dagger.getWeapon());
		rogue.setAccuracy(5000);
		rogue.updateStats();
		rogue.attack(fighter);
		assertEquals(fLife, fighter.getCurrentLife());
		fighter.processAbilityEffects();
		fighter.setCurrentDefense(0);
		for (int i = 0; i < 30; i++)
		{
			rogue.setAttackedThisRound(false);
			rogue.attack(fighter);
			if(fLife > fighter.getCurrentLife())
			{
				break;
			}
		}
		assertTrue(fLife > fighter.getCurrentLife());
		/* Demilitarize is already tested */
		// Called Shot
		targets.clear();
		targets.add(rogue);
		int rLife = rogue.getCurrentLife();
		boolean hit = false;
		for (int i = 0; i < 20; i++)
		{
			fighter.getAbilityByName("Called Shot").play(fighter, targets);
			if (rLife > rogue.getCurrentLife())
			{
				hit = true;
				break;
			}
		}
		assertTrue(hit);
	}
}
