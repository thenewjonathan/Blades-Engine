package com.thenewjonathan.objects.spells.customspells;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.cards.superclasses.CustomSpell;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class GreaterEnfeeblement extends CustomSpell implements ICard
{

	public GreaterEnfeeblement(String name, int cardLife, int cost, int levelRequired, boolean targetOther,
	                           boolean ranged)
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
		if (!target.isHasDefender() && Dice.percentageRoll(85 - (10 * (target.getCurrentLife() / 100))))
		{
			setModifier1(1);
			setModifier2(target.getStrength() / 2);
			setModifier3(target.getAgility() / 2);
			target.setStrength(target.getStrength() - getModifier2());
			target.setAgility(target.getAgility() - getModifier3());
			target.updateStats();
		}
		else
		{
			setModifier1(0);
			remove(target);
			CommonFunctions.say(!target.isHasDefender() ? "Greater Enfeeblement failed" :
					"Spell blocked by defender, " + target.getCurrentDefender() + " and had no effect");
		}
	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
		if (getModifier1() == 1)
		{
			combatant.setStrength(combatant.getStrength() + getModifier2());
			combatant.setAgility(combatant.getAgility() + getModifier3());
			combatant.updateStats();
		}
	}
}
