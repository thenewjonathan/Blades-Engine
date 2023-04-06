package com.thenewjonathan.heros.classes;

import com.thenewjonathan.enums.*;
import com.thenewjonathan.heros.schools.Arcane;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IHasAbilities;
import com.thenewjonathan.interfaces.IHero;
import com.thenewjonathan.objects.usables.Armor;
import com.thenewjonathan.objects.usables.Weapon;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class WhiteWizard extends Arcane implements IHasAbilities, IHero
{

	public WhiteWizard()
	{
		super();
		loadAbilities();
		setStartingAttributes();
		setStartingCache();
		initializeStats();
	}

	public WhiteWizard(String name, Genders gender, int level, int strength, int agility, int intelligence,
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

	public void loadAbilities()
	{
		super.getAbilities().add(Abilities.heal.getAbility());
		super.getAbilities().add(Abilities.embolden.getAbility());
	}

	@Override
	public void attack(Combatant target)
	{
		CommonFunctions.say("The Black Wizard does not have the ability to make a physical attack");
	}

	@Override
	public WhiteWizard clone()
	{
		WhiteWizard c =
				new WhiteWizard(getName(), getGender(), getLevel(), getStrength(), getAgility(), getIntelligence(),
						getAccuracy(), getWisdom(), getConstitution(), getWill(), getWeaponProficiency(),
						getWeaponProficiencyTypes(), getXp(), getWeaponsInPlay(), getArmorInPlay());
		copyArrays(c);
		return c;
	}

	public void setStartingAttributes()
	{
		setStrength(50);
		setAgility(50);
		setIntelligence(350);
		setAccuracy(50);
		setWisdom(200);
		setConstitution(50);
		setWill(250);
		setWeaponProficiency(0);
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
