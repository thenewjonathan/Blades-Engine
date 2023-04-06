package com.thenewjonathan.objects.cards.superclasses;

import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.objects.usables.Defender;

import java.util.ArrayList;


public class SummonSpell extends SummonCard
{

	public SummonSpell(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged,
	                   Defender defender)
	{
		super(name, cardLife, cost, levelRequired, targetOther, ranged, defender);
	}

	@Override
	public void play(Combatant player, ArrayList<Combatant> targets)
	{
		super.play(player, targets);
	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
	}
}
