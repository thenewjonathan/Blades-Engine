package com.thenewjonathan.objects.cards.superclasses;

import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.usables.Card;
import com.thenewjonathan.objects.usables.Defender;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class SummonCard extends Card implements ICard
{
	private Defender defender;

	public SummonCard(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged,
	                  Defender defender)
	{
		super(name, cardLife, cost, levelRequired, targetOther, ranged);
		setDefender(defender);
	}

	@Override
	public void play(Combatant player, ArrayList<Combatant> targets)
	{
		if (targets.size() > 1)
		{
			CommonFunctions.say("Targets array is " + targets.size() + " and should be no more than 1");
			return;
		}
		else
		{
			super.play(player, targets);
		}
		Combatant target = targets.get(0);
		target.addDefender(getDefender());
		remove(target);
	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
	}

	public Defender getDefender()
	{
		return defender;
	}

	public void setDefender(Defender defender)
	{
		this.defender = defender;
	}
}
