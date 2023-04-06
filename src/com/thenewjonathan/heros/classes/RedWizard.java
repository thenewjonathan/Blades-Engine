package com.thenewjonathan.heros.classes;

import com.thenewjonathan.enums.*;
import com.thenewjonathan.heros.schools.Arcane;
import com.thenewjonathan.interfaces.IHasAbilities;
import com.thenewjonathan.interfaces.IHero;
import com.thenewjonathan.objects.usables.Armor;
import com.thenewjonathan.objects.usables.Weapon;

import java.util.ArrayList;

public class RedWizard extends Arcane implements IHasAbilities, IHero
{

	public RedWizard()
	{
		super();
		loadAbilities();
		setStartingAttributes();
		setStartingCache();
		initializeStats();
	}

	public RedWizard(String name, Genders gender, int level, int strength, int agility, int intelligence, int accuracy,
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

	public void loadAbilities()
	{
		super.getAbilities().add(Abilities.heal.getAbility());
		super.getAbilities().add(Abilities.hurt.getAbility());
	}

	@Override
	public RedWizard clone()
	{
		RedWizard c = new RedWizard(getName(), getGender(), getLevel(), getStrength(), getAgility(), getIntelligence(),
				getAccuracy(), getWisdom(), getConstitution(), getWill(), getWeaponProficiency(),
				getWeaponProficiencyTypes(), getXp(), getWeaponsInPlay(), getArmorInPlay());
		copyArrays(c);
		return c;
	}

	public void setStartingAttributes()
	{
		setStrength(100);
		setAgility(100);
		setIntelligence(300);
		setAccuracy(50);
		setWisdom(100);
		setConstitution(50);
		setWill(200);
		setWeaponProficiency(100);
		addWeaponProficiencyTypes(WeaponTypes.STAFF);
	}

	public void setStartingCache()
	{
		if(getArmorCache() == null || getArmorCache().size() == 0)
		{
			addArmorToCache(Armors.wizardRobe.getArmor());
		}

		if(getWeaponsCache() == null || getWeaponsCache().size() == 0)
		{
			addWeaponToCache(Weapons.quarterstaff.getWeapon());
		}

		if(getLibrary() == null || getLibrary().size() == 0)
		{

		}
	}
}
