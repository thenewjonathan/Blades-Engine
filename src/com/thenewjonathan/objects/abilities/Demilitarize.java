package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;

import java.util.ArrayList;
import java.util.Random;

public class Demilitarize extends Ability implements IAbility
{
    public Demilitarize(String name, String description, int cost, int duration, int levelRequired)
    {
        super(name, description, cost, duration, levelRequired);
    }

    @Override
    public boolean play(Combatant player, ArrayList<Combatant> targets)
    {
        if (targets.size() == 1 && targets.get(0).hasWeapon() && super.play(player, targets))
        {
            if(Dice.percentageRoll(Math.min(80, player.getLevel()*10)))
            {
                Combatant c = targets.get(0);
                if(c.getWeaponsInPlay().size() > 1)
                {
                    Random rand = new Random();
                    c.dropWeapon(c.getWeaponsInPlay().get(rand.nextInt(c.getWeaponsInPlay().size())));
                }
                else
                {
                    c.dropWeapon(c.getWeaponsInPlay().get(0));
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