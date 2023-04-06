package com.thenewjonathan.heros.classes;

import com.thenewjonathan.enums.*;
import com.thenewjonathan.heros.schools.Divine;
import com.thenewjonathan.interfaces.IHasAbilities;
import com.thenewjonathan.interfaces.IHero;
import com.thenewjonathan.objects.usables.Armor;
import com.thenewjonathan.objects.usables.Weapon;

import java.util.ArrayList;

public class NerullFollower extends Divine implements IHasAbilities, IHero
{

	public NerullFollower()
	{
		super();
		loadAbilities();
		setStartingAttributes();
		setStartingCache();
		initializeStats();
	}

	public NerullFollower(String name, Genders gender, int level, int strength, int agility, int intelligence,
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
	public NerullFollower clone()
	{
		NerullFollower c =
				new NerullFollower(getName(), getGender(), getLevel(), getStrength(), getAgility(), getIntelligence(),
						getAccuracy(), getWisdom(), getConstitution(), getWill(), getWeaponProficiency(),
						getWeaponProficiencyTypes(), getXp(), getWeaponsInPlay(), getArmorInPlay());
		copyArrays(c);
		return c;
	}

	public void loadAbilities()
	{
		super.getAbilities().add(Abilities.poison.getAbility());
		super.getAbilities().add(Abilities.soulSpider.getAbility());
		super.getAbilities().add(Abilities.miasma.getAbility());
		super.getAbilities().add(Abilities.bloodSpider.getAbility());
		super.getAbilities().add(Abilities.callOfTheGrave.getAbility());
	}

	public void setStartingAttributes()
	{
		setStrength(25);
		setAgility(50);
		setIntelligence(300);
		setAccuracy(50);
		setWisdom(50);
		setConstitution(25);
		setWill(350);
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
