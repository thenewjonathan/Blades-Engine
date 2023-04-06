package com.thenewjonathan.test.Abilities;

import com.thenewjonathan.enums.EffectTypes;
import com.thenewjonathan.enums.Weapons;
import com.thenewjonathan.heros.classes.*;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.objects.usables.Effect;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AbilityPowerTest
{
	Combatant gandalf, wulfgar, drizt, louis, ang, bruce;
	ArrayList<Combatant> targets = new ArrayList<Combatant>();

	@Before
	public void initialize()
	{
		gandalf = new WhiteWizard();
		wulfgar = new Barbarian();
		drizt = new Ranger();
		louis = new Fighter();
		ang = new Monk();
		bruce = new ElementalBlade();
	}

	@Test
	public void testBarbarian()
	{
		wulfgar.setLevel(15);
		// War Cry
		targets.add(louis);
		targets.add(drizt);
		int louisStr = louis.getStrength();
		int driztStr = drizt.getStrength();
		wulfgar.getAbilityByName("War Cry").play(wulfgar, targets);
		assertTrue(louisStr < louis.getStrength());
		assertTrue(driztStr < drizt.getStrength());
		louis.processAbilityEffects();
		drizt.processAbilityEffects();
		assertEquals(louisStr, louis.getStrength());
		assertEquals(driztStr, drizt.getStrength());
		// Berserk
		targets.remove(louis);
		targets.remove(drizt);
		targets.add(wulfgar);
		int wulfgarAttackMod = wulfgar.getAttackMod();
		int wulfgarPower = wulfgar.getCurrentPower();
		wulfgar.getAbilityByName("Berserk").play(wulfgar, targets);
		assertEquals(wulfgarAttackMod+1, wulfgar.getAttackMod());
		assertEquals(wulfgarPower * 1.5, wulfgar.getCurrentPower(), 1);
		wulfgar.processAbilityEffects();
		assertEquals(wulfgarAttackMod , wulfgar.getAttackMod());
		assertEquals(wulfgarPower, wulfgar.getCurrentPower(), 1);
		// Blade Arc
		targets.clear();
		targets.add(drizt);
		targets.add(louis);
		drizt.setCurrentLife(500);
		louis.setCurrentLife(500);
		wulfgar.getAbilityByName("Blade Arc").play(wulfgar, targets);
		assertTrue(drizt.getCurrentLife() < 500);
		assertTrue(louis.getCurrentLife() < 500);
		louis.processAbilityEffects();
		drizt.processAbilityEffects();
	}

	@Test
	public void testMonk()
	{
		ang.setLevel(15);
		ang.setName("Ang");
		targets.add(louis);
		// Critical Strike
		int louisLife = louis.getCurrentLife();
		ang.getAbilityByName("Critical Strike").play(ang, targets);
		assertTrue(louisLife > louis.getCurrentLife());
		louis.processAbilityEffects();
		// Grace
		int louisAgi = louis.getAgility();
		ang.getAbilityByName("Grace").play(ang, targets);
		assertEquals(louisAgi, louis.getAgility());
		assertEquals(0, louis.getAbilityEffects().size());
		int angAgi = ang.getAgility();
		targets.remove(louis);
		targets.add(ang);
		ang.getAbilityByName("Grace").play(ang, targets);
		assertEquals(angAgi + 100, ang.getAgility());
		ang.processAbilityEffects();
		assertEquals(angAgi, ang.getAgility());
		// Cleansing
		ang.addEffect(new Effect(louis, 5, 1, EffectTypes.BURNING));
		ang.addEffect(new Effect(wulfgar, 10, 1, EffectTypes.COLD));
		int angLife = ang.getCurrentLife();
		ang.getAbilityByName("Cleansing").play(ang, targets);
		assertEquals(0, ang.getAbilityEffects().size());
		assertTrue(angLife < ang.getCurrentLife());
	}

	@Test
	public void testElementalBlade()
	{
		bruce.setLevel(15);
		targets.add(louis);
		// Flame Blade
		int louisLife = louis.getCurrentLife();
		bruce.getAbilityByName("Flame Blade").play(bruce, targets);
		assertEquals(0, louis.getAbilityEffects().size());
		assertTrue(louisLife == louis.getCurrentLife());
		bruce.pickUpWeapon(Weapons.scimitar.getWeapon());
		bruce.getAbilityByName("Flame Blade").play(bruce, targets);
		assertEquals(1, louis.getAbilityEffects().size());
		assertTrue(louisLife > louis.getCurrentLife());
		louis.processAbilityEffects();
		louis.executeEffects();
		louis.executeEffects();
		// Frost Blade
		louisLife = louis.getCurrentLife();
		int louisAgi = louis.getAgility();
		bruce.getAbilityByName("Frost Blade").play(bruce, targets);
		assertTrue(louisLife > louis.getCurrentLife());
		assertTrue(louisAgi > louis.getAgility());
		assertEquals(1, louis.getCurrentEffects().size());
		louis.processAbilityEffects();
		assertEquals(louisAgi, louis.getAgility());
		louis.executeEffects();
		// Lightning Blade
		louis.setCurrentLife(5000);
		louisLife = 5000;
		bruce.getAbilityByName("Lightning Blade").play(bruce, targets);
		assertTrue(louisLife > louis.getCurrentLife());
		assertEquals(1, louis.getCurrentEffects().size());
		// should test stun somehow but it's only a 35% change for it, so not sure how to mock that.
		louis.processAbilityEffects();
		louis.executeEffects();
	}
}
