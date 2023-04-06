package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

public class CalledShot extends Ability implements IAbility
{
    public CalledShot(String name, String description, int cost, int duration, int levelRequired)
    {
        super(name, description, cost, duration, levelRequired);
    }

    @Override
    public boolean play(Combatant player, ArrayList<Combatant> targets)
    {
        if (targets.size() == 1 && super.play(player, targets))
        {
            int chance = (player.getLevel() - 6) * 10;
            Combatant c = targets.get(0);
            if(Dice.percentageRoll(chance))
            {
                player.attackDamageRoll(false, c);
                player.attackDamageRoll(false, c);
                player.attackDamageRoll(false, c);
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