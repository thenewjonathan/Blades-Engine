package com.thenewjonathan.test;

import com.thenewjonathan.enums.ArmorTypes;
import com.thenewjonathan.enums.Genders;
import com.thenewjonathan.enums.WeaponTypes;
import com.thenewjonathan.enums.Weapons;
import com.thenewjonathan.heros.classes.*;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.objects.usables.Armor;
import com.thenewjonathan.objects.usables.MagicArmor;
import org.junit.*;

import static org.junit.Assert.*;

public class ArmorTest
{
	Combatant gandalf, saroun, sevarious, ang, shadow, grethor;
	Armor fakeArmor, headGear, fakeShield, gloves, robe;


	@Before
	public void initialize()
	{
		gandalf =
				new RedWizard("Gandalf", Genders.MALE, 15, 50, 50, 150, 500, 150, 50, 200, 50, null, 13000, null, null);
		gandalf.addWeaponProficiencyTypes(WeaponTypes.STAFF);
		gandalf.pickUpWeapon(Weapons.quarterstaff.getWeapon());
		saroun =
				new BlackWizard("Saroun", Genders.MALE, 5, 50, 50, 150, 500, 150, 50, 200, 50, null, 13000, null, null);
		saroun.addWeaponProficiencyTypes(WeaponTypes.STAFF);
		saroun.pickUpWeapon(Weapons.quarterstaff.getWeapon());
		sevarious = new Monk("Sevarious", Genders.MALE, 13, 200, 200, 100, 500, 150, 150, 100, 150, null, 13000, null,
				null);
		sevarious.addWeaponProficiencyTypes(WeaponTypes.UNARMEDAUGMENT);
		sevarious.pickUpWeapon(Weapons.fistPack.getWeapon());
		ang = new ElementalBlade("Ang", Genders.MALE, 12, 150, 100, 200, 500, 100, 100, 250, 200, null, 12000, null,
				null);
		ang.addWeaponProficiencyTypes(WeaponTypes.HEAVYBLADE);
		ang.addWeaponProficiencyTypes(WeaponTypes.MACE);
		ang.pickUpWeapon(Weapons.mace.getWeapon());
		shadow = new ShadowDancer("Shadow", Genders.MALE, 12, 150, 100, 200, 500, 100, 100, 250, 200, null, 12000, null,
				null);
		shadow.addWeaponProficiencyTypes(WeaponTypes.HEAVYBLADE);
		shadow.addWeaponProficiencyTypes(WeaponTypes.LIGHTBLADE);
		shadow.pickUpWeapon(Weapons.dagger.getWeapon());
		grethor = new HextorFollower("Grethor", Genders.MALE, 12, 150, 100, 200, 500, 100, 100, 250, 200, null, 12000,
				null, null);
		grethor.addWeaponProficiencyTypes(WeaponTypes.AXE);
		grethor.addWeaponProficiencyTypes(WeaponTypes.CROSSBOW);
		grethor.pickUpWeapon(Weapons.battleAxe.getWeapon());
		fakeArmor =
				new MagicArmor("Fake Armor", "Tests all magic armor attributes", 1, ArmorTypes.LIGHT, 50000, 500, 50,
						50, 50, 50, 50, 50, 50, 50, 5, 5, 5, 5);
		headGear = new Armor("Head Gear", "Whatevs", 1, ArmorTypes.HELMET, 5, 10);
		fakeShield = new Armor("Fake Shield", "Whatevs", 1, ArmorTypes.SHIELD, 5, 10);
		gloves = new Armor("Gloves", "Whatevs", 1, ArmorTypes.GREAVE, 5, 10);
		robe = new Armor("Robe", "Whatevs", 1, ArmorTypes.WIZARD, 5, 10);
	}

	@Test
	public void testMagicArmor()
	{
		int angStr = ang.getStrength();
		int angAgi = ang.getAgility();
		int angInt = ang.getIntelligence();
		int angAcc = ang.getAccuracy();
		int angWis = ang.getWisdom();
		int angCon = ang.getConstitution();
		int angWil = ang.getWill();
		int angWepPro = ang.getWeaponProficiency();
		int angShockMod = ang.getShockDamageModifier();
		int angFireMod = ang.getFireDamageModifier();
		int angColdMod = ang.getColdDamageModifier();
		int angPoisonMod = ang.getPoisonDamageModifier();
		ang.putOnArmor(fakeArmor);
		assertTrue(ang.hasArmorOn());
		assertEquals("str", angStr + 50, ang.getStrength());
		assertEquals("agi", angAgi + 50, ang.getAgility());
		assertEquals("int", angInt + 50, ang.getIntelligence());
		assertEquals("acc", angAcc + 50, ang.getAccuracy());
		assertEquals("wis", angWis + 50, ang.getWisdom());
		assertEquals("con", angCon + 50, ang.getConstitution());
		assertEquals("wil", angWil + 50, ang.getWill());
		assertEquals("wepProf", angWepPro + 50, ang.getWeaponProficiency());
		assertEquals("shock mod", angShockMod + 5, ang.getShockDamageModifier());
		assertEquals("fire mod", angFireMod + 5, ang.getFireDamageModifier());
		assertEquals("cold mod", angColdMod + 5, ang.getColdDamageModifier());
		assertEquals("poison mod", angPoisonMod + 5, ang.getPoisonDamageModifier());
		ang.takeOffArmor(fakeArmor);
		assertEquals("str", angStr, ang.getStrength());
		assertEquals("agi", angAgi, ang.getAgility());
		assertEquals("int", angInt, ang.getIntelligence());
		assertEquals("acc", angAcc, ang.getAccuracy());
		assertEquals("wis", angWis, ang.getWisdom());
		assertEquals("con", angCon, ang.getConstitution());
		assertEquals("wil", angWil, ang.getWill());
		assertEquals("wepProf", angWepPro, ang.getWeaponProficiency());
		assertEquals("shock mod", angShockMod, ang.getShockDamageModifier());
		assertEquals("fire mod", angFireMod, ang.getFireDamageModifier());
		assertEquals("cold mod", angColdMod, ang.getColdDamageModifier());
		assertEquals("poison mod", angPoisonMod, ang.getPoisonDamageModifier());
		ang.putOnArmor(fakeShield);
		ang.putOnArmor(gloves);
		ang.putOnArmor(headGear);
		System.out.println(gandalf.putOnArmor(robe));
		assertTrue(ang.hasShieldOn());
		assertTrue(ang.hasGreavesOn());
		assertTrue(ang.hasHelmetOn());
		assertTrue(gandalf.hasWizardOn());
	}

}
