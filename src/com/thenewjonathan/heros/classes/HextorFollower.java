package com.thenewjonathan.heros.classes;

import com.thenewjonathan.enums.*;
import com.thenewjonathan.heros.schools.Divine;
import com.thenewjonathan.interfaces.IHasAbilities;
import com.thenewjonathan.interfaces.IHero;
import com.thenewjonathan.objects.usables.Armor;
import com.thenewjonathan.objects.usables.Weapon;

import java.util.ArrayList;

public class HextorFollower extends Divine implements IHasAbilities, IHero
{

	public HextorFollower()
	{
		super();
		loadAbilities();
		setStartingAttributes();
		setStartingCache();
		initializeStats();
	}

	public HextorFollower(String name, Genders gender, int level, int strength, int agility, int intelligence,
	                      int accuracy, int wisdom, int constitution, int will, int weaponProficiency,
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
	public HextorFollower clone()
	{
		HextorFollower c =
				new HextorFollower(getName(), getGender(), getLevel(), getStrength(), getAgility(), getIntelligence(),
						getAccuracy(), getWisdom(), getConstitution(), getWill(), getWeaponProficiency(),
						getWeaponProficiencyTypes(), getXp(), getWeaponsInPlay(), getArmorInPlay());
		copyArrays(c);
		return c;
	}

	public void loadAbilities()
	{
		super.getAbilities().add(Abilities.magicDart.getAbility());
		super.getAbilities().add(Abilities.hextorsAxe.getAbility());
		super.getAbilities().add(Abilities.essenceOfHextor.getAbility());
		super.getAbilities().add(Abilities.hextorsMace.getAbility());
		super.getAbilities().add(Abilities.hextorsMantle.getAbility());
	}

	public void setStartingAttributes()
	{
		setStrength(150);
		setAgility(100);
		setIntelligence(50);
		setAccuracy(100);
		setWisdom(50);
		setConstitution(250);
		setWill(150);
		setWeaponProficiency(150);
		addWeaponProficiencyTypes(WeaponTypes.MACE);
		addWeaponProficiencyTypes(WeaponTypes.AXE);
		addWeaponProficiencyTypes(WeaponTypes.FLAIL);
		addWeaponProficiencyTypes(WeaponTypes.PICK);
		addWeaponProficiencyTypes(WeaponTypes.CLUB);
	}

	public void setStartingCache()
	{
		if(getArmorCache() == null || getArmorCache().size() == 0)
		{
			addArmorToCache(Armors.leatherArmor.getArmor());
		}

		if(getWeaponsCache() == null || getWeaponsCache().size() == 0)
		{
			addWeaponToCache(Weapons.lightClub.getWeapon());
		}

		if(getLibrary() == null || getLibrary().size() == 0)
		{

		}
	}
}
