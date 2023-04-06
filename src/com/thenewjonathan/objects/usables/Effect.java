package com.thenewjonathan.objects.usables;

import com.thenewjonathan.enums.EffectTypes;
import com.thenewjonathan.heros.superclasses.Combatant;

public class Effect
{
	private Combatant creator;
	private int duration;
	private int startingPoint;
	private EffectTypes type;
	private String name;


	public Effect(Combatant creator, int startingPoint, int duration, EffectTypes type)
	{
		this(startingPoint, duration, type);
		setCreator(creator);
	}

	public Effect(int startingPoint, int duration, EffectTypes type)
	{
		setCreator(null); // set this when the effect is distributed
		setDuration(duration);
		setStartingPoint(startingPoint);
		setType(type);
	}

	@Override
	public String toString()
	{
		return getName();
	}

	public boolean execute(Combatant target)
	{
		int poison = 0, fire = 0, bleeding = 0, disease = 0, cold = 0, shock = 0;
		switch (getType())
		{
			case POISON:
				poison = getStartingPoint();
				break;
			case BURNING:
				fire = getStartingPoint();
				break;
			case BLEEDING: // physical
				bleeding = getStartingPoint();
				break;
			case DISEASE: // physical
				disease = getStartingPoint();
				break;
			case COLD:
				cold = getStartingPoint();
				break;
			case SHOCK:
				shock = getStartingPoint();
				break;
			default:
				break;
		}
		target.takeDamage(null, bleeding, poison, cold, fire, disease, shock, 0);
		setDuration(getDuration() - 1);
		setStartingPoint(getStartingPoint() <= 5 ? 5 : getStartingPoint() - 5);
		return getDuration() <= 0;
	}

	public Combatant getCreator()
	{
		return creator;
	}

	public void setCreator(Combatant creator)
	{
		this.creator = creator;
	}

	public int getDuration()
	{
		return duration;
	}

	public void setDuration(int duration)
	{
		this.duration = duration;
	}

	public int getStartingPoint()
	{
		return startingPoint;
	}

	public void setStartingPoint(int startingPoint)
	{
		this.startingPoint = startingPoint;
	}

	public EffectTypes getType()
	{
		return type;
	}

	public void setType(EffectTypes type)
	{
		this.type = type;
		switch (type)
		{
			case POISON:
				setName("Poison");
				break;
			case BLEEDING:
				setName("Bleeding");
				break;
			case BURNING:
				setName("Burning");
				break;
			case DISEASE:
				setName("Disease");
				break;
			case COLD:
				setName("Cold");
				break;
			case SHOCK:
				setName("Shock");
				break;
		}
	}

	@Override
	public Effect clone()
	{
		return new Effect(getCreator(), getStartingPoint(), getDuration(), getType());
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
