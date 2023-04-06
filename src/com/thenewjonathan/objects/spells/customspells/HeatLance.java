package com.thenewjonathan.objects.spells.customspells;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.cards.superclasses.CustomSpell;
import com.thenewjonathan.objects.usables.Defender;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class HeatLance extends CustomSpell implements ICard
{

	public HeatLance(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged)
	{
		super(name, cardLife, cost, levelRequired, targetOther, ranged);
	}

	@Override
	public void play(Combatant caster, ArrayList<Combatant> targets)
	{
		if (targets.size() > 1)
		{
			CommonFunctions.say("size of targets array is " + targets.size() + " and should be 1");
			return;
		}
		else
		{
			super.play(caster, targets);
		}
		int d6Rolls = caster.getLevel() > 12 ? 12 : caster.getLevel();
		Combatant target = targets.get(0);
		int damage = 0;
		for (int j = 0; j < d6Rolls; j++)
		{
			damage += Dice.D6.getDie().roll();
		}
		if (!target.isHasDefender())
		{
			target.takeDamage(caster, 0, 0, 0, damage, 0, 0, 0);
			setModifier1(Dice.DD4.getDie().roll() * 10);
			target.setStrength(target.getStrength() - getModifier1());
			target.updateStats();
			CommonFunctions.say(target + " took " + damage + " fire damage and agility was" +
					" reduced by " + getModifier1());
		}
		else
		{
			Defender d = target.getCurrentDefender();
			CommonFunctions.say(target + "'s defender, " + d + " took " + damage +
					" damage");
			if (d.takeDamage(damage))
			{
				target.removeDefender();
			}
		}
	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
		combatant.setStrength(combatant.getStrength() + getModifier1());
		combatant.updateStats();
	}
}
