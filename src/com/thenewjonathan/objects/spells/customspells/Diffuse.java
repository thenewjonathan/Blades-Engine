package com.thenewjonathan.objects.spells.customspells;

import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.cards.superclasses.CustomSpell;
import com.thenewjonathan.objects.usables.Effect;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class Diffuse extends CustomSpell implements ICard
{

	public Diffuse(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged)
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
		}
		else
		{
			super.play(caster, targets);
		}
		boolean somethingRemoved = false;
		for (int i = 0; i < target.getCurrentEffects().size(); i++)
		{
			Effect e = target.getCurrentEffects().get(i);
			if (e.getCreator().getLevel() <= 7)
			{
				if (target.getCurrentEffects().remove(e))
				{
					CommonFunctions.say(e + " removed");
					somethingRemoved = true;
				}
				else
				{
					CommonFunctions.say("Error removing " + e);
				}
			}
		}
		CommonFunctions.say(somethingRemoved ? "" : "No effects removed");
		remove(target);
	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
	}
}
