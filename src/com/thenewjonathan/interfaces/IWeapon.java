package com.thenewjonathan.interfaces;

import com.thenewjonathan.heros.superclasses.Combatant;

public interface IWeapon
{
	void swing(Combatant attacker, Combatant target, boolean doubleDamage);
}
