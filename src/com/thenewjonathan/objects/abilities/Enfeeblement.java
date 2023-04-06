package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;
import com.thenewjonathan.objects.usables.Defender;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class Enfeeblement extends Ability implements IAbility
{

	public Enfeeblement(String name, String description, int cost, int duration, int levelRequired)
	{
		super(name, description, cost, duration, levelRequired);
	}

	@Override
	public boolean play(Combatant attacker, ArrayList<Combatant> targets)
	{
		if (targets.size() == 1 && super.play(attacker, targets))
		{
			Combatant target = targets.get(0);
			if (target.isHasDefender())
			{
				Defender d = target.getCurrentDefender();
				CommonFunctions.say("Ability was blocked by " + target + "'s defender, " + d + " and had no effect");
			}
			else
			{
				setModifier1(attacker.getLevel() * 50);
				target.setStrength(target.getStrength() - getModifier1());
				target.setWisdom(target.getWisdom() - getModifier1());
				target.updateStats();
				CommonFunctions.say(target + "'s defense and attack power reduced by " + attacker.getLevel());
			}
			return true;
		}
		return false;
	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
		combatant.setStrength(combatant.getStrength() + getModifier1());
		combatant.setWisdom(combatant.getWisdom() + getModifier1());
		combatant.updateStats();
	}
}
