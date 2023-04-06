package com.thenewjonathan.enums;

public enum DamageTypes
{
	FIRE,
	ICE,
	POISON,
	SHOCK,
	PHYSICAL;

	@Override
	public String toString()
	{
		String name = super.toString();
		return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}
}
