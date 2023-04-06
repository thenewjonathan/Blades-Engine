package com.thenewjonathan.heros.superclasses;

import com.thenewjonathan.enums.Genders;
import com.thenewjonathan.enums.WeaponTypes;
import com.thenewjonathan.objects.usables.Ability;
import com.thenewjonathan.objects.usables.Armor;
import com.thenewjonathan.objects.usables.Card;
import com.thenewjonathan.objects.usables.Weapon;

import java.util.ArrayList;
import java.util.Random;

public class Hero extends Combatant
{
	private int heroId;
	private ArrayList<Ability> abilities;
	private ArrayList<Armor> armorVault;
	private ArrayList<Weapon> weaponVault;
	private ArrayList<Card> cardVault;

	Random rand = new Random();

	public Hero()
	{
		super();
	}

	public Hero(String name, Genders gender, int level, int strength, int agility, int intelligence, int accuracy,
	            int wisdom, int constitution, int will, int weaponProficiency,
	            ArrayList<WeaponTypes> weaponProficiencyTypes, int xp, ArrayList<Weapon> weapons,
	            ArrayList<Armor> armor)
	{
		super(name, gender, level, strength, agility, intelligence, accuracy, wisdom, constitution, will,
				weaponProficiency, weaponProficiencyTypes, xp, weapons, armor);
	}
}
