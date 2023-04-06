package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

public class Berserk extends Ability implements IAbility
{
	public Berserk(String name, String description, int cost, int duration, int levelRequired)
	{
		super(name, description, cost, duration, levelRequired);
	}

	@Override
	public boolean play(Combatant player, ArrayList<Combatant> targets)
	{
		if (targets.size() == 1 && targets.get(0).equals(player) && super.play(player, targets))
		{
			player.setAttackMod(player.getAttackMod() + 1);
			setModifier1((int)(player.getCurrentPower() * 0.5));
			player.setCurrentPower(player.getCurrentPower() + getModifier1());
			return true;
		}
		return false;
	}

	@Override
	public void remove(Combatant c)
	{
		super.remove(c);
		c.updateStats();
	}
}