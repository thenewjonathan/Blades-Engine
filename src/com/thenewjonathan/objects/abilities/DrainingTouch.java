package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;
import com.thenewjonathan.objects.usables.Defender;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class DrainingTouch extends Ability implements IAbility
{

	public DrainingTouch(String name, String description, int cost, int duration, int levelRequired)
	{
		super(name, description, cost, duration, levelRequired);
	}

	@Override
	public boolean play(Combatant attacker, ArrayList<Combatant> targets)
	{
		if (targets.size() == 1 && super.play(attacker, targets))
		{
			int damage = 0;
			for (int i = 0; i < attacker.getLevel(); i++)
			{
				damage += Dice.D4.getDie().roll();
			}
			Combatant target = targets.get(0);
			if (!target.isHasDefender())
			{
				damage = Math.max(damage, target.getCurrentLife());
				target.takeDamage(attacker, 0, 0, 0, 0, 0, 0, damage);
				CommonFunctions.say(target.getName() + " took " + damage + " and " + attacker.getName() + " gained it");
			}
			else
			{
				Defender d = target.getCurrentDefender();
				damage = Math.max(target.getCurrentDefender().getLife(), damage);
				CommonFunctions.say(d + " blocked the spell. Drained " + damage + " life from the defender");
				if (d.takeDamage(damage))
				{
					target.removeDefender();
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
	}
}
