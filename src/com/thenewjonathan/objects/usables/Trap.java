package com.thenewjonathan.objects.usables;

import com.thenewjonathan.heros.superclasses.Combatant;

public class Trap
{
	private String name;
	private int level;
	private int damage;
	private int poisonDamage;
	private int fireDamage;
	private int coldDamage;
	private int shockDamage;

	public Trap(String name, int level, int damage, int pDamage, int fDamage, int cDamage, int sDamage)
	{
		setName(name);
		setLevel(level);
		setDamage(damage);
		setPoisonDamage(pDamage);
		setFireDamage(fDamage);
		setColdDamage(cDamage);
		setShockDamage(sDamage);
	}

	public void executeTrap(Combatant target)
	{
		target.takeDamage(null, (getDamage() > 0) ?
				(getDamage() * ((100 - target.getDamageModifierPercent()) / 100)) - target.getDamageModifier() : 0,
				(getPoisonDamage() > 0) ?
						(getPoisonDamage() * ((100 - target.getPoisonDamageModifierPercent()) / 100)) -
								target.getPoisonDamageModifier() : 0, (getColdDamage() > 0) ?
				(getColdDamage() * ((100 - target.getColdDamageModifierPercent()) / 100)) -
						target.getColdDamageModifier() : 0, (getFireDamage() > 0) ?
				(getFireDamage() * ((100 - target.getFireDamageModifierPercent()) / 100)) -
						target.getFireDamageModifier() : 0, 0, (getShockDamage() > 0) ?
				(getShockDamage() * ((100 - target.getShockDamageModifierPercent()) / 100)) -
						target.getShockDamageModifier() : 0, 0);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getLevel()
	{
		return level;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

	public int getDamage()
	{
		return damage;
	}

	public void setDamage(int damage)
	{
		this.damage = damage;
	}

	public int getPoisonDamage()
	{
		return poisonDamage;
	}

	public void setPoisonDamage(int poisonDamage)
	{
		this.poisonDamage = poisonDamage;
	}

	public int getFireDamage()
	{
		return fireDamage;
	}

	public void setFireDamage(int fireDamage)
	{
		this.fireDamage = fireDamage;
	}

	public int getColdDamage()
	{
		return coldDamage;
	}

	public void setColdDamage(int coldDamage)
	{
		this.coldDamage = coldDamage;
	}

	public int getShockDamage()
	{
		return shockDamage;
	}

	public void setShockDamage(int shockDamage)
	{
		this.shockDamage = shockDamage;
	}
}
