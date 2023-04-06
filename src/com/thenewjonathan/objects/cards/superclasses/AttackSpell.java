package com.thenewjonathan.objects.cards.superclasses;

import com.thenewjonathan.enums.DamageTypes;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.objects.admin.Die;
import com.thenewjonathan.objects.usables.Effect;

import java.util.ArrayList;

public class AttackSpell extends AttackCard
{

	public AttackSpell(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged,
	                   Die dieToRoll, int dieMultiplier, int maxLevel, boolean perLevel, DamageTypes typeOfDamage,
	                   ArrayList<Effect> effects, int maxTargets, boolean stun, int stunChance, boolean ignoreDefender)
	{
		super(name, cardLife, cost, levelRequired, targetOther, ranged, dieToRoll, dieMultiplier, maxLevel, perLevel,
				typeOfDamage, effects, maxTargets, stun, stunChance, ignoreDefender);
	}

	@Override
	public void play(Combatant player, ArrayList<Combatant> targets)
	{
		super.play(player, targets);
	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
	}
}

