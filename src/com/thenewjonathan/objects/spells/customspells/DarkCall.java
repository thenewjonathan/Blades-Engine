package com.thenewjonathan.objects.spells.customspells;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.cards.superclasses.CustomSpell;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class DarkCall extends CustomSpell implements ICard
{

	public DarkCall(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged)
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
		Combatant target = targets.get(0);
		if (!target.isHasDefender() && Dice.percentageRoll(85 - (10 * (target.getCurrentLife() / 50))))
		{
			target.setCurrentLife(0);
			target.setDead(true);
		}
		else if (target.isHasDefender())
		{
			if (Dice.percentageRoll(85 - (10 * (target.getCurrentDefenders().get(0).getLife() / 50))))
			{
				target.removeDefender();
			}
			else
			{
				CommonFunctions.say("Spell blocked by " +
						target.getCurrentDefender() + " and failed");
			}
		}
		else
		{
			CommonFunctions.say("Dark Call failed");
		}
		remove(target);
	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
	}
}
