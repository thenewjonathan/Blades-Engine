package com.thenewjonathan.test.Abilities;

import com.thenewjonathan.enums.Defenders;
import com.thenewjonathan.enums.Genders;
import com.thenewjonathan.enums.WeaponTypes;
import com.thenewjonathan.enums.Weapons;
import com.thenewjonathan.heros.classes.*;
import com.thenewjonathan.heros.superclasses.Combatant;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class AbilityArcaneTest
{
	Combatant gandalf, saroun, sevarious, ang, shadow, grethor, healer, jacob;
	ArrayList<Combatant> targets;

	@Before
	public void initialize()
	{
		healer = new WhiteWizard("Healer", Genders.MALE, 10, 50, 50, 200, 50, 100, 50, 200, 100, null, 200, null, null);
		healer.addWeaponProficiencyTypes(WeaponTypes.STAFF);
		healer.pickUpWeapon(Weapons.quarterstaff.getWeapon());
		jacob = new BlueWizard("Jacob", Genders.MALE, 10, 50, 50, 200, 50, 100, 50, 200, 100, null, 200, null, null);
		jacob.addWeaponProficiencyTypes(WeaponTypes.STAFF);
		jacob.pickUpWeapon(Weapons.quarterstaff.getWeapon());
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
		targets = new ArrayList<Combatant>();
	}

	@Test
	public void testBlackWizard()
	{
		// Draining Touch
		targets.add(shadow);
		int shadowLife = shadow.getCurrentLife();
		int sarounLife = saroun.getCurrentLife();
		saroun.getAbilityByName("Draining Touch").play(saroun, targets);
		int lifeGained = saroun.getCurrentLife() - sarounLife;
		int lifeDrained = shadowLife - shadow.getCurrentLife();
		assertEquals("life gained should equals life drained", lifeGained, lifeDrained);
		assertEquals(1, shadow.getAbilityEffects().size());
		shadow.processAbilityEffects();
		assertEquals(0, shadow.getAbilityEffects().size());
		// Enfeeblement
		int shadowPow = shadow.getCurrentPower();
		int shadowDef = shadow.getCurrentDefense();
		saroun.getAbilityByName("Enfeeblement").play(saroun, targets);
		assertEquals("power down by saroun's level", shadowPow - saroun.getLevel(), shadow.getCurrentPower());
		assertEquals("defense down by saroun's level", shadowDef - saroun.getLevel(), shadow.getCurrentDefense());
		shadow.processAbilityEffects();
		assertEquals("power back", shadowPow, shadow.getCurrentPower());
		assertEquals("defense back", shadowDef, shadow.getCurrentDefense());
	}

	@Test
	public void testWhiteWizard()
	{
		// Heal
		targets.add(saroun);
		int sarounLife = saroun.getCurrentLife();
		healer.getAbilityByName("Heal").play(healer, targets);
		assertTrue(sarounLife < saroun.getCurrentLife());
		sarounLife = saroun.getCurrentLife();
		assertEquals(1, saroun.getAbilityEffects().size());
		saroun.processAbilityEffects();
		assertEquals(sarounLife, saroun.getCurrentLife());
		assertEquals(0, saroun.getAbilityEffects().size());

		// Embolden
		int sarounPower = saroun.getCurrentPower();
		healer.getAbilityByName("Embolden").play(healer, targets);
		assertTrue(sarounPower < saroun.getCurrentPower());
		assertEquals(1, saroun.getAbilityEffects().size());
		saroun.processAbilityEffects();
		assertEquals(0, saroun.getAbilityEffects().size());
		assertEquals(sarounPower, saroun.getCurrentPower());
	}

	@Test
	public void testRedWizard()
	{
		targets.add(ang);
		// Hurt
		int angLife = ang.getCurrentLife();
		gandalf.getAbilityByName("Hurt").play(gandalf, targets);
		assertEquals(1, ang.getAbilityEffects().size());
		assertTrue(angLife > ang.getCurrentLife());
		ang.processAbilityEffects();
		assertEquals(0, ang.getAbilityEffects().size());
		// Heal tested in white wizard
	}

	@Test
	public void testBlueWizard()
	{
		sevarious.addDefender(Defenders.magicWall.getDefender());
		targets.add(sevarious);
		// Summon Mephit
		int sevariousLife = sevarious.getCurrentLife();
		int wallLife = sevarious.getCurrentDefender().getLife();
		jacob.getAbilityByName("Summon Mephit").play(jacob, targets);
		assertTrue(sevariousLife > sevarious.getCurrentLife());
		assertEquals(wallLife, sevarious.getCurrentDefender().getLife());
		assertEquals(1, sevarious.getAbilityEffects().size());
		sevarious.processAbilityEffects();
		assertEquals(0, sevarious.getAbilityEffects().size());
		sevariousLife = sevarious.getCurrentLife();
		// Summon Drake
		jacob.getAbilityByName("Summon Drake").play(jacob, targets);
		assertTrue(sevariousLife > sevarious.getCurrentLife());
		assertEquals(wallLife, sevarious.getCurrentDefender().getLife());
		assertEquals(1, sevarious.getAbilityEffects().size());
		assertEquals(1, sevarious.getCurrentEffects().size());
		assertTrue(sevarious.getCurrentEffects().get(0).getName().equalsIgnoreCase("Burning"));
		sevarious.processAbilityEffects();
		assertEquals(0, sevarious.getAbilityEffects().size());
	}
}
