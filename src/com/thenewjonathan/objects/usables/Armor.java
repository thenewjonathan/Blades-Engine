package com.thenewjonathan.objects.usables;

import com.thenewjonathan.enums.ArmorTypes;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IArmor;

public class Armor extends Equipment implements IArmor
{
	private ArmorTypes type;
	private int defenseModifier;
	private int durability;

	public Armor(String name, String desc, int level, ArmorTypes type, int defenseModifier, int durability)
	{
		super(name, desc, level);
		setType(type);
		setDefenseModifier(defenseModifier);
		setDurability(durability);
	}

	public void applyBonus(Combatant c)
	{
		// stub
	}

	public void removeBonus(Combatant c)
	{
		// stub
	}

	public ArmorTypes getType()
	{
		return type;
	}

	public void setType(ArmorTypes type)
	{
		this.type = type;
	}

	public int getDefenseModifier()
	{
		return defenseModifier;
	}

	public void setDefenseModifier(int defenseModifier)
	{
		this.defenseModifier = defenseModifier;
	}

	public int getDurability()
	{
		return durability;
	}

	public void setDurability(int durability)
	{
		this.durability = durability;
	}
}
