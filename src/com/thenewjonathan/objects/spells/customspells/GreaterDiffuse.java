package com.thenewjonathan.objects.spells.customspells;

import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.cards.superclasses.CustomSpell;
import com.thenewjonathan.objects.usables.Effect;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class GreaterDiffuse extends CustomSpell implements ICard
{

	public GreaterDiffuse(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged)
	{
		super(name, cardLife, cost, levelRequired, targetOther, ranged);
	}

	@Override
	public void play(Combatant caster, ArrayList<Combatant> targets)
	{
		Combatant target = targets.get(0);
		if (targets.size() > 1)
		{
			CommonFunctions.say("Targets array is " + targets.size() + " and should be no more than 1");
			return;
		}
		else if (!target.hasEffects())
		{
			CommonFunctions.say(target + " has no effects in play");
			return;
		}
		else
		{
			super.play(caster, targets);
		}
		for (int i = 0; i < target.getCurrentEffects().size(); i++)
		{
			Effect e = target.getCurrentEffects().get(i);
			CommonFunctions.say(target.getCurrentEffects().remove(e) ? "Removed " + e : "Error when removing " + e);
		}
		remove(target);
	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
	}
}
