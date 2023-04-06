package com.thenewjonathan.objects.usables.customtraps;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ITrap;
import com.thenewjonathan.objects.usables.Trap;
import com.thenewjonathan.userinterface.CommonFunctions;

public class SpringTrap extends Trap implements ITrap
{

	public SpringTrap(String name, int level, int damage, int pDamage, int fDamage, int cDamage, int sDamage)
	{
		super(name, level, damage, pDamage, fDamage, cDamage, sDamage);
	}

	@Override
	public void executeTrap(Combatant target)
	{
		super.executeTrap(target);
		if ((target.getAgility() < 100) && Dice.percentageRoll(100 - target.getAgility()))
		{
			target.setStunned(true);
			CommonFunctions.say(target + " was stunned by the " + getName());
		}
	}
}
