package com.thenewjonathan.test;

import com.thenewjonathan.enums.Genders;
import com.thenewjonathan.enums.Spells;
import com.thenewjonathan.enums.WeaponTypes;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.objects.usables.Armor;
import com.thenewjonathan.objects.usables.Card;
import com.thenewjonathan.objects.usables.Weapon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CardTest
{
	Card testCard;
	Combatant dummy;
	Combatant dummy2;
	ArrayList<Combatant> targets;

	@Before
	public void initialize()
	{
		testCard = new Card("Test Card", 3, 10, 13, true, false);
		dummy = new Combatant("Dummy", Genders.MALE, 15, 100, 100, 100, 100, 100, 100, 100, 100,
				new ArrayList<WeaponTypes>(), 500, new ArrayList<Weapon>(), new ArrayList<Armor>());
		dummy2 = new Combatant("Dummy", Genders.MALE, 15, 100, 100, 100, 100, 100, 100, 100, 100,
				new ArrayList<WeaponTypes>(), 500, new ArrayList<Weapon>(), new ArrayList<Armor>());
		dummy.getCardsInDeck().add(Spells.coldBurst.getSpell());
		targets = new ArrayList<Combatant>();
		targets.add(dummy2);
	}

	@Test
	public void testPlay()
	{
		assertEquals("Check name", "Test Card", testCard.getName());
		assertEquals("Check life", 3, testCard.getCardLife());
		assertEquals("Check max life", 3, testCard.getMaxCardLife());
		assertEquals("Check cost", 10, testCard.getCost());
		assertEquals("Check ranged", 13, testCard.getLevelRequired());
		assertTrue("Check target others", testCard.isTargetOther());
		assertFalse("Check ranged", testCard.isRanged());
		dummy.drawCard();
		assertEquals("dummy should have one card in hand", 1, dummy.getCardsInHand().size());
		dummy.getCardsInHand().get(0).play(dummy, targets);
		assertEquals("dummy should have no cards in hand", 0, dummy.getCardsInHand().size());
		assertEquals("dummy should have one card in discard", 1, dummy.getCardsInDiscard().size());
		assertEquals("dummy2 should have one card in play", 1, dummy2.getCardsInPlay().size());
		dummy2.getCardsInPlay().get(0).remove(dummy2);
		assertEquals("dummy2 should have no cards in play", 0, dummy2.getCardsInPlay().size());
	}

}
