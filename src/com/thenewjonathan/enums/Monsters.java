package com.thenewjonathan.enums;

import com.thenewjonathan.heros.superclasses.Monster;
import com.thenewjonathan.objects.usables.Armor;
import com.thenewjonathan.objects.usables.Weapon;

import java.util.ArrayList;

public enum Monsters
{
	wolf(new Monster("Wolf", Genders.MALE, 1, 150, 150, 50, 100, 50, 50, 50, 50, new ArrayList<WeaponTypes>(), 100,
			new ArrayList<Weapon>(), new ArrayList<Armor>()), "Basic wolf, nothing special");

	Monsters(Monster monster, String description)
	{
		setMonster(monster);
		setDescription(description);
	}

	private Monster monster;
	private String description;

	@Override
	public String toString()
	{
		return getMonster().getName();
	}

	public Monster getMonster()
	{
		return monster;
	}

	public void setMonster(Monster monster)
	{
		this.monster = monster;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}
