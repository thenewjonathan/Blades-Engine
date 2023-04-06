package com.thenewjonathan.enums;

public enum Constants
{
	HERO_CLASSES_FOLDER("com.thenewjonathan.heros.classes.");

	Constants(String value)
	{
		setValue(value);
	}

	private String value;

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}

	@Override
	public String toString()
	{
		return getValue();
	}
}
