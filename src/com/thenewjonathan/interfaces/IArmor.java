package com.thenewjonathan.interfaces;

import com.thenewjonathan.heros.superclasses.Combatant;

public interface IArmor
{
	void applyBonus(Combatant c);

	void removeBonus(Combatant c);
}
