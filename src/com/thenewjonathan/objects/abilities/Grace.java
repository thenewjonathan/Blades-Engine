package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

public class Grace extends Ability implements IAbility
{
    public Grace(String name, String description, int cost, int duration, int levelRequired)
    {
        super(name, description, cost, duration, levelRequired);
    }

    @Override
    public boolean play(Combatant player, ArrayList<Combatant> targets)
    {
        if (targets.size() == 1 && targets.get(0).equals(player) && super.play(player, targets))
        {
            Combatant c = targets.get(0);
            c.setAgility(c.getAgility() + 100);
            return true;
        }
        return false;
    }

    @Override
    public void remove(Combatant c)
    {
        c.setAgility(c.getAgility() - 100);
        super.remove(c);
    }
}