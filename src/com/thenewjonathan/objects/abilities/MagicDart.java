package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

/**
 * Created by tso6443 on 4/14/2015.
 */
public class MagicDart extends Ability implements IAbility
{
	public MagicDart(String name, String description, int cost, int duration, int levelRequired)
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
			for (int i = 0; i < Math.max(3, player.getLevel()); i++)
			{
				damage += Dice.DD4.getDie().roll();
			}
			doPhysicalDamage(player, c, damage);
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
