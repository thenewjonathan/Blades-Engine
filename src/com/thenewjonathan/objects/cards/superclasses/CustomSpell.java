package com.thenewjonathan.objects.cards.superclasses;

import com.thenewjonathan.heros.superclasses.Combatant;

import java.util.ArrayList;

public class CustomSpell extends CustomCard
{

	public CustomSpell(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged)
	{
		super(name, cardLife, cost, levelRequired, targetOther, ranged);
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
