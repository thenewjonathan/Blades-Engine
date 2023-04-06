package com.thenewjonathan.objects.spells.customspells;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.cards.superclasses.CustomSpell;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class Unsummon extends CustomSpell implements ICard
{

	public Unsummon(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged)
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
		if (!target.isHasDefender())
		{
			CommonFunctions.say(target + " has no defenders. Spell is wasted");
			return;
		}
		else
		{
			if (Dice.percentageRoll(20 + ((caster.getLevel() > 8 ? 8 : caster.getLevel() * 10))))
			{
				target.removeDefender();
			}
			else
			{
				CommonFunctions.say("Spell failed");
			}
		}
		remove(target);
	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
	}
}
