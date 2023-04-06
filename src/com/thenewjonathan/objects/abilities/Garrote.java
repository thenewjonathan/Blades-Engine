package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

public class Garrote extends Ability implements IAbility
{
	public Garrote(String name, String description, int cost, int duration, int levelRequired)
	{
		super(name, description, cost, duration, levelRequired);
	}

	@Override
	public boolean play(Combatant player, ArrayList<Combatant> targets)
	{
		return (targets.size() == 1 && super.play(player, targets));
	}

	@Override
	public void remove(Combatant c)
	{
		super.remove(c);
		c.setAttackedThisRound(true);
	}
}