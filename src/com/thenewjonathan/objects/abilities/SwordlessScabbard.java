package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

/**
 * Created by jon on 4/16/2015.
 */
public class SwordlessScabbard extends Ability implements IAbility
{
    public SwordlessScabbard(String name, String description, int cost, int duration, int levelRequired)
    {
        super(name, description, cost, duration, levelRequired);
    }

    @Override
    public boolean play(Combatant player, ArrayList<Combatant> targets)
    {
        if(targets.size() == 1 && super.play(player, targets))
        {
            Combatant c = targets.get(0);
            c.takeDamage(player, 0, 0, 0, 0, 0, 0, 150);
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
