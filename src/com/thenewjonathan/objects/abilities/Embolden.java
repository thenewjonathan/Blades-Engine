package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

/**
 * Increase the attack power of ally for one turn
 */
public class Embolden extends Ability implements IAbility
{
	private int modifier;

	public Embolden(String name, String description, int cost, int duration, int levelRequired)
	{
		super(name, description, cost, duration, levelRequired);
	}

	@Override
	public boolean play(Combatant player, ArrayList<Combatant> targets)
	{
		if ((targets.size() == 1) && super.play(player, targets))
		{
			modifier = Dice.D4.getDie().roll();
			Combatant c = targets.get(0);
			c.setCurrentPower(c.getCurrentPower() + 1);
			return true;
		}
		return false;
	}

	@Override
	public void remove(Combatant c)
	{
		super.remove(c);
		c.setCurrentPower(c.getCurrentPower() - 1);
	}
}
