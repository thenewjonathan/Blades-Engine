package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

public class RaosBlessing extends Ability implements IAbility
{
	public RaosBlessing(String name, String description, int cost, int duration, int levelRequired)
	{
		super(name, description, cost, duration, levelRequired);
	}

	@Override
	public boolean play(Combatant player, ArrayList<Combatant> targets)
	{
		if(targets.size() == 1 && super.play(player, targets))
		{
			Combatant c = targets.get(0);
			c.setCurrentDefense(c.getCurrentDefense() + 5);
			return true;
		}
		return false;
	}

	@Override
	public void remove(Combatant c)
	{
		super.remove(c);
		c.setCurrentDefense(c.getCurrentDefense() - 5);
	}
}


