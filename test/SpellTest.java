package com.thenewjonathan.test;

import com.thenewjonathan.enums.*;
import com.thenewjonathan.heros.classes.*;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.spells.customspells.Charm;
import com.thenewjonathan.objects.cards.superclasses.AugmentationSpell;
import com.thenewjonathan.objects.cards.superclasses.CustomSpell;
import com.thenewjonathan.objects.cards.superclasses.SummonSpell;
import com.thenewjonathan.objects.usables.Card;
import com.thenewjonathan.objects.usables.Effect;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpellTest
{
	Combatant c1, c2, c3, c4, c5, c6;
	ArrayList<Combatant> targets;

	@Before
	public void initialize()
	{
		c1 = new WhiteWizard("Gandalf", Genders.MALE, 15, 50, 50, 150, 50, 150, 50, 200, 50, null, 13000, null, null);
		c1.addWeaponProficiencyTypes(WeaponTypes.STAFF);
		c2 = new BlackWizard("Saroun", Genders.MALE, 5, 50, 50, 150, 50, 150, 50, 200, 50, null, 13000, null, null);
		c2.addWeaponProficiencyTypes(WeaponTypes.STAFF);
		c3 = new Monk("Sevarious", Genders.MALE, 13, 200, 200, 100, 200, 150, 150, 100, 150, null, 13000, null, null);
		c3.addWeaponProficiencyTypes(WeaponTypes.STAFF);
		c4 = new ElementalBlade("Ang", Genders.MALE, 12, 150, 100, 200, 200, 100, 100, 250, 200, null, 12000, null,
				null);
		c4.addWeaponProficiencyTypes(WeaponTypes.HEAVYBLADE);
		c4.addWeaponProficiencyTypes(WeaponTypes.MACE);
		c5 = new ShadowDancer("Shadow", Genders.MALE, 12, 150, 100, 200, 200, 100, 100, 250, 200, null, 12000, null,
				null);
		c5.addWeaponProficiencyTypes(WeaponTypes.HEAVYBLADE);
		c5.addWeaponProficiencyTypes(WeaponTypes.LIGHTBLADE);
		c6 = new HextorFollower("Grethor", Genders.MALE, 12, 150, 100, 200, 200, 100, 100, 250, 200, null, 12000, null,
				null);
		c6.addWeaponProficiencyTypes(WeaponTypes.HEAVYBLADE);
		c6.addWeaponProficiencyTypes(WeaponTypes.CROSSBOW);
		targets = new ArrayList<Combatant>();
	}

	@Test
	public void testAttackSpellsAndEffects()
	{
		int testLife = c2.getCurrentLife();
		targets.add(c2);
		Spells.shock.getSpell().play(c1, targets);
		System.out.println("life was " + testLife + " and is now " + c2.getCurrentLife());
		assertTrue("5d6 life should be gone", testLife > c2.getCurrentLife());
		Spells.fireSword.getSpell().play(c1, targets);
		assertEquals("we should have burning in the effects now", 1, c2.getCurrentEffects().size());
		// defender in the way now
		System.out.println(c2.addDefender(Defenders.magicWall.getDefender()));
		testLife = c2.getCurrentLife();
		Spells.burn.getSpell().play(c1, targets);
		System.out.println("The wall is now down to " + targets.get(0).getCurrentDefender().getLife() + " life.");
		assertEquals("no damage should have been taken due to defender", testLife, c2.getCurrentLife());
		assertTrue("but wall should have taken damage", targets.get(0).getCurrentDefender().getLife() < 20);
		targets.get(0).getCurrentDefender().setLife(1);
		Spells.coldBurst.getSpell().play(c1, targets);
		assertEquals("wall should be dead", 0, targets.get(0).getCurrentDefenders().size());
		// no more defender
		assertEquals("gandalf should have 4 cards in discard pile", 4, c1.getCardsInDiscard().size());
		assertEquals("saroun should have 4 cards in play pile", 4, c2.getCardsInPlay().size());
		c2.gainLife(500);
		int c2Life = c2.getCurrentLife();
		c2.executeEffects();
		assertEquals("c2 took 15 damage", c2Life - 15, c2.getCurrentLife());
		assertEquals("effect damage down to 15", 15, c2.getCurrentEffects().get(0).getStartingPoint());
		assertEquals("effect duration down to 3", 3, c2.getCurrentEffects().get(0).getDuration());
		int ctr = 0;
		while (c2.getCurrentEffects().size() > 0 && ctr < 20)
		{
			c2.executeEffects();
			ctr++;
		}
		assertEquals("effect should have fallen off", 0, c2.getCurrentEffects().size());
		targets.add(c3);
		targets.add(c4);
		int c4Life = c4.getCurrentLife();
		Spells.fireball.getSpell().play(c1, targets);
		assertEquals("too many targets, no damage should have been taken by c4", c4Life, c4.getCurrentLife());
		targets.remove(c3);
		targets.remove(c4);
		c2Life = c2.getCurrentLife();
		Spells.magicSword.getSpell().play(c1, targets);
		System.out.println(c2Life + " : " + c2.getCurrentLife() + " : " + targets.get(0).getName());
		assertTrue("should have been significant damage on that spell", c2.getCurrentLife() <= (c2Life - 30));
		Spells.spiritHammer.getSpell().play(c1, targets);
		targets.add(c2);
		int c1Life = c1.getCurrentLife();
		c2Life = c2.getCurrentLife();
		Spells.poison.getSpell().play(c1, targets);
		assertTrue("one of the two targets took damage", c1Life > c1.getCurrentLife() || c2Life > c2.getCurrentLife());
	}

	@Test
	public void maxTargetAndRemoveCardTest()
	{
		// test all spells for too many targets
		c6.gainLife(25000);
		int c2Str = c2.getStrength();
		int c2Agi = c2.getAgility();
		int c2Wis = c2.getWisdom();
		int c2Acc = c2.getAccuracy();
		int c2Con = c2.getConstitution();
		int c6Life = c6.getCurrentLife();
		targets.clear();
		targets.add(c2);
		targets.add(c3);
		targets.add(c4);
		targets.add(c5);
		targets.add(c6);
		Spells.fireStorm.getSpell().play(c1, targets);
		assertEquals("c6 will be removed from targets", c6Life, c6.getCurrentLife());
	}

	@Test
	public void customSpellRemoveTest()
	{
		targets.add(c2);
		c2.gainLife(25000);
		int c2Str = c2.getStrength();
		int c2Agi = c2.getAgility();
		int c2Wis = c2.getWisdom();
		int c2Acc = c2.getAccuracy();
		int c2Con = c2.getConstitution();
		for (Spells s : Spells.values())
		{
			if (s.getSpell() instanceof CustomSpell)
			{
				s.getSpell().play(c1, targets);
				s.getSpell().remove(c2);
			}
		}
		assertEquals("str same as start", c2Str, c2.getStrength());
		assertEquals("agi same as start", c2Agi, c2.getAgility());
		assertEquals("wis same as start", c2Wis, c2.getWisdom());
		assertEquals("acc same as start", c2Acc, c2.getAccuracy());
		assertEquals("con same as start", c2Con, c2.getConstitution());
	}

	@Test
	public void augmentationSpellTest()
	{
		AugmentationSpell aSpell = new AugmentationSpell("test spell", 1, 0, 1, true, true, 5, 5, 5, 5, 5, 5, 5, 5);
		int life = c1.getCurrentLife();
		int str = c1.getStrength();
		int agi = c1.getAgility();
		int intl = c1.getIntelligence();
		int acc = c1.getAccuracy();
		int con = c1.getConstitution();
		int will = c1.getWill();
		int wprof = c1.getWeaponProficiency();
		targets.add(c1);

		aSpell.play(c2, targets);

		assertEquals(life + 5, c1.getCurrentLife());
		assertEquals(str + 5, c1.getStrength());
		assertEquals(agi + 5, c1.getAgility());
		assertEquals(intl + 5, c1.getIntelligence());
		assertEquals(acc + 5, c1.getAccuracy());
		assertEquals(con + 5, c1.getConstitution());
		assertEquals(will + 5, c1.getWill());
		assertEquals(wprof + 5, c1.getWeaponProficiency());

		c1.getCardsInPlay().get(0).remove(c1);

		assertEquals(life + 5, c1.getCurrentLife()); // life shouldn't come off
		assertEquals(str, c1.getStrength());
		assertEquals(agi, c1.getAgility());
		assertEquals(intl, c1.getIntelligence());
		assertEquals(acc, c1.getAccuracy());
		assertEquals(con, c1.getConstitution());
		assertEquals(will, c1.getWill());
		assertEquals(wprof, c1.getWeaponProficiency());
	}

	@Test
	public void testSummonSpell()
	{
		SummonSpell ss = new SummonSpell("Test Spell", 1, 0, 1, true, true, Defenders.magicWall.getDefender());
		targets.add(c2);
		ss.play(c1, targets);
		assertTrue(c2.isHasDefender());
		ss.remove(c2);
		assertTrue(c2.isHasDefender());
	}

	@Test
	public void testBattlements()
	{
		targets.clear();
		targets.add(c3);
		targets.add(c4);
		c3.getCurrentDefenders().clear();
		c4.getCurrentDefenders().clear();
		Spells.battlements.getSpell().play(c1, targets);
		assertEquals(1, c3.getCurrentDefenders().size());
		assertEquals(1, c4.getCurrentDefenders().size());
	}

	@Test
	public void testCharm()
	{
		// charm
		Charm charm = (Charm) Spells.charm.getSpell();
		c1.getCardsInHand().add(charm);
		charm.setTarget(c2);
		int c2Life = c2.getCurrentLife();
		targets.add(c3);
		charm:
		for (int i = 0; i < 500; i++)
		{
			if (i > 0)
			{
				c1.getCardsInHand().add(charm);
			}
			c1.getCardsInHand().get(0).play(c1, targets);
			if (c3.hasAttackedThisRound())
			{
				break charm;
			}
		}
		assertTrue("c3 should have attacked c2", c3.hasAttackedThisRound());
	}

	@Test
	public void testColdBlast()
	{
		// cold blast
		targets.add(c3);
		int c3Life = c3.getCurrentLife();
		int c3Agi = c3.getAgility();
		Spells.coldBlast.getSpell().play(c1, targets);
		assertTrue("Minimum of 20 damage to agility", c3Agi >= c3.getAgility() + 20);
		assertTrue("Cold damage delivered to c3", c3Life > c3.getCurrentLife());
		c3Life = c3.getCurrentLife();
		c3.addDefender(Defenders.magicWall.getDefender());
		Spells.coldBlast.getSpell().play(c1, targets);
		assertTrue("cold blast should have hit the wall", c3Life == c3.getCurrentLife());
		if (c3.isHasDefender())
		{
			c3.removeDefender();
		}
	}

	@Test
	public void testDarkCall()
	{
		// dark call
		targets.add(c3);
		for (int i = 0; i < 500; i++)
		{
			Spells.darkCall.getSpell().play(c1, targets);
			if (c3.isDead())
			{
				break;
			}
		}
		assertTrue("after 500 times, dark call should have worked at least once", c3.isDead());
		c3.gainLife(10);
		c3.addDefender(Defenders.magicWall.getDefender());
		c3.getCurrentDefender().setLife(4350);
		Spells.darkCall.getSpell().play(c1, targets);
		assertTrue("c3 has defender so spell will be blocked and wall life too high for spell to kill it",
				!c3.isDead());
		darkCall2:
		for (int i = 0; i < 50; i++)
		{
			c3.getCurrentDefender().setLife(1);
			Spells.darkCall.getSpell().play(c1, targets);
			if (!c3.isHasDefender())
			{
				break darkCall2;
			}
		}
		assertTrue("c3 has defender with life low so it should be removed", !c3.isHasDefender());
		c3.gainLife(4250);
		Spells.darkCall.getSpell().play(c1, targets);
		assertTrue("c3's life high enough that dark call can not possibly work", !c3.isDead());
	}

	@Test
	public void testDiffuse()
	{
		// diffuse
		targets.add(c3);
		Spells.burn.getSpell().play(c2, targets);
		assertEquals("c3 should be burning", 1, c3.getCurrentEffects().size());
		Spells.diffuse.getSpell().play(c1, targets);
		assertEquals("burning should be gone", 0, c3.getCurrentEffects().size());
	}

	@Test
	public void testFireStorm()
	{
		// fire storm
		targets.add(c2);
		targets.add(c3);
		targets.add(c4);
		int c2Str = c2.getStrength(), c3Str = c3.getStrength(), c4Str = c4.getStrength();
		Spells.fireStorm.getSpell().play(c1, targets);
		assertEquals("c2 str should be 150 less", c2Str - 150, c2.getStrength());
		assertEquals("c3 str should be 150 less", c3Str - 150, c3.getStrength());
		assertEquals("c4 str should be 150 less", c4Str - 150, c4.getStrength());
		for (Combatant c : targets)
		{
			Spells.fireStorm.getSpell().remove(c);
		}
		assertEquals("c2 str should be 150 less", c2Str, c2.getStrength());
		assertEquals("c3 str should be 150 less", c3Str, c3.getStrength());
		assertEquals("c4 str should be 150 less", c4Str, c4.getStrength());
	}

	@Test
	public void testGargoyle()
	{
		// gargoyle
		targets.add(c2);
		Spells.gargoyle.getSpell().play(c1, targets);
		assertTrue("c2 is petrified", c2.isPetrified());
		int c2Life = c2.getCurrentLife();
		c1.attack(c2);
		assertTrue("c2 is petrified, no damage should get through", c2Life == c2.getCurrentLife());
	}

	@Test
	public void testGreaterBlindness()
	{
		// greater blindness
		targets.add(c2);
		int c2Acc = c2.getAccuracy(), c2Agi = c2.getAgility();
		for (int i = 0; i < 300; i++)
		{
			Spells.greaterBlindness.getSpell().play(c1, targets);
			if (c2Acc > c2.getAccuracy())
			{
				break;
			}
		}
		assertEquals("Accuracy down by half", c2Acc - (c2Acc / 2), c2.getAccuracy());
		assertEquals("Agility down by half", c2Agi - (c2Agi / 2), c2.getAgility());
		Spells.greaterBlindness.getSpell().remove(c2);
		assertTrue("Accuracy back", c2Acc == c2.getAccuracy());
		assertTrue("Agility back", c2Agi == c2.getAgility());
		c2.addDefender(Defenders.magicWall.getDefender());
		Spells.greaterBlindness.getSpell().play(c1, targets);
		assertTrue("defender should block spell", c2Agi == c2.getAgility());
		c2.removeDefender();
	}

	@Test
	public void testGreaterDiffuse()
	{
		// greater diffuse
		c2.getCurrentEffects().add(new Effect(c1, 10, 2, EffectTypes.POISON));
		assertTrue("add effect worked", c2.getCurrentEffects().size() > 0);
		targets.add(c2);
		Spells.greaterDiffuse.getSpell().play(c1, targets);
		assertTrue("took effect away", c2.getCurrentEffects().size() == 0);
	}

	@Test
	public void testGreaterEnfeeblement()
	{
		// greater enfeeblement
		int c2Str = c2.getStrength();
		int c2Agi = c2.getAgility();
		targets.add(c2);
		for (int i = 0; i < 200; i++)
		{
			Spells.greaterEnfeeblement.getSpell().play(c1, targets);
			if (c2.getAgility() < c2Agi)
			{
				break;
			}
		}
		c2.setPetrified(false);
		c2.gainLife(2000);
		assertEquals("str cut in half", c2Str - (c2Str / 2), c2.getStrength());
		assertEquals("agi cut in half", c2Agi - (c2Agi / 2), c2.getAgility());
		Spells.greaterEnfeeblement.getSpell().remove(c2);
		assertEquals("str back", c2Str, c2.getStrength());
		assertEquals("agi back", c2Agi, c2.getAgility());
		c2.addDefender(Defenders.magicWall.getDefender());
		Spells.greaterEnfeeblement.getSpell().play(c1, targets);
		assertEquals("defender blocked spell", c2Agi, c2.getAgility());
		c2.removeDefender();
	}

	@Test
	public void testHeatLance()
	{
		// heat lance
		int c2Str = c2.getStrength();
		targets.add(c2);
		Spells.heatLance.getSpell().play(c1, targets);
		assertTrue("str reduced by at least 20", c2Str - 20 >= c2.getStrength());
		Spells.heatLance.getSpell().remove(c2);
		assertEquals("str restored", c2Str, c2.getStrength());
		c2.addDefender(Defenders.magicWall.getDefender());
		int defenderLife = c2.getCurrentDefender().getLife();
		Spells.heatLance.getSpell().play(c1, targets);
		assertTrue("heatlance should hit defender",
				!c2.isHasDefender() || defenderLife > c2.getCurrentDefender().getLife());
		if (c2.isHasDefender())
		{
			c2.removeDefender();
		}
	}

	@Test
	public void testIceRain()
	{
		// ice rain
		targets.add(c2);
		int c2Agi = c2.getAgility();
		Spells.iceRain.getSpell().play(c1, targets);
		assertTrue("agi is down", c2Agi - 20 >= c2.getAgility());
		Spells.iceRain.getSpell().remove(c2);
		assertEquals("agi restored", c2Agi, c2.getAgility());
	}

	@Test
	public void testMetalStorm()
	{
		// metal storm
		assertEquals("no effects", 0, c2.getCurrentEffects().size());
		targets.add(c2);
		for (int i = 0; i < 200; i++)
		{
			Spells.metalStorm.getSpell().play(c1, targets);
			if (c2.getCurrentEffects().size() > 0)
			{
				break;
			}
		}
		assertTrue("c2 is bleeding", c2.getCurrentEffects().get(0).getType().equals(EffectTypes.BLEEDING));
		int c2Life = c2.getCurrentLife();
		c2.getCurrentEffects().get(0).execute(c2);
		assertEquals("c2 should have taken 10 damage", c2Life - 10, c2.getCurrentLife());
	}

	@Test
	public void testShatter()
	{
		// shatter
		c2.gainLife(3000);
		c2.setPetrified(true);
		c2.addDefender(Defenders.magicWall.getDefender());
		targets.add(c2);
		for (int i = 0; i < 200; i++)
		{
			if (i == 1)
			{
				c2.removeDefender();
			}
			Spells.shatter.getSpell().play(c1, targets);
			if (c2.isShattered())
			{
				break;
			}
			assertTrue("defender should have blocked spell", !c2.isShattered());
		}
		assertTrue("c2 should be shattered", c2.isShattered());
	}

	@Test
	public void testSleep()
	{
		// sleep
		targets.add(c2);
		c2.gainLife(3000);
		sleep:
		for (int i = 0; i < 200; i++)
		{
			Spells.sleep.getSpell().play(c1, targets);
			if (c2.isStunned())
			{
				break sleep;
			}
		}
		assertTrue("c2 should be stunned (asleep)", c2.isStunned());
		c2.setStunned(false);
	}

	@Test
	public void testSummonMinotaur()
	{
		// summon minotaur
		targets.add(c2);
		for (int i = 0; i < 200; i++)
		{
			Spells.summonMinotaur.getSpell().play(c1, targets);
			if (c2.isStunned())
			{
				break;
			}
		}
		assertTrue("c2 is stunned", c2.isStunned());
		c2.setStunned(false);
		c2.addDefender(Defenders.magicWall.getDefender());
		int c2Life = c2.getCurrentLife();
		for (int i = 0; i < 2; i++)
		{
			if (i == 0)
			{
				c2.getCurrentDefender().setLife(2500);
			}
			else
			{
				c2.getCurrentDefender().setLife(1);
			}
			Spells.summonMinotaur.getSpell().play(c1, targets);
		}
		assertEquals("defender should have taken damage", c2Life, c2.getCurrentLife());
		if (c2.isHasDefender())
		{
			c2.removeDefender();
		}
	}

	@Test
	public void testSummonSkeleton()
	{
		// summon skeleton
		targets.add(c2);
		int c2Wis = c2.getWisdom();
		Spells.summonSkeleton.getSpell().play(c1, targets);
		assertEquals("wisdom reduced by 750", c2Wis - 750, c2.getWisdom());
		int c2Life = c2.getCurrentLife();
		c2.addDefender(Defenders.magicWall.getDefender());
		Spells.summonSkeleton.getSpell().play(c1, targets);
		assertTrue("defender should have taken the damage for c2", c2Life == c2.getCurrentLife());
		if (c2.isHasDefender())
		{
			c2.removeDefender();
		}
	}

	@Test
	public void testUnsummon()
	{
		// unsummon
		c2.addDefender(Defenders.magicWall.getDefender());
		assertTrue("just making sure c2 has a defender in play", c2.isHasDefender());
		targets.add(c2);
		for (int i = 0; i < 100; i++)
		{
			Spells.unsummon.getSpell().play(c1, targets);
			if (!c2.isHasDefender())
			{
				break;
			}
		}
		assertTrue("should no longer have defender", !c2.isHasDefender());
	}

	@Test
	public void testWings()
	{
		// wings
		c2.addDefender(Defenders.magicWall.getDefender());
		int c2Life = c2.getCurrentLife();
		targets.remove(c2);
		targets.add(c3);
		Spells.wings.getSpell().play(c1, targets);
		for (int i = 0; i < 5; i++)
		{
			c3.attack(c2);
			c3.setAttackedThisRound(false);
		}
		assertTrue("c2 should have been hit regardless of the wall", c2Life > c2.getCurrentLife());
		while (c2.getCardsInPlay().size() > 0)
		{
			ICard c = c2.getCardsInPlay().get(0);
			System.out.println("removing " + ((Card) c).getName());
			c.remove(c2);
		}
	}
}
