package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

public class EdoirasWisdom extends Ability implements IAbility
{
	public EdoirasWisdom(String name, String description, int cost, int duration, int levelRequired)
	{
		super(name, description, cost, duration, levelRequired);
	}

	@Override
	public boolean play(Combatant player, ArrayList<Combatant> targets)
	{
		if(targets.size() == 1 && super.play(player, targets))
		{
			Combatant c = targets.get(0);
			c.setCurrentPower(c.getCurrentPower() + 5);
			c.setAccuracyMod(c.getAccuracyMod() + 5);
			return true;
		}
		return false;
	}

	@Override
	public void remove(Combatant c)
	{
		super.remove(c);
		c.setCurrentPower(c.getCurrentPower() - 5);
		c.setAccuracyMod(c.getAccuracyMod() - 5);
	}
}