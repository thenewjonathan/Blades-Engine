package com.thenewjonathan.objects.usables;

import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

/**
 *
 */
public class Ability
{
	private String name;
	private String description;
	private int cost;
	private boolean active;
	private int coolDown;
	private int duration;
	private int levelRequired;
	private int modifier1;
	private int modifier2;
	private int modifier3;


	public Ability(String name, String description, int cost, int duration, int levelRequired)
	{
		setName(name);
		setDescription(description);
		setCoolDown(0);
		setDuration(duration);
		setActive(false);
		setLevelRequired(levelRequired);
	}


	public boolean play(Combatant player, ArrayList<Combatant> targets)
	{
		if (player.getLevel() >= getLevelRequired())
		{
			CommonFunctions.say("Using ability " + getName());
			setActive(false);
			setCoolDown(3 + (cost / 5));
			for (int i = 0; i < targets.size(); i++)
			{
				Combatant c = targets.get(i);
				c.getAbilityEffects().add(getCopy());
			}
			return true;
		}
		else
		{
			CommonFunctions.say("You do not have the required level for that ability");
			return false;
		}
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof Ability)
		{
			return this.getName().equalsIgnoreCase(((Ability) obj).getName());
		}
		return false;
	}

	public void remove(Combatant c)
	{
		c.getAbilityEffects().remove(this);
	}

	public void doPhysicalDamage(Combatant attacker, Combatant target, int damage)
	{
		target.takeDamage(attacker, damage, 0, 0, 0, 0, 0, 0);
	}

	public Ability getCopy()
	{
		return new Ability(getName(), getDescription(), getCost(), getDuration(), getLevelRequired());
	}

	public boolean isActive()
	{
		return active;
	}

	public void setActive(boolean active)
	{
		this.active = active;
	}

	public int getCoolDown()
	{
		return coolDown;
	}

	public void setCoolDown(int coolDown)
	{
		this.coolDown = coolDown;
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


	public int getCost()
	{
		return cost;
	}


	public void setCost(int cost)
	{
		this.cost = cost;
	}


	public int getDuration()
	{
		return duration;
	}


	public void setDuration(int duration)
	{
		this.duration = duration;
	}


	public int getModifier1()
	{
		return modifier1;
	}


	public void setModifier1(int modifier1)
	{
		this.modifier1 = modifier1;
	}


	public int getModifier2()
	{
		return modifier2;
	}


	public void setModifier2(int modifier2)
	{
		this.modifier2 = modifier2;
	}


	public int getModifier3()
	{
		return modifier3;
	}


	public void setModifier3(int modifier3)
	{
		this.modifier3 = modifier3;
	}

	public void setLevelRequired(int levelRequired)
	{
		this.levelRequired = levelRequired;
	}

	public int getLevelRequired()
	{
		return levelRequired;
	}
}
