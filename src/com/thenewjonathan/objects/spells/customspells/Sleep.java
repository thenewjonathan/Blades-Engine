package com.thenewjonathan.objects.spells.customspells;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.cards.superclasses.CustomSpell;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class Sleep extends CustomSpell implements ICard
{

	public Sleep(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged)
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
		if (Dice.percentageRoll(65 + ((caster.getLevel() - target.getLevel()) * 10)))
		{
			target.setStunned(true);
			CommonFunctions.say(target + " is asleep");
		}
		else
		{
			CommonFunctions.say("Sleep failed");
		}
	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
		combatant.setStunned(false);
		CommonFunctions.say(combatant + " has awoken");
	}
}