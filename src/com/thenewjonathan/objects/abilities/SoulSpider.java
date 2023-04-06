package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

public class SoulSpider extends Ability implements IAbility
{
    public SoulSpider(String name, String description, int cost, int duration, int levelRequired)
    {
        super(name, description, cost, duration, levelRequired);
    }

    @Override
    public boolean play(Combatant player, ArrayList<Combatant> targets)
    {
        if (targets.size() == 1 && super.play(player, targets))
        {
            Combatant c = targets.get(0);

            int stamDamage = 0;
            for (int i = 0; i < player.getLevel(); i++)
            {
                stamDamage += Dice.D4.getDie().roll();
            }
            stamDamage = Math.min(c.getCurrentStamina(), stamDamage);
            c.setCurrentStamina(c.getCurrentStamina() - stamDamage);
            player.setCurrentStamina(player.getCurrentStamina() + stamDamage);
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