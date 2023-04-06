package com.thenewjonathan.objects.usables;

import com.thenewjonathan.userinterface.CommonFunctions;

public class Defender
{
	private String name;
	private int defense;
	private int attack;
	private int life;

	public Defender(String name, int defense, int attack, int life)
	{
		setName(name);
		setDefense(defense);
		setAttack(attack);
		setLife(life);
	}

	public boolean takeDamage(int damage)
	{ // returns true if the attack killed the defender
		CommonFunctions.say(getName() + " took " + damage + " damage");
		setLife(getLife() - damage);
		return getLife() <= 0;
	}

	@Override
	public String toString()
	{
		return getName();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getDefense()
	{
		return defense;
	}

	public void setDefense(int defense)
	{
		this.defense = defense;
	}

	public int getAttack()
	{
		return attack;
	}

	public void setAttack(int attack)
	{
		this.attack = attack;
	}

	public int getLife()
	{
		return life;
	}

	public void setLife(int life)
	{
		this.life = life;
	}
}
