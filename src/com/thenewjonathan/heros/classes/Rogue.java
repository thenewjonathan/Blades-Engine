package com.thenewjonathan.heros.classes;

import com.thenewjonathan.enums.*;
import com.thenewjonathan.heros.schools.Speed;
import com.thenewjonathan.interfaces.IHasAbilities;
import com.thenewjonathan.interfaces.IHero;
import com.thenewjonathan.objects.usables.Armor;
import com.thenewjonathan.objects.usables.Weapon;

import java.util.ArrayList;

public class Rogue extends Speed implements IHasAbilities, IHero
{

	public Rogue()
	{
		super();
		loadAbilities();
		setStartingAttributes();
		setStartingCache();
		initializeStats();
	}

	public Rogue(String name, Genders gender, int level, int strength, int agility, int intelligence, int accuracy,
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
	public Rogue clone()
	{
		Rogue c = new Rogue(getName(), getGender(), getLevel(), getStrength(), getAgility(), getIntelligence(),
				getAccuracy(), getWisdom(), getConstitution(), getWill(), getWeaponProficiency(),
				getWeaponProficiencyTypes(), getXp(), getWeaponsInPlay(), getArmorInPlay());
		copyArrays(c);
		return c;
	}

	public void loadAbilities()
	{
		super.getAbilities().add(Abilities.demilitarize.getAbility());
		super.getAbilities().add(Abilities.deathBy1000Cuts.getAbility());
		super.getAbilities().add(Abilities.slay.getAbility());
	}

	public void setStartingAttributes()
	{
		setStrength(75);
		setAgility(300);
		setIntelligence(100);
		setAccuracy(300);
		setWisdom(100);
		setConstitution(25);
		setWill(50);
		setWeaponProficiency(50);
		addWeaponProficiencyTypes(WeaponTypes.LIGHTBLADE);
		addWeaponProficiencyTypes(WeaponTypes.BOW);
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
