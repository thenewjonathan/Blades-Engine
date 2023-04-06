package com.thenewjonathan.enums;

import com.thenewjonathan.objects.admin.Die;

public enum Dice
{
	D4(4, 1),
	D6(6, 1),
	D8(8, 1),
	D10(10, 1),
	D12(12, 1),
	D20(20, 1),
	DD4(4, 2),
	DD6(6, 2),
	DD8(8, 2),
	DD10(10, 2),
	DD12(12, 2);

	Dice(int numberOfSides, int numberOfRolls)
	{
		setDie(new Die(numberOfSides, numberOfRolls));
	}

	private Die die;

	@Override
	public String toString()
	{
		switch (this)
		{
			case D4:
				return "1d4";
			case D6:
				return "1d6";
			case D8:
				return "1d8";
			case D10:
				return "1d10";
			case D12:
				return "1d12";
			case D20:
				return "1d20";
			case DD4:
				return "2d4";
			case DD6:
				return "2d6";
			case DD8:
				return "2d8";
			case DD10:
				return "2d10";
			case DD12:
				return "2d12";
			default: // should never happen
				return "Errror in Dice toString method";
		}
	}

	public static boolean percentageRoll(int chance)
	{
		int tens = Dice.D10.getDie().roll();
		int ones = Dice.D10.getDie().roll();
		if (tens == 10)
		{
			tens = 0;
		}
		if (ones == 10)
		{
			ones = 0;
		}
		int roll = (tens * 10) + ones;
		return ((100 - chance) <= roll);
	}

	public Die getDie()
	{
		return die;
	}

	public void setDie(Die die)
	{
		this.die = die;
	}
}
