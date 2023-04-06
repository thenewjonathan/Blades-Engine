package com.thenewjonathan.heros.schools;

import com.thenewjonathan.enums.Genders;
import com.thenewjonathan.enums.WeaponTypes;
import com.thenewjonathan.heros.superclasses.Hero;
import com.thenewjonathan.objects.usables.Armor;
import com.thenewjonathan.objects.usables.Weapon;

import java.util.ArrayList;

public class Arcane extends Hero
{

	public Arcane()
	{
		super();
	}

	public Arcane(String name, Genders gender, int level, int strength, int agility, int intelligence, int accuracy,
	              int wisdom, int constitution, int will, int weaponProficiency,
	              ArrayList<WeaponTypes> weaponProficiencyTypes, int xp, ArrayList<Weapon> weapons,
	              ArrayList<Armor> armor)
	{
		super(name, gender, level, strength, agility, intelligence, accuracy, wisdom, constitution, will,
				weaponProficiency, weaponProficiencyTypes, xp, weapons, armor);
	}
}
