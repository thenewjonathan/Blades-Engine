package com.thenewjonathan.objects.admin;

import java.util.Random;

public class Die
{
	private int numberOfSides;
	private int numberOfRolls;
	private Random rand = new Random();

	public Die(int numberOfSides, int numberOfRolls)
	{
		setNumberOfSides(numberOfSides);
		setNumberOfRolls(numberOfRolls);
	}

	public int roll()
	{
		int total = 0;
		for (int i = 0; i < getNumberOfRolls(); i++)
		{
			total += (rand.nextInt(getNumberOfSides()) + 1);
		}
		return total;
	}

	public int getNumberOfSides()
	{
		return numberOfSides;
	}

	public void setNumberOfSides(int numberOfSides)
	{
		this.numberOfSides = numberOfSides;
	}

	public int getNumberOfRolls()
	{
		return numberOfRolls;
	}

	public void setNumberOfRolls(int numberOfRolls)
	{
		this.numberOfRolls = numberOfRolls;
	}
}
