package com.thenewjonathan.test;

import com.thenewjonathan.enums.*;
import com.thenewjonathan.heros.classes.Rogue;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.objects.admin.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PlayerTest
{
	Player p;

	@Before
	public void initialize()
	{
		p = new Player("Jon");
		Rogue drizt =
				new Rogue("Drizt", Genders.MALE, 15, 250, 300, 200, 350, 150, 200, 250, 300, null, 15000, null, null);
		drizt.getWeaponProficiencyTypes().add(WeaponTypes.LIGHTBLADE);
		drizt.setDualWield(true);
		drizt.addCardToLibrary(Actions.faceThrust.getAction());
		drizt.addCardToLibrary(Actions.faceThrust.getAction());
		drizt.addArmorToCache(Armors.leatherArmorOfOgreStrength.getArmor());
		drizt.addArmorToCache(Armors.grievesOfSureFooting.getArmor());
		drizt.addArmorToCache(Armors.gauntletsOfTrueStriking.getArmor());
		drizt.addWeaponToCache(Weapons.scimitar.getWeapon());
		drizt.addWeaponToCache(Weapons.scimitar.getWeapon());
		drizt.addWeaponToCache(Weapons.dagger.getWeapon());
		drizt.getLastDeckPlayed().add(Spells.burn.getSpell().toString());
		drizt.getLastDeckPlayed().add(Spells.coldBlast.getSpell().toString());
		drizt.getLastDeckPlayed().add(Spells.fireball.getSpell().toString());
		drizt.getLastDeckPlayed().add(Spells.greaterEnfeeblement.getSpell().toString());
		drizt.getLastDeckPlayed().add(Spells.heatLance.getSpell().toString());
		drizt.getLastDeckPlayed().add(Spells.shock.getSpell().toString());
		drizt.getLastDeckPlayed().add(Spells.metalStorm.getSpell().toString());
		drizt.getLastDeckPlayed().add(Spells.magicSword.getSpell().toString());
		p.addCombatant(drizt);
	}

	@Test
	public void testArchiveFunctions()
	{
		p.backUpCombatants();
		ArrayList<Combatant> testCombatantArray = p.getExistingCombatants();
		Combatant c = testCombatantArray.get(0);
		System.out.println(c + " was retrieved from the player object");
		assertEquals("make sure we got a combatant object back in the array", 1, testCombatantArray.size());
		assertEquals("make sure spells are there", 8, c.getLastDeckPlayed().size());
	}

	@Test
	public void testConstructors()
	{
		Player p2 = new Player("Jack", "1k5a9e2m6y", new ArrayList<Combatant>());
		assertNotEquals(p, p2);
		p2 = p.copy();
		assertEquals(p, p2);
	}
}
