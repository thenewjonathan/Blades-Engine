package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;
import com.thenewjonathan.objects.usables.Weapon;

import java.util.ArrayList;

public class TipOfTheBlade extends Ability implements IAbility
{
	public TipOfTheBlade(String name, String description, int cost, int duration, int levelRequired)
	{
		super(name, description, cost, duration, levelRequired);
	}

	@Override
	public boolean play(Combatant player, ArrayList<Combatant> targets)
	{
		if (targets.size() == 1 && super.play(player, targets))
		{
			Combatant c = targets.get(0);
			for(Weapon w : player.getWeaponsInPlay())
			{
				for (int i = 0; i < 3; i++)
				{
					w.swing(player, c, false);
				}
			}
			c.setStunned(true);
			return true;
		}
		return false;
	}

	@Override
	public void remove(Combatant c)
	{
		super.remove(c);
		c.setStunned(false);
	}
}