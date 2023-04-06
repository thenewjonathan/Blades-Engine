package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;
import com.thenewjonathan.objects.usables.Weapon;

import java.util.ArrayList;

public class JumpAttack extends Ability implements IAbility
{
	public JumpAttack(String name, String description, int cost, int duration, int levelRequired)
	{
		super(name, description, cost, duration, levelRequired);
	}

	@Override
	public boolean play(Combatant player, ArrayList<Combatant> targets)
	{
		if (targets.size() == 1 && player.getWeaponsInPlay().size() >= 2 && super.play(player, targets))
		{
			Combatant c = targets.get(0);
			player.setIgnoreDefenders(true);
			for(Weapon w : player.getWeaponsInPlay())
			{
				w.swing(player, c, true);
			}
			if(Dice.percentageRoll(20))
			{
				c.setStunned(true);
			}
			player.setIgnoreDefenders(false);
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