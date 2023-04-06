package com.thenewjonathan.test;

import com.thenewjonathan.enums.EffectTypes;
import com.thenewjonathan.enums.Genders;
import com.thenewjonathan.enums.WeaponTypes;
import com.thenewjonathan.heros.classes.*;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.objects.usables.Effect;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EffectTest
{
	Combatant gandalf, saroun, servarious, ang, shadow, grethor;

	@Before
	public void initialize()
	{
		gandalf = new WhiteWizard("Gandalf", Genders.MALE, 15, 50, 50, 150, 50, 150, 50, 200, 50, null, 13000, null,
				null);
		gandalf.addWeaponProficiencyTypes(WeaponTypes.STAFF);
		saroun = new BlackWizard("Saroun", Genders.MALE, 5, 50, 50, 150, 50, 150, 50, 200, 50, null, 13000, null, null);
		saroun.addWeaponProficiencyTypes(WeaponTypes.STAFF);
		servarious = new Monk("Sevarious", Genders.MALE, 13, 200, 200, 100, 200, 150, 150, 100, 150, null, 13000, null,
				null);
		servarious.addWeaponProficiencyTypes(WeaponTypes.STAFF);
		ang = new ElementalBlade("Ang", Genders.MALE, 12, 150, 100, 200, 200, 100, 100, 250, 200, null, 12000, null,
				null);
		ang.addWeaponProficiencyTypes(WeaponTypes.HEAVYBLADE);
		ang.addWeaponProficiencyTypes(WeaponTypes.MACE);
		shadow = new ShadowDancer("Shadow", Genders.MALE, 12, 150, 100, 200, 200, 100, 100, 250, 200, null, 12000, null,
				null);
		shadow.addWeaponProficiencyTypes(WeaponTypes.HEAVYBLADE);
		shadow.addWeaponProficiencyTypes(WeaponTypes.LIGHTBLADE);
		grethor = new HextorFollower("Grethor", Genders.MALE, 12, 150, 100, 200, 200, 100, 100, 250, 200, null, 12000,
				null, null);
		grethor.addWeaponProficiencyTypes(WeaponTypes.HEAVYBLADE);
		grethor.addWeaponProficiencyTypes(WeaponTypes.CROSSBOW);
	}

	@Test
	public void test()
	{
		servarious.addEffect(new Effect(10, 5, EffectTypes.DISEASE));
		servarious.addEffect(new Effect(10, 5, EffectTypes.COLD));
		servarious.addEffect(new Effect(10, 5, EffectTypes.SHOCK));
		int angLife = servarious.getCurrentLife();
		servarious.executeEffects();
		assertEquals("ang should have taken 30 damage from the three effects", angLife - 30,
				servarious.getCurrentLife());
	}

}
