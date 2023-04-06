package com.thenewjonathan.objects.spells.customspells;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.cards.superclasses.CustomSpell;
import com.thenewjonathan.objects.usables.Defender;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class ColdBlast extends CustomSpell implements ICard
{

	public ColdBlast(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged)
	{
		super(name, cardLife, cost, levelRequired, targetOther, ranged);
	}

	@Override
	public void play(Combatant caster, ArrayList<Combatant> targets)
	{
		if (targets.size() > 2)
		{
			CommonFunctions.say("size of targets array is " + targets.size() + " and should be 2 or less");
			return;
		}
		else
		{
			super.play(caster, targets);
		}
		int d4Rolls = caster.getLevel() > 12 ? 12 : caster.getLevel();
		for (int i = 0; i < targets.size(); i++)
		{
			int damage = 0;
			for (int j = 0; j < d4Rolls; j++)
			{
				damage += Dice.D4.getDie().roll();
			}
			Combatant target = targets.get(i);
			if (!target.isHasDefender())
			{
				target.takeDamage(caster, 0, 0, damage, 0, 0, 0, 0);
				setModifier1(Dice.DD4.getDie().roll() * 10);
				target.setAgility(target.getAgility() - getModifier1());
				target.updateStats();
				CommonFunctions.say(target + " took " + damage + " ice damage and agility was" +
						" reduced by " + getModifier1());
			}
			else
			{
				Defender d = target.getCurrentDefender();
				CommonFunctions.say(target + "'s defender, " + d + " took " +
						damage + " damage");
				if (d.takeDamage(damage))
				{
					target.removeDefender();
				}
			}
		}
	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
		combatant.setAgility(combatant.getAgility() + getModifier1());
		combatant.updateStats();
	}
}
