package com.thenewjonathan.enums;

public enum Genders
{
	MALE,
	FEMALE;

	@Override
	public String toString()
	{
		String name = super.toString();
		return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}

	public static Genders getGenderByString(String s)
	{
		if (s.matches("[Mm][Aa][Ll][Ee]"))
		{
			return MALE;
		}
		return FEMALE;
	}
}
