package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

/**
 * Created by jon on 4/16/2015.
 */
public class CrookOfRao extends Ability implements IAbility
{
    public CrookOfRao(String name, String description, int cost, int duration, int levelRequired)
    {
        super(name, description, cost, duration, levelRequired);
    }

    @Override
    public boolean play(Combatant player, ArrayList<Combatant> targets)
    {
        return super.play(player, targets);
    }

    @Override
    public void remove(Combatant c)
    {
        super.remove(c);
        c.setAttackedThisRound(true);
    }
}
