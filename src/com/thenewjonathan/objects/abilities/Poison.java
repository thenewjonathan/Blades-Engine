package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.enums.EffectTypes;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;
import com.thenewjonathan.objects.usables.Effect;

import java.util.ArrayList;

public class Poison extends Ability implements IAbility
{
    public Poison(String name, String description, int cost, int duration, int levelRequired)
    {
        super(name, description, cost, duration, levelRequired);
    }

    @Override
    public boolean play(Combatant player, ArrayList<Combatant> targets)
    {
        if (targets.size() == 1 && super.play(player, targets))
        {
            targets.get(0).addEffect(new Effect(player, 15, 3, EffectTypes.POISON));
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