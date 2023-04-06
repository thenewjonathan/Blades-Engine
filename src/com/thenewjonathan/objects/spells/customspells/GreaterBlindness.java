package com.thenewjonathan.objects.spells.customspells;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.cards.superclasses.CustomSpell;
import com.thenewjonathan.objects.usables.Defender;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class GreaterBlindness extends CustomSpell implements ICard
{

	public GreaterBlindness(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged)
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
		if (!target.isHasDefender() && Dice.percentageRoll(85 - (10 * (target.getCurrentLife() / 150))))
		{
			setModifier1(1);
			setModifier2(target.getAccuracy() / 2);
			setModifier3(target.getAgility() / 2);
			target.setAccuracy(target.getAccuracy() - getModifier2());
			target.setAgility(target.getAgility() - getModifier3());
			target.updateStats();
		}
		else
		{
			setModifier1(0);
			remove(target);
			Defender d = target.getCurrentDefender();
			CommonFunctions.say(!target.isHasDefender() ? "Greater Blindness failed" :
					"Spell blocked by defender, " + d + " and had no effect");
		}
	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
		if (getModifier1() == 1)
		{
			combatant.setAccuracy(combatant.getAccuracy() + getModifier2());
			combatant.setAgility(combatant.getAgility() + getModifier3());
			combatant.updateStats();
		}
	}
}
