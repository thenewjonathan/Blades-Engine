package com.thenewjonathan.enums;

import com.thenewjonathan.objects.spells.customspells.*;
import com.thenewjonathan.objects.cards.superclasses.AttackSpell;
import com.thenewjonathan.objects.cards.superclasses.AugmentationSpell;
import com.thenewjonathan.objects.cards.superclasses.SummonSpell;
import com.thenewjonathan.objects.usables.Card;
import com.thenewjonathan.objects.usables.Effect;

public enum Spells
{
	// ARCANE SPELLS
	// attack
	coldBurst(new AttackSpell("Cold Burst", 1, 1, 1, true, true, Dice.D4.getDie(), 0, 5, true, DamageTypes.ICE, null, 1,
			false, 0, false), null, "Ball of energy that does cold damage.", CardType.ATTACK),
	shock(new AttackSpell("Shock", 1, 1, 1, true, false, Dice.D6.getDie(), 0, 5, true, DamageTypes.SHOCK, null, 1,
			false, 0, false), null, "Lightning comes from the caster's fingertips.", CardType.ATTACK),
	burn(new AttackSpell("Burn", 1, 1, 1, true, false, Dice.D6.getDie(), 0, 3, true, DamageTypes.FIRE, null, 1, false,
			0, false), new Effect(10, 2, EffectTypes.BURNING),
			"Fire comes from the caster's fingertips. Inflicts burning(10,2).", CardType.ATTACK),
	poison(new AttackSpell("Poison", 1, 1, 1, true, false, Dice.D4.getDie(), 0, 3, true, DamageTypes.POISON, null, 1,
			false, 0, false), new Effect(10, 2, EffectTypes.POISON), "Shoot poison at enemy. Inflicts poison(10,2)",
			CardType.ATTACK),
	fireball(new AttackSpell("Fireball", 1, 5, 4, true, true, Dice.D6.getDie(), 0, 9, true, DamageTypes.FIRE, null, 2,
			false, 0, false), new Effect(10, 2, EffectTypes.BURNING),
			"Hurl a ball of fire that explodes on contact causing" + " AOE damage and burning(10,2).", CardType.ATTACK),
	magicSword(new AttackSpell("Magic Sword", 1, 10, 7, true, true, Dice.D8.getDie(), 0, 12, true, DamageTypes.PHYSICAL,
			null, 1, false, 0, false), null, "Summon a sword to strike an enemy one time.", CardType.ATTACK),
	fireSword(
			new AttackSpell("Fire Sword", 1, 15, 10, true, true, Dice.D8.getDie(), 0, 15, true, DamageTypes.FIRE, null,
					1, false, 0, false), new Effect(20, 4, EffectTypes.BURNING),
			"Summon a flaming sword to strike an enemy one " + "time. Causes burning(20,4).", CardType.ATTACK),
	spiritHammer(new AttackSpell("Spirit Hammer", 1, 15, 10, true, true, Dice.D8.getDie(), 10, 15, false,
			DamageTypes.PHYSICAL, null, 1, true, 100, false), null,
			"Summon a spectral hammer to strike an enemy one time.", CardType.ATTACK),
	summonArachnid(
			new AttackSpell("Summon Arachnid", 1, 1, 1, true, true, Dice.D4.getDie(), 0, 15, true, DamageTypes.POISON,
					null, 1, false, 0, true), new Effect(5, 3, EffectTypes.POISON),
			"Summon giant spider to bite enemy and cause " + "poison(5,3).", CardType.ATTACK),
	summonGiantBat(new AttackSpell("Summon Giant Bat", 1, 5, 4, true, true, Dice.D4.getDie(), 0, 15, true,
			DamageTypes.PHYSICAL, null, 1, false, 0, true), new Effect(10, 3, EffectTypes.BLEEDING),
			"Summon a giant " + "bat to attack an enemy one time. Causes bleeding(10,3).", CardType.ATTACK),
	summonFireElemental(new AttackSpell("Summon Fire Elemental", 1, 10, 7, true, true, Dice.D4.getDie(), 0, 15, true,
			DamageTypes.FIRE, null, 4, false, 0, true), new Effect(10, 2, EffectTypes.BURNING),
			"Summon a fire elemental " + "to rain fire on all enemies. Causes burning(10,2).", CardType.ATTACK),
	summonBasilisk(new AttackSpell("Summon Basilisk", 1, 10, 7, true, true, Dice.DD4.getDie(), 1, 15, false,
			DamageTypes.POISON, null, 1, true, 50, true), null, "Summon a basilisk to damage and stun an enemy.",
			CardType.ATTACK),
	summonStormElemental(new AttackSpell("Summon Storm Elemental", 1, 15, 13, true, true, Dice.D6.getDie(), 0, 15, true,
			DamageTypes.SHOCK, null, 4, true, 35, true), null, "Summon storm elemental to damage and stun all enemies.",
			CardType.ATTACK),
	// augmentation
	reflexes(new AugmentationSpell("Reflexes", 1, 5, 1, true, false, 0, 0, 50, 0, 0, 0, 0, 0), null,
			"Increase agility of ally for one round", CardType.AUGMENTATION),
	trueAim(new AugmentationSpell("True Aim", 1, 5, 1, true, false, 0, 0, 0, 0, 50, 0, 0, 0), null,
			"Increase accuracy of ally for one round", CardType.AUGMENTATION),
	// summoning
	magicWall(new SummonSpell("Magic Wall", 1, 5, 1, true, true, Defenders.magicWall.getDefender()), null, "Summon" +
			" magic wall to defend you", CardType.SUMMONING),
	// custom (name/cardlife/cost/levelrequired/targetother/ranged)
	charm(new Charm("Charm", 1, 5, 4, true, false), null, "Charm one enemy to fight for you", CardType.ATTACK),
	metalStorm(new MetalStorm("Metal Storm", 1, 5, 4, true, true), null,
			"Summon storm of metal to damage and cause bleeding.", CardType.ATTACK),
	iceRain(new IceRain("Ice Rain", 1, 5, 4, true, true), null,
			"Summon storm of ice to damage and freeze(2d4*10 damage " + "to agility).", CardType.ATTACK),
	coldBlast(new ColdBlast("Cold Blast", 1, 10, 7, true, true), null,
			"Cold energy flows from casters palm inflicting" + " cold damage and freezing(2d4*10 damage to agility).",
			CardType.ATTACK),
	heatLance(new HeatLance("Heat Lance", 1, 10, 7, true, true), null, "A burst of fire energy comes from the casters" +
			" hand and explodes on the target causing fire damage and weakens (2d4*10 damage to strength.",
			CardType.ATTACK),
	fireStorm(new FireStorm("Fire Storm", 1, 15, 10, true, true), null,
			"Summon storm of fire to consume enemies. Does" + " 1d8/level fire weakens (reduce strength by 150).",
			CardType.ATTACK),
	greaterBlindness(new GreaterBlindness("Greater Blindness", 1, 15, 10, true, false), null, "85% chance minus " +
			"10% for each 150 hit points remaining on the target to cause blindness. (accuracy and agility " +
			"reduced by 50%.", CardType.AUGMENTATION),
	greaterEnfeeblement(new GreaterEnfeeblement("Greater Enfeeblement", 1, 20, 13, true, false), null,
			"85% chance minus" +
					" 10% for every 100 hit points remaining on target to weaken target. (attack and defense reduced by " +
					"50%.", CardType.AUGMENTATION),
	darkCall(new DarkCall("Dark Call", 1, 25, 13, true, false), null,
			"85% chance minus 10% for every 50 hit points" + " remaining on the target to slay your enemy",
			CardType.ATTACK),
	diffuse(new Diffuse("Diffuse", 1, 1, 1, true, true), null,
			"Remove all negative effects inflicted by a caster " + "of level 7 or below", CardType.AUGMENTATION),
	gargoyle(new Gargoyle("Gargoyle", 2, 15, 7, true, false), null, "Turn target to stone for two rounds.",
			CardType.ATTACK),
	greaterDiffuse(new GreaterDiffuse("Greater Diffuse", 1, 15, 7, true, true), null,
			"Remove all negative effects" + " from target", CardType.AUGMENTATION),
	shatter(new Shatter("Shatter", 1, 25, 13, true, true), null,
			"Do damage to petrified target, 30% chance" + " to shatter them.", CardType.ATTACK),
	sleep(new Sleep("Sleep", 1, 5, 4, true, true), null, "65% chance (+-10% for each level difference between the" +
			" caster and the target to put target to sleep for one round.", CardType.ATTACK),
	summonMinotaur(new SummonMinotaur("Summon Minotaur", 1, 5, 4, true, true), null,
			"Summon a minotaur to attack target." +
					" Minotaur does 1d6/level of caster damage and has a 35% change to stun enemy. Double damage" +
					" against walls.", CardType.ATTACK),
	summonSkeleton(new SummonSkeleton("Summon Skeleton", 1, 1, 1, true, true), null,
			"Summon skeleton to attack target." +
					" Skeleton does 1d4/level of caster damage and reduces targets defense by 1 per level of the " +
					"caster.", CardType.ATTACK),
	unsummon(new Unsummon("Unsummon", 1, 5, 4, true, true), null,
			"20% plus 10% per level of caster chance to " + "instantly unsummon one defender", CardType.ATTACK),
	wings(new Wings("Wings", 1, 15, 7, true, false), null,
			"Give ally ability to fly for one round. Target ignores " + "walls for this turn.", CardType.AUGMENTATION),
	battlements(new Battlements("Battlements", 1, 25, 10, true, true), null, "Summon walls for all allies", CardType.SUMMONING),
	// DIVINE SPELLS
	// attack
	harm(new AttackSpell("Harm", 1, 1, 1, true, false, Dice.D4.getDie(), 0, 15, true, DamageTypes.PHYSICAL, null,
			1, false, 0, false), null, "Cause damage with a touch", CardType.ATTACK)
	// augmentation
	// summoning
	// custom
	;

