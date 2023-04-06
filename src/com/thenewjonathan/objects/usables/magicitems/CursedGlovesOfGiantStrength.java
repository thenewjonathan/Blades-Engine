package com.thenewjonathan.objects.usables.magicitems;

import com.thenewjonathan.enums.ArmorTypes;
import com.thenewjonathan.enums.EffectTypes;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.objects.usables.Effect;
import com.thenewjonathan.objects.usables.MagicArmor;

public class CursedGlovesOfGiantStrength extends MagicArmor
{
	public CursedGlovesOfGiantStrength(String name, String desc, int level, ArmorTypes type, int defenseModifier,
	                                   int durability, int strBonus, int agiBonus, int intBonus, int accBonus,
	                                   int wisBonus, int constBonus, int willBonus, int weaponProficiencyBonus,
	                                   int shockDamageMod, int fireDamageMod, int coldDamageMod, int diseaseDamageMod)
	{
		super(name, desc, level, type, defenseModifier, durability, strBonus, agiBonus, intBonus, accBonus, wisBonus,
				constBonus, willBonus, weaponProficiencyBonus, shockDamageMod, fireDamageMod, coldDamageMod,
				diseaseDamageMod);
	}

	@Override
	public void applyBonus(Combatant c)
	{
		super.applyBonus(c);
		int poisonDamage = 10;
		c.takeDamage(c, 0, poisonDamage, 0, 0, 0, 0, 0);
		c.getCurrentEffects().add(new Effect(c, 30, 6, EffectTypes.POISON));
	}

}
