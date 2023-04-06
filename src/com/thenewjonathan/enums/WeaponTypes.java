package com.thenewjonathan.enums;

public enum WeaponTypes
{
	MACE,
	CLUB,
	LIGHTBLADE,
	HEAVYBLADE,
	SPEAR,
	UNARMEDAUGMENT,
	STAFF,
	AXE,
	FLAIL,
	PICK,
	HAMMER,
	POLEARM,
	CROSSBOW,
	BOW;

	@Override
	public String toString()
	{
		String name = super.toString();
		return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}

	public static WeaponTypes getTypeByName(String name)
	{
		for (WeaponTypes wt : values())
		{
			if (wt.toString().equalsIgnoreCase(name))
			{
				return wt;
			}
		}
		return null;
	}
}
