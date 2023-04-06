package com.thenewjonathan.objects.spells.customspells;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.cards.superclasses.CustomSpell;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class FireStorm extends CustomSpell implements ICard
{

	public FireStorm(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged)
	{
		super(name, cardLife, cost, levelRequired, targetOther, ranged);
	}

	@Override
	public void play(Combatant caster, ArrayList<Combatant> targets)
	{
		if (targets.size() > 4)
		{
			CommonFunctions.say("Size of targets array is " + targets.size() + " and should be 4");
			return;
		}
		else
		{
			super.play(caster, targets);
		}
		setModifier1(150);
		for (int j = 0; j < targets.size(); j++)
		{
			Combatant target = targets.get(j);
			int damage = 0;
			for (int i = 0; i < caster.getLevel(); i++)
			{
				damage += Dice.D8.getDie().roll();
			}
			damage *= 0.6;
			target.takeDamage(caster, 0, 0, 0, damage, 0, 0, 0);
			target.setStrength(target.getStrength() - getModifier1());
			target.updateStats();
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
