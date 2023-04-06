package com.thenewjonathan.interfaces;

import com.thenewjonathan.heros.superclasses.Combatant;

import java.util.ArrayList;

public interface IAbility
{
	boolean play(Combatant player, ArrayList<Combatant> targets);

	void remove(Combatant combatant);
}
