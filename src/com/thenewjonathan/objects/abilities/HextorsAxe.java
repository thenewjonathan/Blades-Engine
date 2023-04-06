package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

/**
 * Created by tso6443 on 4/14/2015.
 */
public class HextorsAxe extends Ability implements IAbility
{
	public HextorsAxe(String name, String description, int cost, int duration, int levelRequired)
	{
		super(name, description, cost, duration, levelRequired);
	}

	@Override
	public boolean play(Combatant player, ArrayList<Combatant> targets)
	{
		if (targets.size() == 1 && super.play(player, targets))
		{
			Combatant c = targets.get(0);
			doPhysicalDamage(player, c, Dice.D12.getDie().roll());
		}
		return false;
	}

	@Override
	public void remove(Combatant c)
	{
		super.remove(c);
	}
}
