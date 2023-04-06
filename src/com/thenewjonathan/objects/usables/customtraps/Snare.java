package com.thenewjonathan.objects.usables.customtraps;

import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ITrap;
import com.thenewjonathan.objects.usables.Trap;

public class Snare extends Trap implements ITrap
{
    public Snare(String name, int level, int damage, int pDamage, int fDamage, int cDamage, int sDamage)
    {
        super(name, level, damage, pDamage, fDamage, cDamage, sDamage);
    }

    @Override
    public void executeTrap(Combatant target)
    {
        super.executeTrap(target);
        target.setStunned(true);
    }
}
