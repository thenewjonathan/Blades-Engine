package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

/**
 * Created by jon on 4/14/2015.
 */
public class Hurt extends Ability implements IAbility
{
	public Hurt(String name, String description, int cost, int duration, int levelRequired)
	{
		super(name, description, cost, duration, levelRequired);
	}

	@Override
	public boolean play(Combatant player, ArrayList<Combatant> targets)
	{
		if (targets.size() == 1 && super.play(player, targets))
		{
			Combatant c = targets.get(0);
			int damage = 0;
			for (int i = 0; i < Math.max(player.getLevel(), 9); i++)
			{
				damage += Dice.D4.getDie().roll();
			}
			c.takeDamage(player, damage, 0, 0, 0, 0, 0, 0);
			return true;
		}
		return false;
	}

	@Override
	public void remove(Combatant c)
	{
		super.remove(c);
	}
}
