package com.thenewjonathan.enums;

import com.thenewjonathan.objects.usables.Defender;

public enum Defenders
{
	magicWall(new Defender("Magic Wall", 2, 0, 20), "Basic magic wall summoned to protect a hero");

	Defenders(Defender defender, String description)
	{
		setDefender(defender);
		setDescription(description);
	}

	private Defender defender;
	private String description;

	@Override
	public String toString()
	{
		return getDefender().getName();
	}

	public void setDefender(Defender defender)
	{
		this.defender = defender;
	}

	public Defender getDefender()
	{
		return new Defender(defender.getName(), defender.getDefense(), defender.getAttack(), defender.getLife());
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getDescription()
	{
		return description;
	}
}
