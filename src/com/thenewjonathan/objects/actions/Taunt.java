package com.thenewjonathan.objects.actions;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.cards.superclasses.Action;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class Taunt extends Action implements ICard
{


	public Taunt(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged)
	{
		super(name, cardLife, cost, levelRequired, targetOther, ranged);
	}

	@Override
	public void play(Combatant player, ArrayList<Combatant> targets)
	{
		if (targets.size() != 1)
		{
			CommonFunctions.say("Targets array is " + targets.size() + " and can only be 1");
		}
		else
		{
			super.play(player, targets);
			Combatant target = targets.get(0);
			setModifier1(Dice.DD4.getDie().roll() * 10);
			target.setAccuracy(target.getAccuracy() - getModifier1());
		}
	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
		combatant.setAccuracy(combatant.getAccuracy() + getModifier1());
	}
}
