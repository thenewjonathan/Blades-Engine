package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

/**
 * Created by jon on 4/15/2015.
 */
public class Reason extends Ability implements IAbility
{
	public Reason(String name, String description, int cost, int duration, int levelRequired)
	{
		super(name, description, cost, duration, levelRequired);
	}

	@Override
	public boolean play(Combatant player, ArrayList<Combatant> targets)
	{
		if (targets.size() == 1 && super.play(player, targets))
		{
			Combatant c = targets.get(0);
			c.addIllegalTarget(player);
			return true;
		}
		return false;
	}

	@Override
	public void remove(Combatant c)
	{
		super.remove(c);
		//TODO Need to figure out a way to access the initial target of this spell
		c.getIllegalTargets().clear();
	}
}
