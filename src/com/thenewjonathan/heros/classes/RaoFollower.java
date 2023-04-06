package com.thenewjonathan.heros.classes;

import com.thenewjonathan.enums.*;
import com.thenewjonathan.heros.schools.Divine;
import com.thenewjonathan.interfaces.IHasAbilities;
import com.thenewjonathan.interfaces.IHero;
import com.thenewjonathan.objects.usables.Armor;
import com.thenewjonathan.objects.usables.Weapon;

import java.util.ArrayList;

public class RaoFollower extends Divine implements IHasAbilities, IHero
{

	public RaoFollower()
	{
		super();
		loadAbilities();
		setStartingAttributes();
		setStartingCache();
		initializeStats();
	}

	public RaoFollower(String name, Genders gender, int level, int strength, int agility, int intelligence,
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
	public RaoFollower clone()
	{
		RaoFollower c =
				new RaoFollower(getName(), getGender(), getLevel(), getStrength(), getAgility(), getIntelligence(),
						getAccuracy(), getWisdom(), getConstitution(), getWill(), getWeaponProficiency(),
						getWeaponProficiencyTypes(), getXp(), getWeaponsInPlay(), getArmorInPlay());
		copyArrays(c);
		return c;
	}

	public void loadAbilities()
	{
		super.getAbilities().add(Abilities.reason.getAbility());
		super.getAbilities().add(Abilities.raosBlessing.getAbility());
		super.getAbilities().add(Abilities.edoirasWisdom.getAbility());
		super.getAbilities().add(Abilities.swordlessScabbard.getAbility());
		super.getAbilities().add(Abilities.crookOfRao.getAbility());
	}

	public void setStartingAttributes()
	{
		setStrength(50);
		setAgility(50);
		setIntelligence(150);
		setAccuracy(50);
		setWisdom(150);
		setConstitution(250);
		setWill(250);
		setWeaponProficiency(50);
		addWeaponProficiencyTypes(WeaponTypes.STAFF);
		addWeaponProficiencyTypes(WeaponTypes.MACE);
	}

	public void setStartingCache()
	{
		if(getArmorCache() == null || getArmorCache().size() == 0)
		{
			addArmorToCache(Armors.leatherArmor.getArmor());
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
