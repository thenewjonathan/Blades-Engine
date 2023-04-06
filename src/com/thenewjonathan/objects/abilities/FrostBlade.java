package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.enums.EffectTypes;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;
import com.thenewjonathan.objects.usables.Effect;
import com.thenewjonathan.objects.usables.Weapon;

import java.util.ArrayList;

public class FrostBlade extends Ability implements IAbility
{
	public FrostBlade(String name, String description, int cost, int duration, int levelRequired)
	{
		super(name, description, cost, duration, levelRequired);
	}

	@Override
	public boolean play(Combatant player, ArrayList<Combatant> targets)
	{
		if (targets.size() == 1 && player.hasWeapon() && super.play(player, targets))
		{
			Combatant c = targets.get(0);
			for(Weapon w : player.getWeaponsInPlay())
			{
				w.swing(player, c, false);
				int additionalDamage = 0;
				for (int i = 0; i < player.getLevel(); i++)
				{
					additionalDamage += Dice.D4.getDie().roll();
				}
				c.takeDamage(player, 0, 0, additionalDamage, 0, 0, 0, 0);
				setModifier1(Dice.DD4.getDie().roll() * 10);
				c.setAgility(c.getAgility() - getModifier1());
				c.updateStats();
				c.addEffect(new Effect(player, 5, 1, EffectTypes.COLD));
			}
			return true;
		}
		return false;
	}

	@Override
	public void remove(Combatant c)
	{
		super.remove(c);
		c.setAgility(c.getAgility() + getModifier1());
		c.updateStats();
	}
}