package com.thenewjonathan.objects.spells.customspells;

import com.thenewjonathan.enums.Defenders;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.cards.superclasses.CustomSpell;

import java.util.ArrayList;

public class Battlements extends CustomSpell implements ICard
{
    public Battlements(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged)
    {
        super(name, cardLife, cost, levelRequired, targetOther, ranged);
    }

    @Override
    public void play(Combatant player, ArrayList<Combatant> targets)
    {
        super.play(player, targets);
        for(Combatant c : targets)
        {
            c.addDefender(Defenders.magicWall.getDefender());
        }
    }

    @Override
    public void remove(Combatant combatant)
    {
        super.remove(combatant);
    }
}
