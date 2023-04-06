package com.thenewjonathan.enums;

public enum EffectTypes
{
	POISON,
	BLEEDING,
	BURNING,
	DISEASE,
	COLD,
	SHOCK;

	@Override
	public String toString()
	{
		String name = super.toString();
		return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}
}
