package com.thenewjonathan.objects.cards.superclasses;

import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.usables.Card;

import java.util.ArrayList;

public class CustomCard extends Card implements ICard
{
	private int modifier1;
	private int modifier2;
	private int modifier3;

	public CustomCard(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged)
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

	public int getModifier1()
	{
		return modifier1;
	}

	public void setModifier1(int modifier1)
	{
		this.modifier1 = modifier1;
	}

	public int getModifier2()
	{
		return modifier2;
	}

	public void setModifier2(int modifier2)
	{
		this.modifier2 = modifier2;
	}

	public int getModifier3()
	{
		return modifier3;
	}

	public void setModifier3(int modifier3)
	{
		this.modifier3 = modifier3;
	}
}
