package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;

public class DeathBy1000Cuts extends Ability implements IAbility
{
    public DeathBy1000Cuts(String name, String description, int cost, int duration, int levelRequired)
    {
        super(name, description, cost, duration, levelRequired);
    }

    @Override
    public boolean play(Combatant player, ArrayList<Combatant> targets)
    {
        if (targets.size() == 1 && super.play(player, targets))
        {
            player.setAccuracy(player.getAccuracy() + 100);
            player.setAgility(player.getAgility() + 200);
            player.updateStats();
            for (int i = 0; i < player.getAttackMod(); i++)
            {
                player.attackDamageRoll(false, targets.get(0));
            }
            player.setAccuracy(player.getAccuracy() - 100);
            player.setAgility(player.getAgility() - 200);
            player.updateStats();
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