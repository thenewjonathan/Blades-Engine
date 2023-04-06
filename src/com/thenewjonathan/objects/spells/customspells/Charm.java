package com.thenewjonathan.objects.spells.customspells;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.cards.superclasses.CustomSpell;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class Charm extends CustomSpell implements ICard
{
	private Combatant target;

	public Charm(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged)
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
			// do something here to set the target the charmed combatant is to attack
			target.attack(getTarget());
		}
		else
		{
			CommonFunctions.say("Charm did not work");
		}
		remove(target);
	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
	}

	public Combatant getTarget()
	{
		return target;
	}

	public void setTarget(Combatant target)
	{
		this.target = target;
	}
}
