package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.enums.EffectTypes;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;
import com.thenewjonathan.objects.usables.Effect;

import java.util.ArrayList;

/**
 * Created by jon on 4/14/2015.
 */
public class SummonDrake extends Ability implements IAbility
{
	public SummonDrake(String name, String description, int cost, int duration, int levelRequired)
	{
		super(name, description, cost, duration, levelRequired);
	}

	@Override
	public boolean play(Combatant player, ArrayList<Combatant> targets)
	{
		if (super.play(player, targets))
		{
			Combatant c = targets.get(0);
			c.addEffect(new Effect(player, 10, 2, EffectTypes.BURNING));
			int damage = 0;
			for (int i = 0; i < player.getLevel(); i++)
			{
				damage += Dice.D4.getDie().roll();
			}
			c.takeDamage(player, 0, 0, 0, damage, 0, 0, 0);
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
