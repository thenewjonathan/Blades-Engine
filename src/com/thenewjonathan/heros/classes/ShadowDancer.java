package com.thenewjonathan.heros.classes;

import com.thenewjonathan.enums.*;
import com.thenewjonathan.heros.schools.Speed;
import com.thenewjonathan.interfaces.IHasAbilities;
import com.thenewjonathan.interfaces.IHero;
import com.thenewjonathan.objects.usables.Armor;
import com.thenewjonathan.objects.usables.Weapon;

import java.util.ArrayList;

public class ShadowDancer extends Speed implements IHasAbilities, IHero
{

	public ShadowDancer()
	{
		super();
		loadAbilities();
		setStartingAttributes();
		setStartingCache();
		initializeStats();
	}

	public ShadowDancer(String name, Genders gender, int level, int strength, int agility, int intelligence,
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
	public ShadowDancer clone()
	{
		ShadowDancer c =
				new ShadowDancer(getName(), getGender(), getLevel(), getStrength(), getAgility(), getIntelligence(),
						getAccuracy(), getWisdom(), getConstitution(), getWill(), getWeaponProficiency(),
						getWeaponProficiencyTypes(), getXp(), getWeaponsInPlay(), getArmorInPlay());
		copyArrays(c);
		return c;
	}

	public void loadAbilities()
	{
		super.getAbilities().add(Abilities.acrobaticStrike.getAbility());
		super.getAbilities().add(Abilities.garrote.getAbility());
	}

	public void setStartingAttributes()
	{
		setStrength(50);
		setAgility(325);
		setIntelligence(100);
		setAccuracy(200);
		setWisdom(50);
		setConstitution(25);
		setWill(100);
		setWeaponProficiency(150);
		addWeaponProficiencyTypes(WeaponTypes.LIGHTBLADE);
	}

	public void setStartingCache()
	{
		if(getArmorCache() == null || getArmorCache().size() == 0)
		{
			addArmorToCache(Armors.leatherArmor.getArmor());
		}

		if(getWeaponsCache() == null || getWeaponsCache().size() == 0)
		{
			addWeaponToCache(Weapons.dagger.getWeapon());
		}

		if(getLibrary() == null || getLibrary().size() == 0)
		{

		}
	}
}