	/*
	AttackSpell constructor guide:
	name/cardLife/cost/levelRequired/targetOther/ranged/dieToRoll/dieMultiplier/maxLevel/perLevel/typeOfDamage/
	effects(arr)/maxTargets/stun/stunchance/ignoreDefender
	*/
	Spells(Card spell, Effect e, String desc, CardType cardType)
	{
		if (e != null)
		{
			((AttackSpell) spell).getEffects().add(e);
		}
		setSpell(spell);
		setDescription(desc);
		setSpellType(cardType);
	}

	private Card spell;
	private String description;
	private CardType cardType;

	@Override
	public String toString()
	{
		return getSpell().getName();
	}

	public static Card getSpellByName(String name)
	{
		for (Spells s : values())
		{
			if (s.getSpell().getName().equalsIgnoreCase(name))
			{
				return s.getSpell().clone();
			}
		}
		return null;
	}

	public void setSpell(Card spell)
	{
		this.spell = spell;
	}

	public Card getSpell()
	{
		return spell;
	}

	public void setDescription(String desc)
	{
		description = desc;
	}

	public String getDescription()
	{
		return description;
	}

	public CardType getSpellType()
	{
		return cardType;
	}

	public void setSpellType(CardType cardType)
	{
		this.cardType = cardType;
	}
}
