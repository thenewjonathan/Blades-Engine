package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

public class BloodSpider extends Ability implements IAbility
{
    public BloodSpider(String name, String description, int cost, int duration, int levelRequired)
    {
        super(name, description, cost, duration, levelRequired);
    }

    @Override
    public boolean play(Combatant player, ArrayList<Combatant> targets)
    {
        if (targets.size() > 0 && targets.size() <= 2 && super.play(player, targets))
        {
            for (int i = 0; i < targets.size(); i++)
            {
                int damage = 0;
                for (int j = 0; j < player.getLevel(); j++)
                {
                    damage += Dice.D8.getDie().roll();
                    targets.get(i).takeDamage(player, 0, 0, 0, 0, 0, 0, damage);
                }
            }
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