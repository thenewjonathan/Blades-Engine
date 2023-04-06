package com.thenewjonathan.objects.spells.customspells;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.enums.EffectTypes;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.cards.superclasses.CustomSpell;
import com.thenewjonathan.objects.usables.Effect;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class MetalStorm extends CustomSpell implements ICard
{

	public MetalStorm(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged)
	{
		super(name, cardLife, cost, levelRequired, targetOther, ranged);
	}

	@Override
	public void play(Combatant caster, ArrayList<Combatant> targets)
	{
		if (targets.size() > 3)
		{
			CommonFunctions.say("Size of targets array is " + targets.size() + " and should be 3");
			return;
		}
		else
		{
			super.play(caster, targets);
		}
		String output = "";
		for (int i = 0; i < targets.size(); i++)
		{
			int damage = Dice.D4.getDie().roll() + Dice.DD4.getDie().roll();
			Combatant target = targets.get(i);
			target.takeDamage(caster, damage, 0, 0, 0, 0, 0, 0);
			output += caster + "'s Metal Storm did " + damage + " to " + target;
			if (Dice.percentageRoll(35))
			{
				target.getCurrentEffects().add(new Effect(caster, 10, 2, EffectTypes.BLEEDING));
				output += "\n" + target + " is bleeding";
			}
		}
		CommonFunctions.say(output);
	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
	}
}
