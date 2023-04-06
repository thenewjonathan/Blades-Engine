package com.thenewjonathan.enums;

import com.thenewjonathan.objects.usables.Armor;
import com.thenewjonathan.objects.usables.MagicArmor;
import com.thenewjonathan.objects.usables.magicitems.CursedGlovesOfGiantStrength;


public enum Armors
{
	// body
	wizardRobe(new Armor("Wizard's robe", "Basic robe, no attributes", 1, ArmorTypes.WIZARD, 0, 10)),
	leatherArmor(new Armor("Leather Armor", "Basic leather armor", 1, ArmorTypes.LIGHT, 1, 15)),
	leatherArmorOfOgreStrength(
			new MagicArmor("Leather Armor of Ogre Strength", "Enchanted leather armor, plus to strength", 5,
					ArmorTypes.LIGHT, 1, 15, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
	chainArmor(new Armor("Chain Armor", "+4 defense", 5, ArmorTypes.MEDIUM, 4, 30)),
	plateArmor(new Armor("Plate Armor", "+6 defense", 9, ArmorTypes.HEAVY, 6, 40)),
	elementalChainMantle(new MagicArmor("Elemental Chain Mantle", "+5 defense, resistant to all elemental damage", 10,
			ArmorTypes.MEDIUM, 5, 35, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 5, 5)),
	robeOfEnlightenment(
			new MagicArmor("Robe of Enlightenment", "+50 bonus to intelligence", 3, ArmorTypes.WIZARD, 0, 50, 0, 0, 50,
					0, 0, 0, 0, 0, 0, 0, 0, 0)),
	robeOfEncouragement(
			new MagicArmor("Robe of Encouragement", "+50 to will", 4, ArmorTypes.WIZARD, 0, 50, 0, 0, 0, 0, 0, 0, 50, 0,
					0, 0, 0, 0)),
	// helmet
	leatherCap(new Armor("Leather Cap", "+1 defense", 1, ArmorTypes.HELMET, 1, 10)),
	ironCap(new Armor("Iron Cap", "+2 defense", 4, ArmorTypes.HELMET, 2, 20)),
	soldiersHelm(new Armor("Soldier's Helm", "+4 defense", 8, ArmorTypes.HELMET, 4, 30)),
	cursedHelmOfSpeed(
			new MagicArmor("Cursed Helm of Speed", "+3 defense, +100 agility, -100 strength", 10, ArmorTypes.HELMET, 3,
					25, -100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
	helmOfClearThought(
			new MagicArmor("Helm of Clear Thought", "Gives wearer bonus to intelligence", 5, ArmorTypes.HELMET, 1, 20,
					0, 0, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0)),

	// greaves
	grievesOfSureFooting(
			new MagicArmor("Grieves of Sure Footing", "+150 bonus to accuracy", 10, ArmorTypes.GAUNTLET, 1, 20, 0, 0, 0,
					150, 0, 0, 0, 0, 0, 0, 0, 0)),
	// gauntlets
	leatherGloves(new Armor("Leather Gloves", "+1 defense", 1, ArmorTypes.GAUNTLET, 1, 10)),
	chainGloves(new Armor("Chain Gloves", "+3 defense", 4, ArmorTypes.GAUNTLET, 3, 20)),
	heavyGauntlets(new Armor("Heavy Gauntlets", "+5 defense", 8, ArmorTypes.GAUNTLET, 5, 30)),
	gauntletsOfTrueStriking(
			new MagicArmor("Gauntlets of True Striking", "+100 bonus to accuracy", 7, ArmorTypes.GAUNTLET, 1, 20, 0, 0,
					0, 100, 0, 0, 0, 0, 0, 0, 0, 0)),
	cursedGlovesOfGiantStrength(new CursedGlovesOfGiantStrength("Cursed Gloves of Giant Strength",
			"+200 strength, deals 10 poison damage and inflices poison(30,6) when equiped", 13, ArmorTypes.GAUNTLET, 4,
			40, 200, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
	// shields
	smallShield(new Armor("Small Shield", "1 defense", 1, ArmorTypes.SHIELD, 1, 15)),
	mediumShield(new Armor("Medium Shield", "2 defense", 3, ArmorTypes.SHIELD, 2, 15)),
	kiteShield(new Armor("Kite Shield", "3 defense", 5, ArmorTypes.SHIELD, 3, 15)),
	fullShield(new Armor("Full Shield", "5 defense", 9, ArmorTypes.SHIELD, 5, 25)),
	holyBarrier(
			new MagicArmor("Holy Barrier", "Kite Shield with poison resistance", 10, ArmorTypes.SHIELD, 3, 25, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 5));

	Armors(Armor a)
	{
		setArmor(a);
	}

	private Armor armor;

	@Override
	public String toString()
	{
		return getArmor().getName();
	}

	public static Armor getArmorByName(String name)
	{
		for (Armors a : values())
		{
			if (a.getArmor().getName().equalsIgnoreCase(name))
			{
				return a.getArmor();
			}
		}
		return null;
	}

	public void setArmor(Armor a)
	{
		armor = a;
	}

	public Armor getArmor()
	{
		return armor;
	}
}
