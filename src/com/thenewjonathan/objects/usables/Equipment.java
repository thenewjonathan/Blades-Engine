package com.thenewjonathan.objects.usables;

public class Equipment
{
	private String name;
	private String description;
	private int level;

	public Equipment(String name, String desc, int level)
	{
		setName(name);
		setDescription(desc);
		setLevel(level);
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

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getLevel()
	{
		return level;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

}
