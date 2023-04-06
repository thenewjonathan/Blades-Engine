package com.thenewjonathan.objects.actions;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.enums.Genders;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.objects.cards.superclasses.Action;
import com.thenewjonathan.objects.usables.Weapon;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;
import java.util.Random;

public class Disarm extends Action
{
	Weapon weaponToRemove;
	Random rand = new Random();

	/**
	 *
	 * @param name
	 * @param cardLife
	 * @param cost
	 * @param levelRequired
	 * @param targetOther
	 * @param ranged
	 */
	public Disarm(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged)
	{
		super(name, cardLife, cost, levelRequired, targetOther, ranged);
	}

	@Override
	public void play(Combatant attacker, ArrayList<Combatant> targets)
	{
		Combatant target = targets.get(0);
		if (!target.isHasDefender() && targets.size() > 1)
		{
			CommonFunctions.say(target.isHasDefender() ? "Defender is blocking your path to the target" :
					"Targets array is " + targets.size() + " and should be no more than 1");
			return;
		}
		else
		{
			super.play(attacker, targets);
		}
		if (!target.isUnarmed() && Dice.percentageRoll(
				((attacker.getWeaponProficiencyMod() * 10) + (attacker.getCurrentPower() * 10)) /
						(target.getWeaponProficiencyMod() * 10) + (target.getCurrentPower() * 10)))
		{
			if (target.getWeaponsInPlay().size() > 1)
			{
				weaponToRemove = target.getWeaponsInPlay().get(rand.nextInt(target.getWeaponsInPlay().size()));
			}
			else
			{
				weaponToRemove = target.getWeaponsInPlay().get(0);
			}
			target.dropWeapon(weaponToRemove);
			CommonFunctions.say(target + " dropped " +
					(target.getGender().compareTo(Genders.MALE) == 0 ? " his " : " her ") +
					weaponToRemove);
		}
		else if (target.isUnarmed())
		{
			CommonFunctions.say(target + " is unarmed... no effect");
		}
		else
		{
			CommonFunctions.say("Disarm failed");
		}
	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
		combatant.pickUpWeapon(weaponToRemove);
		combatant.setAttackedThisRound(true);
	}
}
