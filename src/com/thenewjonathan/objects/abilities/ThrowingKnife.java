package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

public class ThrowingKnife extends Ability implements IAbility
{
	public ThrowingKnife(String name, String description, int cost, int duration, int levelRequired)
	{
		super(name, description, cost, duration, levelRequired);
	}

	@Override
	public boolean play(Combatant player, ArrayList<Combatant> targets)
	{
		if (targets.size() == 1 && super.play(player, targets))
		{
			Combatant c = targets.get(0);
			int damage = Dice.DD6.getDie().roll() + Dice.DD6.getDie().roll();
			c.takeDamage(player, damage, 0, 0, 0, 0, 0, 0);
			if(Dice.percentageRoll(35))
			{
				c.setStunned(true);
			}
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