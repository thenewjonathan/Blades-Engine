package com.thenewjonathan.objects.usables;

import com.thenewjonathan.enums.WeaponTypes;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IWeapon;
import com.thenewjonathan.objects.admin.Die;
import com.thenewjonathan.userinterface.CommonFunctions;

public class Weapon extends Equipment implements IWeapon
{
	private WeaponTypes type;
	private Die dieToRoll;
	private int modifier;
	private boolean ranged;
	private boolean twoHanded;

	public Weapon(String name, String desc, int level, WeaponTypes type, Die dieToRoll, int modifier, boolean ranged,
	              boolean twoHanded)
	{
		super(name, desc, level);
		setType(type);
		setDieToRoll(dieToRoll);
		setModifier(modifier);
		setRanged(ranged);
		setTwoHanded(twoHanded);
	}

	public void swing(Combatant attacker, Combatant target, boolean doubleDamage)
	{
		int damage = doubleDamage ? (dieToRoll.roll() + (getModifier()) * 2) : dieToRoll.roll() + getModifier();
		if (!target.isIgnoreDamage())
		{
			target.takeDamage(attacker, damage, 0, 0, 0, 0, 0, 0);
			CommonFunctions.say(attacker + "'s " + getName() + " did " + damage + " damage to " +
					target);
		}
		else
		{
			CommonFunctions.say(attacker + "'s " + getName() + " did " + damage + " damage to " +
					target + " but " + target + " is immune to physical damage this round");
		}
	}

	public void swing(Combatant attacker, Defender defender, boolean doubleDamage)
	{
		int damage = doubleDamage ? (dieToRoll.roll() + (getModifier()) * 2) : dieToRoll.roll() + getModifier();
		defender.takeDamage(damage);
		CommonFunctions.say(attacker + "'s " + getName() + " did " + damage + " damage to " +
				defender);
	}

	public WeaponTypes getType()
	{
		return type;
	}

	public void setType(WeaponTypes type)
	{
		this.type = type;
	}

	public Die getDieToRoll()
	{
		return dieToRoll;
	}

	public void setDieToRoll(Die dieToRoll)
	{
		this.dieToRoll = dieToRoll;
	}

	public int getModifier()
	{
		return modifier;
	}

	public void setModifier(int modifier)
	{
		this.modifier = modifier;
	}

	public boolean isRanged()
	{
		return ranged;
	}

	public void setRanged(boolean ranged)
	{
		this.ranged = ranged;
	}

	public boolean isTwoHanded()
	{
		return twoHanded;
	}

	public void setTwoHanded(boolean twoHanded)
	{
		this.twoHanded = twoHanded;
	}
}
