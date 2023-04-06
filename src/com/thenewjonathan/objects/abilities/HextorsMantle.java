package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

/**
 * Created by tso6443 on 4/14/2015.
 */
public class HextorsMantle extends Ability implements IAbility
{
	public HextorsMantle(String name, String description, int cost, int duration, int levelRequired)
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
			for (int i = 0; i < 12; i++)
			{
				damage += Dice.D12.getDie().roll();
			}
			if (damage >= c.getCurrentLife())
			{
				doPhysicalDamage(player, c, damage);
			}
			else
			{
				CommonFunctions.say("Hextor's mantle demands a life. Since you failed to " +
						"provide one, you will pay with your own!");
				player.takeDamage(player, player.getCurrentLife(), 0, 0, 0, 0, 0, 0);
			}
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
