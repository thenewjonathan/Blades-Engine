package com.thenewjonathan.heros.classes;

import com.thenewjonathan.enums.Abilities;
import com.thenewjonathan.enums.Genders;
import com.thenewjonathan.enums.WeaponTypes;
import com.thenewjonathan.enums.Weapons;
import com.thenewjonathan.heros.schools.Power;
import com.thenewjonathan.interfaces.IHasAbilities;
import com.thenewjonathan.interfaces.IHero;
import com.thenewjonathan.objects.usables.Armor;
import com.thenewjonathan.objects.usables.Weapon;

import java.util.ArrayList;

public class Monk extends Power implements IHasAbilities, IHero
{

	public Monk()
	{
		super();
		loadAbilities();
		setStartingAttributes();
		setStartingCache();
		initializeStats();
	}

	public Monk(String name, Genders gender, int level, int strength, int agility, int intelligence, int accuracy,
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
	public Monk clone()
	{
		Monk c = new Monk(getName(), getGender(), getLevel(), getStrength(), getAgility(), getIntelligence(),
				getAccuracy(), getWisdom(), getConstitution(), getWill(), getWeaponProficiency(),
				getWeaponProficiencyTypes(), getXp(), getWeaponsInPlay(), getArmorInPlay());
		copyArrays(c);
		return c;
	}

	public void loadAbilities()
	{
		super.getAbilities().add(Abilities.criticalStrike.getAbility());
		super.getAbilities().add(Abilities.grace.getAbility());
		super.getAbilities().add(Abilities.cleansing.getAbility());
	}

	public void setStartingAttributes()
	{
		setStrength(250);
		setAgility(100);
		setIntelligence(150);
		setAccuracy(100);
		setWisdom(100);
		setConstitution(200);
		setWill(50);
		setWeaponProficiency(50);
		addWeaponProficiencyTypes(WeaponTypes.STAFF);

	}

	public void setStartingCache()
	{
		if(getArmorCache() == null || getArmorCache().size() == 0)
		{

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
