package com.thenewjonathan.test;

import com.thenewjonathan.enums.*;
import com.thenewjonathan.heros.classes.BlueWizard;
import com.thenewjonathan.heros.classes.Monk;
import com.thenewjonathan.heros.classes.RedWizard;
import com.thenewjonathan.heros.classes.WhiteWizard;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.objects.usables.Armor;
import com.thenewjonathan.objects.usables.Defender;
import com.thenewjonathan.objects.usables.MagicArmor;
import com.thenewjonathan.objects.usables.Weapon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CombatantTest
{
	// *****WARNING**********
	// if the stats are changed on the testCombatant object, all tests will break, do not change the object's stats!
	Combatant testCombatant = new Combatant("Dumb Combatant", Genders.MALE, 15, 100, 100, 10, 40, 50, 150, 50, 100,
			new ArrayList<WeaponTypes>(), 500, new ArrayList<Weapon>(), new ArrayList<Armor>());
	Combatant punchingBag = new Combatant("Punching Bag", Genders.MALE, 9, 100, 100, 50, 100, 50, 50, 50, 100,
			new ArrayList<WeaponTypes>(), 500, new ArrayList<Weapon>(), new ArrayList<Armor>());
	Combatant c1 =
			new WhiteWizard("Gandalf", Genders.MALE, 15, 50, 50, 150, 50, 150, 50, 200, 50, null, 13000, null, null);
	Combatant c2 =
			new BlueWizard("Saroun", Genders.MALE, 5, 50, 50, 150, 50, 150, 50, 200, 50, null, 13000, null, null);
	Combatant c3 =
			new WhiteWizard("Gandalf", Genders.MALE, 15, 50, 50, 150, 50, 150, 50, 200, 50, null, 13000, null, null);
	Weapon club = Weapons.lightClub.getWeapon();
	Armor leatherArmor = Armors.leatherArmor.getArmor();
	MagicArmor gloves =
			new MagicArmor("Gauntlets of I Don't Miss", "...", 1, ArmorTypes.GAUNTLET, 1, 20, 0, 0, 0, 2050, 0, 0, 0, 0,
					0, 0, 0, 0);
	Armor tankSkin = new Armor("Chain Armor", "+400 defense", 5, ArmorTypes.MEDIUM, 400, 30);
	Combatant gandalf, sevarious;

	@Before
	public void initialize()
	{
		testCombatant.gainLife(50000);
		punchingBag.gainLife(50000);
		c1.gainLife(50000);
		c2.gainLife(50000);
		c3.gainLife(50000);
		gandalf =
				new RedWizard("Gandalf", Genders.MALE, 15, 50, 50, 150, 500, 150, 50, 200, 50, null, 13000, null, null);
		gandalf.addWeaponProficiencyTypes(WeaponTypes.STAFF);
		gandalf.pickUpWeapon(Weapons.quarterstaff.getWeapon());
		sevarious = new Monk("Sevarious", Genders.MALE, 13, 200, 200, 100, 500, 150, 150, 100, 150, null, 13000, null,
				null);
		sevarious.addWeaponProficiencyTypes(WeaponTypes.UNARMEDAUGMENT);
	}

	@Test
	public void testClone()
	{
		Combatant clone = testCombatant.clone();
		assertEquals(clone, testCombatant);
	}

	@Test
	public void testEquals()
	{
		Combatant copy =
				new BlueWizard("Saroun", Genders.MALE, 5, 50, 50, 150, 50, 150, 50, 200, 50, null, 13000, null, null);
		Combatant copy2 =
				new BlueWizard("Whatever", Genders.MALE, 5, 50, 50, 150, 50, 150, 50, 200, 50, null, 13000, null, null);
		assertTrue(c2.equals(copy));
		assertFalse(c2.equals(gloves));
		assertFalse(c2.equals(copy2));

	}

	@Test
	public void testMonkAttack()
	{
		int gLife = gandalf.getCurrentLife();
		for (int i = 0; i < 20; i++)
		{
			gandalf.addDefender(Defenders.magicWall.getDefender());
			gandalf.getCurrentDefender().setLife(50000);
			sevarious.attack(gandalf); // to make sure we don't get an error when a monk attacks unarmed
			sevarious.setAttackedThisRound(false);
			if (gandalf.getCurrentLife() < gLife)
			{
				assertTrue("gandalf was for at least two damage", gLife - 2 > gandalf.getCurrentLife());
			}
			gLife = gandalf.getCurrentLife();
		}
	}

	@Test
	public void testEquipmentAndDamageManipulations()
	{
		testCombatant.getWeaponProficiencyTypes().add(WeaponTypes.CLUB);
		punchingBag.getWeaponProficiencyTypes().add(WeaponTypes.LIGHTBLADE);
		System.out.println("Using " + testCombatant);
		System.out
				.println("power:" + testCombatant.getCurrentPower() + "\ndefense:" + testCombatant.getCurrentDefense() +
						"\nhit chance:" + testCombatant.getCurrentHitChance() + "\nlife:" +
						testCombatant.getCurrentLife() + "\nstamina" +
						testCombatant.getCurrentStamina());
		// pick up weapon, put on armor and test damage
		System.out.println(testCombatant.pickUpWeapon(club));
		System.out.println(testCombatant.putOnArmor(leatherArmor));
		int tcLife = testCombatant.getCurrentLife();
		testCombatant.takeDamage(null, 50, 0, 0, 0, 0, 0, 0);
		System.out.println("\n");
		System.out
				.println("power:" + testCombatant.getCurrentPower() + "\ndefense:" + testCombatant.getCurrentDefense() +
						"\nhit chance:" + testCombatant.getCurrentHitChance() + "\nlife:" +
						testCombatant.getCurrentLife() + "\nstamina" +
						testCombatant.getCurrentStamina());
		assertEquals("life should be at tcLife-50", tcLife - 50, testCombatant.getCurrentLife());
		assertEquals("weapons is not at 1", 1, testCombatant.getWeaponsInPlay().size());
		assertEquals("armor should have modified the defense to 1", 1, testCombatant.getCurrentDefense());
		assertEquals("armor is not at 1", 1, testCombatant.getArmorInPlay().size());
		// drop weapon, take off armor and gain life
		System.out.println(testCombatant.dropWeapon(club));
		System.out.println(testCombatant.takeOffArmor(leatherArmor));
		tcLife = testCombatant.getCurrentLife();
		testCombatant.gainLife(150);
		System.out.println("\n");
		System.out
				.println("power:" + testCombatant.getCurrentPower() + "\ndefense:" + testCombatant.getCurrentDefense() +
						"\nhit chance:" + testCombatant.getCurrentHitChance() + "\nlife:" +
						testCombatant.getCurrentLife() + "\nstamina" +
						testCombatant.getCurrentStamina());
		assertEquals("life should be at tcLife + 150", tcLife + 150, testCombatant.getCurrentLife());
		assertEquals("weapons is not at 0", 0, testCombatant.getWeaponsInPlay().size());
		assertEquals("armor is not at 0", 0, testCombatant.getArmorInPlay().size());
		assertEquals("power should be at 1", 1, testCombatant.getCurrentPower());
		assertEquals("defense should be 0", 0, testCombatant.getCurrentDefense());
		assertEquals("hit chance should be -1", -1, testCombatant.getCurrentHitChance());
		assertEquals("stamina should be at 10", 10, testCombatant.getCurrentStamina());
		testCombatant.attack(punchingBag);
		testCombatant.setAttackedThisRound(false);
		testCombatant.setAccuracy(2050);
		// try to put on two suits of armor
		System.out.println(testCombatant.putOnArmor(leatherArmor));
		System.out.println(testCombatant.putOnArmor(leatherArmor));
		System.out.println(testCombatant.pickUpWeapon(Weapons.longSword.getWeapon()));
		System.out
				.println("power:" + testCombatant.getCurrentPower() + "\ndefense:" + testCombatant.getCurrentDefense() +
						"\nhit chance:" + testCombatant.getCurrentHitChance() + "\nlife:" +
						testCombatant.getCurrentLife() + "\nstamina" +
						testCombatant.getCurrentStamina());
		testCombatant.attack(punchingBag);
		testCombatant.setAttackedThisRound(false);
		assertEquals("only one suit of armor should be present", 1, testCombatant.getArmorInPlay().size());
		// try to pick up two weapons w/o dual wield
		System.out.println(testCombatant.pickUpWeapon(Weapons.dagger.getWeapon()));
		assertEquals("only one weapon should be present", 1, testCombatant.getWeaponsInPlay().size());
		// grant dual wield and try again
		testCombatant.setDualWield(true);
		System.out.println(testCombatant.pickUpWeapon(Weapons.dagger.getWeapon()));
		assertEquals("two weapons should be present", 2, testCombatant.getWeaponsInPlay().size());
		// put on magic armor
		testCombatant.putOnArmor(Armors.gauntletsOfTrueStriking.getArmor());
		testCombatant.attack(punchingBag);
		testCombatant.setAttackedThisRound(false);
		assertEquals("two pieces of armor on", 2, testCombatant.getArmorInPlay().size());
		// drop a weapon and pick up a magic weapon with effect
		testCombatant.putOnArmor(Armors.grievesOfSureFooting.getArmor());
		testCombatant.dropWeapon(Weapons.dagger.getWeapon());
		testCombatant.pickUpWeapon(Weapons.bogClub.getWeapon());
		System.out
				.println("power:" + testCombatant.getCurrentPower() + "\ndefense:" + testCombatant.getCurrentDefense() +
						"\nhit chance:" + testCombatant.getCurrentHitChance() + "\nlife:" +
						testCombatant.getCurrentLife() + "\nstamina" +
						testCombatant.getCurrentStamina());
		disease:
		for (int i = 0; i < 15; i++)
		{
			testCombatant.setAttackedThisRound(false);
			testCombatant.attack(punchingBag);
			testCombatant.setAttackedThisRound(false);
			if (punchingBag.hasEffects())
			{
				break disease;
			}
		}
		assertTrue("Punching bag should be diseased", punchingBag.hasEffects());
		// have punching bag try to put on armor that is too high level
		System.out.println(punchingBag.putOnArmor(Armors.grievesOfSureFooting.getArmor()));
		assertEquals("punching bag shouldn't have armor on", 0, punchingBag.getArmorInPlay().size());
		// punching bag to try and equip a weapon too powerful for him
		System.out.println(punchingBag.pickUpWeapon(Weapons.katar.getWeapon()));
		assertEquals("punching bag shouldn't have any weapons", 0, punchingBag.getWeaponsInPlay().size());
	}

	@Test
	public void testWizardsCantAttack()
	{
		c1.addWeaponProficiencyTypes(WeaponTypes.STAFF);
		c2.addWeaponProficiencyTypes(WeaponTypes.STAFF);
		c3.addWeaponProficiencyTypes(WeaponTypes.STAFF);
		ArrayList<Combatant> targets = new ArrayList<Combatant>();
		targets.add(testCombatant);
		int tcLife = testCombatant.getCurrentLife();
		c1.attack(testCombatant);
		c1.setAttackedThisRound(false);
		c2.attack(testCombatant);
		c2.setAttackedThisRound(false);
		c3.attack(testCombatant);
		c3.setAttackedThisRound(false);
		assertEquals("testCombatant should not have taken damage as wizards can't attack", tcLife,
				testCombatant.getCurrentLife());
	}

	@Test
	public void testBattleMechanics()
	{
		System.out.println(testCombatant.putOnArmor(gloves));
		System.out.println(punchingBag.putOnArmor(gloves));
		System.out
				.println("power:" + testCombatant.getCurrentPower() + "\ndefense:" + testCombatant.getCurrentDefense() +
						"\nhit chance:" + testCombatant.getCurrentHitChance() + "\nlife:" +
						testCombatant.getCurrentLife() + "\nstamina" +
						testCombatant.getCurrentStamina());
		// attacking with ranged, should not have counter attack
		System.out.println(punchingBag.pickUpWeapon(Weapons.broadsword.getWeapon()));
		System.out.println(testCombatant.pickUpWeapon(Weapons.bow.getWeapon()));
		int pbLife = punchingBag.getCurrentLife();
		int tcLife = testCombatant.getCurrentLife();
		attack:
		for (int i = 0; i < 20; i++)
		{
			testCombatant.attack(punchingBag);
			testCombatant.setAttackedThisRound(false);
			if (punchingBag.getCurrentLife() < 100)
			{
				break attack;
			}
		}
		assertTrue("punching bag got hit", punchingBag.getCurrentLife() < pbLife);
		assertEquals("test combatant shouldn't have been hurt", tcLife, testCombatant.getCurrentLife());
		System.out.println(testCombatant.dropWeapon(Weapons.bow.getWeapon()));
		System.out.println(testCombatant.pickUpWeapon(Weapons.bladedStaff.getWeapon()));
		// punching bag gets a defender
		System.out.println(punchingBag.addDefender(new Defender("Cletus", 3, 20, 1)));
		for (int i = 0; i < 5; i++)
		{
			testCombatant.attack(punchingBag);
			testCombatant.setAttackedThisRound(false);
		}
		assertEquals("defender should be dead and removed", 0, punchingBag.getCurrentDefenders().size());
		System.out.println(punchingBag.addDefender(new Defender("Cletus", 3, 20, 1)));
		testCombatant.dropWeapon(Weapons.bladedStaff.getWeapon());
		for (int i = 0; i < 50; i++)
		{
			testCombatant.attack(punchingBag);
			testCombatant.setAttackedThisRound(false);
		}
		assertEquals("defender should be dead and removed", 0, punchingBag.getCurrentDefenders().size());
		testCombatant.pickUpWeapon(Weapons.bladedStaff.getWeapon());
		// let's say punching bag gets a stone skin spell cast on him or something
		punchingBag.setCurrentDamageBuffer(20);
		int bagsLife = punchingBag.getCurrentLife();
		testCombatant.attack(punchingBag);
		testCombatant.setAttackedThisRound(false);
		assertEquals("punching bag shouldn't have taken any damage", bagsLife, punchingBag.getCurrentLife());
		// punching bag has defender, testCombatant ignores it
		punchingBag.setCurrentDamageBuffer(0);
		bagsLife = punchingBag.getCurrentLife();
		testCombatant.setIgnoreDefenders(true);
		System.out.println(punchingBag.getCurrentDefenders().add(new Defender("GI Joe", 10, 10, 30)));
		testCombatant.attack(punchingBag);
		testCombatant.setAttackedThisRound(false);
		assertTrue("punching bag should have been hit", bagsLife > punchingBag.getCurrentLife());
		// testing ignore armor
		testCombatant.setIgnoreArmor(true);
		System.out.println("test attack - " + testCombatant.getCurrentHitChance() + "\nbag's def - " +
				punchingBag.getCurrentDefense());
		System.out.println(punchingBag.putOnArmor(tankSkin));
		System.out.println("bag's def is now - " + punchingBag.getCurrentDefense());
		bagsLife = punchingBag.getCurrentLife();
		attackLoop:
		for (int i = 0; i < 50; i++)
		{
			testCombatant.attack(punchingBag);
			testCombatant.setAttackedThisRound(false);
			if (bagsLife > punchingBag.getCurrentLife())
			{
				break attackLoop;
			}
		}
		assertTrue("punching bag should have been hit regardless of the armor",
				bagsLife > punchingBag.getCurrentLife());
		punchingBag.getCurrentTraps().add(Traps.cantrip.getTrap());
		punchingBag.setCurrentHitChance(-20);
		int testLife = testCombatant.getCurrentLife();
		System.out.println("starting trap test");
		testCombatant.attack(punchingBag);
		testCombatant.setAttackedThisRound(false);
		assertEquals("bag's trap should be gone", 0, punchingBag.getCurrentTraps().size());
		assertEquals("trap should have done 5 damage to testCombatant", testLife - 5, testCombatant.getCurrentLife());
		punchingBag.getCurrentTraps().add(Traps.iceTrap.getTrap());
		punchingBag.getCurrentTraps().add(Traps.fireTrap.getTrap());
		punchingBag.getCurrentTraps().add(Traps.poisonTrap.getTrap());
		testCombatant.attack(punchingBag);
		testCombatant.setAttackedThisRound(false);
		assertEquals("bag's traps should be empty", 0, punchingBag.getCurrentTraps().size());
		testCombatant.setAttackedThisRound(true);
		testLife = punchingBag.getCurrentLife();
		testCombatant.attack(punchingBag);
		assertEquals(testLife, punchingBag.getCurrentLife());
	}

	@Test
	public void testReducedDamage()
	{
		int life = c2.getCurrentLife();
		c2.takeDamage(punchingBag, 0, 0, 40, 0, 0, 0, 0);
		assertEquals("Should take 30 of the 40 damage", life - 30, c2.getCurrentLife());
	}

	@Test
	public void testDeathAndResurrection()
	{
		System.out.println(testCombatant.putOnArmor(gloves));
		System.out.println(testCombatant.pickUpWeapon(Weapons.greatSword.getWeapon()));
		punchingBag.setCurrentLife(2);
		for (int i = 0; i < 5; i++)
		{
			testCombatant.attack(punchingBag);
			testCombatant.setAttackedThisRound(false);
		}
		assertTrue("punching bag is dead", punchingBag.isDead());
		punchingBag.gainLife(10);
		assertFalse("punching bag is back from the dead!", punchingBag.isDead());
	}
}
