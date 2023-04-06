package com.thenewjonathan.interfaces;

import com.thenewjonathan.heros.superclasses.Combatant;

import java.util.ArrayList;

public interface ICard
{
	void play(Combatant player, ArrayList<Combatant> targets);

	void remove(Combatant combatant);
}