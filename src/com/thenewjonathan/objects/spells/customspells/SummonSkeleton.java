package com.thenewjonathan.objects.spells.customspells;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.cards.superclasses.CustomSpell;
import com.thenewjonathan.objects.usables.Defender;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class SummonSkeleton extends CustomSpell implements ICard
{

	public SummonSkeleton(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged)
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
		int damage = 0;
		for (int i = 0; i < caster.getLevel(); i++)
		{
			damage += Dice.D4.getDie().roll();
		}
		if (!target.isHasDefender())
		{
			setModifier1(50 * caster.getLevel());
			target.takeDamage(caster, damage, 0, 0, 0, 0, 0, 0);
			target.setWisdom(target.getWisdom() - getModifier1());
			CommonFunctions.say("Defense reduced by " + getModifier1() / 50);
			target.updateStats();
		}
		else
		{
			super.remove(target);
			Defender d = target.getCurrentDefender();
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
		combatant.setWisdom(combatant.getWisdom() + getModifier1());
		combatant.updateStats();
	}
}
