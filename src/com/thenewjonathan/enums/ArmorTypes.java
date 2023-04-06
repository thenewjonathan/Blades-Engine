package com.thenewjonathan.enums;


public enum ArmorTypes
{
	LIGHT,
	MEDIUM,
	HEAVY,
	SHIELD,
	GREAVE,
	GAUNTLET,
	HELMET,
	WIZARD;

	@Override
	public String toString()
	{
		String name = super.toString();
		return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}
}
