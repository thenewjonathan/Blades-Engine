package com.thenewjonathan.objects.abilities;/**
 * Created by jon on 4/20/2015.
 */

import com.thenewjonathan.enums.Traps;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

public class Ensnare extends Ability implements IAbility
{
    public Ensnare(String name, String description, int cost, int duration, int levelRequired)
    {
        super(name, description, cost, duration, levelRequired);
    }

    @Override
    public boolean play(Combatant player, ArrayList<Combatant> targets)
    {
        if (targets.size() == 1 && super.play(player, targets))
        {
            Combatant c = targets.get(0);
            c.addTrap(Traps.snare.getTrap());
            return true;
        }
        return false;
    }

    @Override
    public void remove(Combatant c)
    {
        super.remove(c);
    }
}