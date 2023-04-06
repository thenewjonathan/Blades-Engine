package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

public class WarCry extends Ability implements IAbility
{
	public WarCry(String name, String description, int cost, int duration, int levelRequired)
	{
		super(name, description, cost, duration, levelRequired);
	}

	@Override
	public boolean play(Combatant player, ArrayList<Combatant> targets)
	{
		if (targets.size() > 0 && super.play(player, targets))
		{
			int mod = 0;
			for (int i = 0; i < Math.min(player.getLevel(), 4); i++)
			{
				mod += Dice.D4.getDie().roll();
			}
			setModifier1(mod);
			for(Combatant c : targets)
			{
				c.setStrength(c.getStrength() + getModifier1());
				c.setModifiers();
			}
			return true;
		}
		return false;
	}

	@Override
	public void remove(Combatant c)
	{
		super.remove(c);
		c.setStrength(c.getStrength() - getModifier1());
		c.setModifiers();
	}
}