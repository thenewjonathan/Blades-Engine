package com.thenewjonathan.objects.actions;

import com.thenewjonathan.enums.WeaponTypes;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.admin.Die;
import com.thenewjonathan.objects.cards.superclasses.Action;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class SoftSpot extends Action implements ICard
{

	public SoftSpot(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged)
	{
		super(name, cardLife, cost, levelRequired, targetOther, ranged);
	}

	@Override
	public void play(Combatant attacker, ArrayList<Combatant> targets)
	{
		if (targets.size() > 1)
		{
			CommonFunctions.say("Targets array is " + targets.size() + " and should be no more than 1");
		}
		else if ((attacker.getWeaponsInPlay().size() == 1) &&
				attacker.getWeaponsInPlay().get(0).getType().equals(WeaponTypes.STAFF))
		{
			super.play(attacker, targets);
			Combatant target = targets.get(0);
			Die die = attacker.getWeaponsInPlay().get(0).getDieToRoll();
			int damage = die.roll() + die.roll() + die.roll() + attacker.getCurrentPower();
			if (target.isHasDefender())
			{
				if (target.getCurrentDefender().takeDamage(damage))
				{
					target.removeDefender();
				}
				else
				{
					CommonFunctions.say(target.getCurrentDefender() + " took " + damage +
							" damage");
				}
			}
			else
			{
				target.takeDamage(attacker, damage, 0, 0, 0, 0, 0, 0);
				target.setStunned(true);
				CommonFunctions.say(target + " took " + damage + " damage and is stunned");
			}
		}
		else
		{
			CommonFunctions.say("You must have a staff equiped to use this action");
		}
	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
		combatant.setStunned(false);
	}
}
