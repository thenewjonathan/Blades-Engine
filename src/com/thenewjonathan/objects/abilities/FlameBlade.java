package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.enums.EffectTypes;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;
import com.thenewjonathan.objects.usables.Effect;
import com.thenewjonathan.objects.usables.Weapon;

import java.util.ArrayList;

public class FlameBlade extends Ability implements IAbility
{
    public FlameBlade(String name, String description, int cost, int duration, int levelRequired)
    {
        super(name, description, cost, duration, levelRequired);
    }

    @Override
    public boolean play(Combatant player, ArrayList<Combatant> targets)
    {
        if (targets.size() == 1 && player.hasWeapon() &&  super.play(player, targets))
        {
            Combatant c = targets.get(0);
            for(Weapon s : player.getWeaponsInPlay())
            {
                s.swing(player, c, false);
            }
            c.addEffect(new Effect(player, 10, 2, EffectTypes.BURNING));
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