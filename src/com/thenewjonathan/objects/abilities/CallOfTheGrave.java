package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

public class CallOfTheGrave extends Ability implements IAbility
{
	public CallOfTheGrave(String name, String description, int cost, int duration, int levelRequired)
	{
		super(name, description, cost, duration, levelRequired);
	}

	@Override
	public boolean play(Combatant player, ArrayList<Combatant> targets)
	{
		if (targets.size() == 1 && super.play(player, targets))
		{
			Combatant c = targets.get(0);

			setModifier1(Math.min(200, c.getStrength()));
			setModifier2(Math.min(200, c.getAgility()));
			setModifier3(Math.min(200, c.getConstitution()));

			c.setStrength(c.getStrength() - getModifier1());
			c.setAgility(c.getAgility() - getModifier2());
			c.setConstitution(c.getConstitution() - getModifier3());

			if(c.getStrength() == 0 || c.getAgility() == 0 || c.getConstitution() == 0)
			{
				c.setDead(true);
				player.setCurrentLife(player.getMaxLife());
			}
			return true;
		}
		return false;
	}

	@Override
	public void remove(Combatant c)
	{
		super.remove(c);
		c.setStrength(c.getStrength() + getModifier1());
		c.setAgility(c.getAgility() + getModifier2());
		c.setConstitution(c.getConstitution() + getModifier3());
	}
}