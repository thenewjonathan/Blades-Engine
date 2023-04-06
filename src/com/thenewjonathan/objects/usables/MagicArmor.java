package com.thenewjonathan.objects.usables;

import com.thenewjonathan.enums.ArmorTypes;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IArmor;

public class MagicArmor extends Armor implements IArmor
{
	private int strBonus;
	private int agiBonus;
	private int intBonus;
	private int accBonus;
	private int wisBonus;
	private int constBonus;
	private int willBonus;
	private int weaponProficiencyBonus;
	private int shockDamageModifier;
	private int fireDamageModifier;
	private int coldDamageModifier;
	private int poisonDamageModifier;

	/**
	 * Armor that adds effects other than just defense bonus
	 *
	 * @param name
	 * @param desc
	 * @param level
	 * @param type
	 * @param defenseModifier
	 * @param durability
	 * @param strBonus
	 * @param agiBonus
	 * @param intBonus
	 * @param accBonus
	 * @param wisBonus
	 * @param constBonus
	 * @param willBonus
	 * @param weaponProficiencyBonus
	 * @param shockDamageMod
	 * @param fireDamageMod
	 * @param coldDamageMod
	 * @param poisonDamageMod
	 */
	public MagicArmor(String name, String desc, int level, ArmorTypes type, int defenseModifier, int durability,
	                  int strBonus, int agiBonus, int intBonus, int accBonus, int wisBonus, int constBonus,
	                  int willBonus, int weaponProficiencyBonus, int shockDamageMod, int fireDamageMod,
	                  int coldDamageMod, int poisonDamageMod)
	{
		super(name, desc, level, type, defenseModifier, durability);
		setStrBonus(strBonus);
		setAgiBonus(agiBonus);
		setIntBonus(intBonus);
		setAccBonus(accBonus);
		setWisBonus(wisBonus);
		setConstBonus(constBonus);
		setWillBonus(willBonus);
		setWeaponProficiencyBonus(weaponProficiencyBonus);
		setShockDamageModifier(shockDamageMod);
		setFireDamageModifier(fireDamageMod);
		setColdDamageModifier(coldDamageMod);
		setPoisonDamageModifier(poisonDamageMod);
	}

	@Override
	public void applyBonus(Combatant c)
	{
		c.setStrength(c.getStrength() + getStrBonus());
		c.setAgility(c.getAgility() + getAgiBonus());
		c.setIntelligence(c.getIntelligence() + getIntBonus());
		c.setAccuracy(c.getAccuracy() + getAccBonus());
		c.setWisdom(c.getWisdom() + getWisBonus());
		c.setWill(c.getWill() + getWillBonus());
		c.setConstitution(c.getConstitution() + getConstBonus());
		c.setWeaponProficiency(c.getWeaponProficiency() + getWeaponProficiencyBonus());
		c.setFireDamageModifier(c.getFireDamageModifier() + getFireDamageModifier());
		c.setColdDamageModifier(c.getColdDamageModifier() + getColdDamageModifier());
		c.setPoisonDamageModifier(c.getPoisonDamageModifier() + getPoisonDamageModifier());
		c.setShockDamageModifier(c.getShockDamageModifier() + getShockDamageModifier());
	}

	@Override
	public void removeBonus(Combatant c)
	{
		c.setStrength(c.getStrength() - getStrBonus());
		c.setAgility(c.getAgility() - getAgiBonus());
		c.setIntelligence(c.getIntelligence() - getIntBonus());
		c.setAccuracy(c.getAccuracy() - getAccBonus());
		c.setWisdom(c.getWisdom() - getWisBonus());
		c.setWill(c.getWill() - getWillBonus());
		c.setConstitution(c.getConstitution() - getConstBonus());
		c.setWeaponProficiency(c.getWeaponProficiency() - getWeaponProficiencyBonus());
		c.setFireDamageModifier(c.getFireDamageModifier() - getFireDamageModifier());
		c.setColdDamageModifier(c.getColdDamageModifier() - getColdDamageModifier());
		c.setPoisonDamageModifier(c.getPoisonDamageModifier() - getPoisonDamageModifier());
		c.setShockDamageModifier(c.getShockDamageModifier() - getShockDamageModifier());
	}

	public int getStrBonus()
	{
		return strBonus;
	}

	public void setStrBonus(int strBonus)
	{
		this.strBonus = strBonus;
	}

	public int getAgiBonus()
	{
		return agiBonus;
	}

	public void setAgiBonus(int atiBonus)
	{
		agiBonus = atiBonus;
	}

	public int getIntBonus()
	{
		return intBonus;
	}

	public void setIntBonus(int intBonus)
	{
		this.intBonus = intBonus;
	}

	public int getAccBonus()
	{
		return accBonus;
	}

	public void setAccBonus(int accBonus)
	{
		this.accBonus = accBonus;
	}

	public int getWisBonus()
	{
		return wisBonus;
	}

	public void setWisBonus(int wisBonus)
	{
		this.wisBonus = wisBonus;
	}

	public int getConstBonus()
	{
		return constBonus;
	}

	public void setConstBonus(int constBonus)
	{
		this.constBonus = constBonus;
	}

	public int getWillBonus()
	{
		return willBonus;
	}

	public void setWillBonus(int willBonus)
	{
		this.willBonus = willBonus;
	}

	public int getWeaponProficiencyBonus()
	{
		return weaponProficiencyBonus;
	}

	public void setWeaponProficiencyBonus(int weaponProficiencyBonus)
	{
		this.weaponProficiencyBonus = weaponProficiencyBonus;
	}

	public int getShockDamageModifier()
	{
		return shockDamageModifier;
	}

	public void setShockDamageModifier(int shockDamageModifier)
	{
		this.shockDamageModifier = shockDamageModifier;
	}

	public int getFireDamageModifier()
	{
		return fireDamageModifier;
	}

	public void setFireDamageModifier(int fireDamageModifier)
	{
		this.fireDamageModifier = fireDamageModifier;
	}

	public int getColdDamageModifier()
	{
		return coldDamageModifier;
	}

	public void setColdDamageModifier(int coldDamageModifier)
	{
		this.coldDamageModifier = coldDamageModifier;
	}

	public int getPoisonDamageModifier()
	{
		return poisonDamageModifier;
	}

	public void setPoisonDamageModifier(int poisonDamageModifier)
	{
		this.poisonDamageModifier = poisonDamageModifier;
	}
}
