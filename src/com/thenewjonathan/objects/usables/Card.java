package com.thenewjonathan.objects.usables;

import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class Card implements ICard
{
	private String name;
	private int cardLife;
	private int maxCardLife;
	private int cost;
	private int levelRequired;
	private boolean targetOther;
	private boolean ranged;

	public Card(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged)
	{
		setName(name);
		setCardLife(cardLife);
		setMaxCardLife(cardLife);
		setCost(cost);
		setLevelRequired(levelRequired);
		setTargetOther(targetOther);
		setRanged(ranged);
	}

	@Override
	public String toString()
	{
		return getName();
	}

	public void play(Combatant owner, ArrayList<Combatant> targets)
	{
		CommonFunctions.say("Playing " + getName());
		owner.takeStamina(getCost());
		owner.getCardsInHand().remove(this);
		owner.getCardsInDiscard().add(this);
		for (Combatant c : targets)
		{
			c.getCardsInPlay().add(this);
		}
	}

	@Override
	public Card clone()
	{
		return new Card(name, cardLife, cost, levelRequired, targetOther, ranged);
	}

	public void remove(Combatant combatant)
	{
		CommonFunctions.say(getName() + " removed");
		combatant.getCardsInPlay().remove(this);
		setCardLife(getMaxCardLife());
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getCardLife()
	{
		return cardLife;
	}

	public void setCardLife(int cardLife)
	{
		this.cardLife = cardLife;
	}

	public int getMaxCardLife()
	{
		return maxCardLife;
	}

	public void setMaxCardLife(int maxCardLife)
	{
		this.maxCardLife = maxCardLife;
	}

	public int getCost()
	{
		return cost;
	}

	public void setCost(int cost)
	{
		this.cost = cost;
	}

	public int getLevelRequired()
	{
		return levelRequired;
	}

	public void setLevelRequired(int levelRequired)
	{
		this.levelRequired = levelRequired;
	}

	public boolean isTargetOther()
	{
		return targetOther;
	}

	public void setTargetOther(boolean targetOther)
	{
		this.targetOther = targetOther;
	}

	public boolean isRanged()
	{
		return ranged;
	}

	public void setRanged(boolean ranged)
	{
		this.ranged = ranged;
	}

}
