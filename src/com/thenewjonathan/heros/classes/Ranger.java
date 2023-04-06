package com.thenewjonathan.heros.classes;

import com.thenewjonathan.enums.*;
import com.thenewjonathan.heros.schools.Speed;
import com.thenewjonathan.interfaces.IHasAbilities;
import com.thenewjonathan.interfaces.IHero;
import com.thenewjonathan.objects.usables.Armor;
import com.thenewjonathan.objects.usables.Weapon;

import java.util.ArrayList;

public class Ranger extends Speed implements IHasAbilities, IHero
{

	public Ranger()
	{
		super();
		loadAbilities();
		setStartingAttributes();
		setStartingCache();
		initializeStats();
	}

	public Ranger(String name, Genders gender, int level, int strength, int agility, int intelligence, int accuracy,
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
	public Ranger clone()
	{
		Ranger c = new Ranger(getName(), getGender(), getLevel(), getStrength(), getAgility(), getIntelligence(),
				getAccuracy(), getWisdom(), getConstitution(), getWill(), getWeaponProficiency(),
				getWeaponProficiencyTypes(), getXp(), getWeaponsInPlay(), getArmorInPlay());
		copyArrays(c);
		return c;
	}

	public void loadAbilities()
	{
		super.getAbilities().add(Abilities.focusedStrike.getAbility());
		super.getAbilities().add(Abilities.jumpAttack.getAbility());
		super.getAbilities().add(Abilities.throwingKnife.getAbility());
		super.getAbilities().add(Abilities.tipOfTheBlade.getAbility());
	}

	public void setStartingAttributes()
	{
		setStrength(100);
		setAgility(250);
		setIntelligence(100);
		setAccuracy(150);
		setWisdom(100);
		setConstitution(100);
		setWill(50);
		setWeaponProficiency(150);
		addWeaponProficiencyTypes(WeaponTypes.BOW);
		addWeaponProficiencyTypes(WeaponTypes.LIGHTBLADE);
		setDualWield(true);
	}

	public void setStartingCache()
	{
		if(getArmorCache() == null || getArmorCache().size() == 0)
		{
			addArmorToCache(Armors.leatherArmor.getArmor());
		}

		if(getWeaponsCache() == null || getWeaponsCache().size() == 0)
		{
			addWeaponToCache(Weapons.bow.getWeapon());
		}

		if(getLibrary() == null || getLibrary().size() == 0)
		{

		}
	}
}
