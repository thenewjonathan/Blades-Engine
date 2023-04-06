package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

public class FocusedStrike extends Ability implements IAbility
{
	public FocusedStrike(String name, String description, int cost, int duration, int levelRequired)
	{
		super(name, description, cost, duration, levelRequired);
	}

	@Override
	public boolean play(Combatant player, ArrayList<Combatant> targets)
	{
		if (targets.size() == 1 && targets.get(0).equals(player) && super.play(player, targets))
		{
			setModifier1(player.getAgility());
			player.setAgility(getModifier1() - 100);
			player.setAccuracy(player.getAccuracy() + 100);
			return true;
		}
		return false;
	}

	@Override
	public void remove(Combatant c)
	{
		super.remove(c);
		c.setAccuracy(c.getAccuracy() - 100);
		c.setAgility(getModifier1());
	}
}