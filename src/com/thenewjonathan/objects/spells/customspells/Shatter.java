package com.thenewjonathan.objects.spells.customspells;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.cards.superclasses.CustomSpell;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class Shatter extends CustomSpell implements ICard
{

	public Shatter(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged)
	{
		super(name, cardLife, cost, levelRequired, targetOther, ranged);
	}

	@Override
	public void play(Combatant caster, ArrayList<Combatant> targets)
	{
		if (targets.size() > 1)
		{
			CommonFunctions.say("Targets array is " + targets.size() + " and should be no more than 1");
			return;
		}
		else
		{
			super.play(caster, targets);
		}
		int damage = 0;
		Combatant target = targets.get(0);
		for (int i = 0; i < caster.getLevel(); i++)
		{
			damage += Dice.DD8.getDie().roll();
		}
		target.takeDamage(caster, damage, 0, 0, 0, 0, 0, 0);
		if (target.isHasDefender())
		{
			CommonFunctions.say(target.getCurrentDefenders().get(0) + " blocked the spell and it had no effect");
		}
		else
		{
			if (!target.isDead() && Dice.percentageRoll(30))
			{
				CommonFunctions.say(target + " was shattered!");
				target.setCurrentLife(0);
				target.setShattered(true);
				target.setDead(true);
			}
			else
			{
				if (!target.isDead())
				{
					CommonFunctions.say("Shatter failed but " + damage + " physical damage was inflicted");
				}
			}
		}
	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
	}
}
