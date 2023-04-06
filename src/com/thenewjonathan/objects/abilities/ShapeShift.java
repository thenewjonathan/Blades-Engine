package com.thenewjonathan.objects.abilities;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.enums.EffectTypes;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.IAbility;
import com.thenewjonathan.objects.usables.Ability;
import com.thenewjonathan.objects.usables.Effect;

import java.util.ArrayList;

public class ShapeShift extends Ability implements IAbility
{
    public ShapeShift(String name, String description, int cost, int duration, int levelRequired)
    {
        super(name, description, cost, duration, levelRequired);
    }

    @Override
    public boolean play(Combatant player, ArrayList<Combatant> targets)
    {
        if (targets.size() == 1 && super.play(player, targets))
        {
            Combatant c = targets.get(0);

            if (player.getLevel() < 7) // Giant Rat
            {
                c.takeDamage(player, (Dice.DD10.getDie().roll()), 0, 0, 0, 0, 0, 0);
            } else if (player.getLevel() < 10) // Giant Spider
            {
                c.takeDamage(player, 0, (Dice.DD10.getDie().roll()), 0, 0, 0, 0, 0);
                c.addEffect(new Effect(player, 10, 2, EffectTypes.POISON));
            } else if (player.getLevel() < 13) // Panther
            {
                int damage = Dice.DD10.getDie().roll() + Dice.DD10.getDie().roll();
                c.takeDamage(player, damage, 0, 0, 0, 0, 0, 0);
                c.addEffect(new Effect(player, 5, 1, EffectTypes.BLEEDING));
            } else // Bear
            {
                int damage = Dice.DD10.getDie().roll() + Dice.DD10.getDie().roll() + Dice.DD10.getDie().roll() +
                        Dice.DD10.getDie().roll();
                c.takeDamage(player, damage, 0, 0, 0, 0, 0, 0);
                c.addEffect(new Effect(player, 10, 2, EffectTypes.BLEEDING));
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