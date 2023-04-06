package com.thenewjonathan.objects.spells.customspells;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.cards.superclasses.CustomSpell;
import com.thenewjonathan.objects.usables.Defender;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class SummonMinotaur extends CustomSpell implements ICard
{

	public SummonMinotaur(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged)
	{
		super(name, cardLife, cost, levelRequired, targetOther, ranged);
	}

	@Override
	public void play(Combatant caster, ArrayList<Combatant> targets)
	{
		super.play(caster, targets);
		int damage = 0;
		for (int i = 0; i < caster.getLevel(); i++)
		{
			damage += Dice.D6.getDie().roll();
		}
		Combatant target = targets.get(0);
		if (!target.isHasDefender())
		{
			target.takeDamage(caster, damage, 0, 0, 0, 0, 0, 0);
			if (Dice.percentageRoll(35))
			{
				target.setStunned(true);
				setModifier1(1);
			}
			else
			{
				setModifier1(0);
			}
		}
		else
		{
			Defender d = target.getCurrentDefender();
			if (d.takeDamage(damage * 2))
			{
				target.removeDefender();
			}
			else
			{
				CommonFunctions.say(d + " took " + damage * 2 + " damage");
			}
		}
	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
	}
}