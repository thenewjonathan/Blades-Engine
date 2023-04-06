package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

/**
 * Created by tso6443 on 4/14/2015.
 */
public class EssenceOfHextor extends Ability implements IAbility
{
	public EssenceOfHextor(String name, String description, int cost, int duration, int levelRequired)
	{
		super(name, description, cost, duration, levelRequired);
	}

	@Override
	public boolean play(Combatant player, ArrayList<Combatant> targets)
	{
		if (targets.size() == 1 && super.play(player, targets))
		{
			Combatant c = targets.get(0);
			setModifier1(Dice.D10.getDie().roll());
			c.setCurrentPower(c.getCurrentPower() + getModifier1());
			c.setCurrentHitChance(c.getCurrentHitChance() + getModifier1());
			return true;
		}
		return false;
	}

	@Override
	public void remove(Combatant c)
	{
		super.remove(c);
		c.setCurrentPower(c.getCurrentPower() - getModifier1());
		c.setCurrentHitChance(c.getCurrentHitChance() - getModifier1());
	}
}
