package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

public class Cleansing extends Ability implements IAbility
{
    public Cleansing(String name, String description, int cost, int duration, int levelRequired)
    {
        super(name, description, cost, duration, levelRequired);
    }

    @Override
    public boolean play(Combatant player, ArrayList<Combatant> targets)
    {
        if (targets.size() == 1 && super.play(player, targets))
        {
            Combatant c = targets.get(0);
            c.getAbilityEffects().clear();
            int lifeGain = 0;
            for (int i = 0; i < Math.min(10, player.getLevel()); i++)
            {
                lifeGain += Dice.D6.getDie().roll();
            }
            c.gainLife(lifeGain);
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