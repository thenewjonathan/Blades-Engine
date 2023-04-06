package com.thenewjonathan.heros.classes;

import com.thenewjonathan.enums.*;
import com.thenewjonathan.heros.schools.Power;
import com.thenewjonathan.interfaces.IHasAbilities;
import com.thenewjonathan.interfaces.IHero;
import com.thenewjonathan.objects.usables.Armor;
import com.thenewjonathan.objects.usables.Weapon;

import java.util.ArrayList;

public class Barbarian extends Power implements IHasAbilities, IHero
{

	public Barbarian()
	{
		super();
		loadAbilities();
		setStartingAttributes();
		setStartingCache();
		initializeStats();
	}

	public Barbarian(String name, Genders gender, int level, int strength, int agility, int intelligence, int accuracy,
	                 int wisdom, int constitution, int will, int weaponProficiency,
	                 ArrayList<WeaponTypes> weaponProficiencyTypes, int xp, ArrayList<Weapon> weapons,
	                 ArrayList<Armor> armor)
	{
		super(name, gender, level, strength, agility, intelligence, accuracy, wisdom, constitution, will,
				weaponProficiency, weaponProficiencyTypes, xp, weapons, armor);
		loadAbilities();
		setStartingCache();
		initializeStats();
	}

	@Override
	public Barbarian clone()
	{
		Barbarian c = new Barbarian(getName(), getGender(), getLevel(), getStrength(), getAgility(), getIntelligence(),
				getAccuracy(), getWisdom(), getConstitution(), getWill(), getWeaponProficiency(),
				getWeaponProficiencyTypes(), getXp(), getWeaponsInPlay(), getArmorInPlay());
		copyArrays(c);
		return c;
	}

	public void loadAbilities()
	{
		super.getAbilities().add(Abilities.warCry.getAbility());
		super.getAbilities().add(Abilities.berserk.getAbility());
		super.getAbilities().add(Abilities.bladeArc.getAbility());
	}

	public void setStartingAttributes()
	{
		setStrength(300);
		setAgility(100);
		setIntelligence(50);
		setAccuracy(100);
		setWisdom(50);
		setConstitution(200);
		setWill(50);
		setWeaponProficiency(150);
		setDualWield(true);
		addWeaponProficiencyTypes(WeaponTypes.HAMMER);
	}

	public void setStartingCache()
	{
		if(getArmorCache() == null || getArmorCache().size() == 0)
		{
			addArmorToCache(Armors.leatherArmor.getArmor());
		}

		if(getWeaponsCache() == null || getWeaponsCache().size() == 0)
		{
			addWeaponToCache(Weapons.lightWarHammer.getWeapon());
		}

		if(getLibrary() == null || getLibrary().size() == 0)
		{

		}
	}
}
