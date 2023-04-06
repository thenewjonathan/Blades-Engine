package com.thenewjonathan.enums;

import com.thenewjonathan.objects.abilities.*;
import com.thenewjonathan.objects.usables.Ability;

public enum Abilities
{
	// *** ARCANE ***
	// Black Wizard
	drainingTouch(new DrainingTouch("Draining Touch", "Drain 1d4/level life from enemy", 1, 1, 1)),
	enfeeblement(new Enfeeblement("Enfeeblement", "Reduce targets power and defense by 1/level", 5, 1, 3)),
	// White Wizard
	heal(new Heal("Heal", "Heal 1d4 per level of caster hitpoints", 1, 1, 1)),
	embolden(new Embolden("Embolden", "Increase the attack power of ally for one turn", 5, 1, 3)),
	// Red Wizard
	hurt(new Hurt("Hurt", "Do 1d4 damage per level of caster", 1, 1, 1)),
	// Blue Wizard
	summonMephit(new SummonMephit("Summon Mephit", "Summon Mephit to do 1d4 per level of caster", 1, 1, 1)),
	summonDrake(new SummonDrake("Summon Drake",
			"Summon a Fire Drake to do 1d4 per level of caster fire damage and add" + " burning(10,2)", 5, 1, 4)),
	// *** DIVINE ***
	// Hextor (Magic Dart, Hextor's Axe, Essence of Hextor, Hextor's Mace, Hextor's Mantle)
	magicDart(new MagicDart("Magic Dart", "Will two magic darts into existence to hurl at enemy", 1, 1, 1)),
	hextorsAxe(new HextorsAxe("Hextor's Axe", "Summon spectral axe to inflict 1d12 damage to enemy", 5, 1, 4)),
	essenceOfHextor(new EssenceOfHextor("Essence Of Hextor",
			"The essence of Hextor bolsters your attack power and" + " accuracy for one turn", 10, 1, 7)),
	hextorsMace(new HextorsMace("Hextor's Mace",
			"Summon spectral mace to inflict 2d12 damage and add bleeding" + " for one round", 15, 1, 10)),
	hextorsMantle(new HextorsMantle("Hextor's Mantle", "Summon all of Hextor's weapons to destroy foe", 25, 1, 15)),
	// Rao (Reason, Cap of Reason, Edoira's Wisdom, Swordless Scabbard, Crook of Rao)
	reason(new Reason("Reason", "Convice enemy not to target you for one round", 1, 1, 1)),
	raosBlessing(new RaosBlessing("Rao's Blessing", "Give +5 defense to target for one round", 5, 1, 4)),
	edoirasWisdom(new EdoirasWisdom("Edoira's Wisdom", "Inner peace grants you +5 to accuracy and power", 10, 1, 7)),
	swordlessScabbard(new SwordlessScabbard("Swordless Scabbard", "By the power of Rao, the target is weakened " +
			"and the caster is strengthened", 15, 1, 10)),
	crookOfRao(new CrookOfRao("Crook Of Rao", "Rao's shepherd's crook causes all enemies in sight to cower in fear",
			25, 1, 15)),
	// Obad-Hai
	ensnare(new Ensnare("Ensnare", "Ensnare the next melee attacker for one round", 1, 1, 1)),
	shapeShift(new ShapeShift("Shape Shift", "Shift into Giant Rat/Giant Spider/Panther/Bear and do damage" +
			" to enemy", 5, 1, 4)),
	shalmSong(new ShalmSong("Shalm Song", "Lull enemy to sleep for one round (no save)", 10, 1, 7)),
	// Nerull
	poison(new Poison("Poison", "Poison enemy with the essence of Nerull", 1, 1, 1)),
	soulSpider(new SoulSpider("Soul Spider", "Summon soul spider to leach enemy's stamina for your own", 5, 1, 4)),
	miasma(new Miasma("Miasma", "Poison cloud poisons up to 3 enemies", 10, 1, 7)),
	bloodSpider(new BloodSpider("Blood Spider", "Summon blood spider to carry enemy's life to you", 15, 1, 10)),
	callOfTheGrave(new CallOfTheGrave("Call Of The Grave", "Reduce Strength, Agility and Constitution by 200 points. " +
			"If the target has any attribute reduced to 0, they are slain and caster is 100% restored of life", 25, 1, 15)),
	// *** POWER ***
	// Barbarian
	warCry(new WarCry("War Cry", "Increase ally's strength by 1d4/lvl max lvl 4", 1, 1, 1)),
	berserk(new Berserk("Berserk", "+1 to attack mod and 150% power", 5, 1, 4)),
	bladeArc(new BladeArc("Blade Arc", "Hit multiple enemies at once", 10, 1, 7)),
	// Monk
	criticalStrike(new CriticalStrike("Critical Strike", "Automatic hit, double damage", 1, 1, 1)),
	grace(new Grace("Grace", "100 bonus to agility for one turn", 5,1,4)),
	cleansing(new Cleansing("Cleansing", "Heal 1d6 per level (max 10) and remove all effects", 10, 1, 7)),
	// Elemental Blade
	flameBlade(new FlameBlade("Flame Blade", "Weapon damamge plus burning(5,1", 1, 1, 1)),
	frostBlade(new FrostBlade("Frost Blade", "Weapon damage plus 1d4/level and add freezing(5,1)", 5,1,4)),
	lightningBlade(new LightningBlade("Lightning Blade", "weapon damage plus shock damage, add shock effect " +
			"and 35% chance of stunning the target", 10, 1, 7)),
	// *** SPEED/STEALTH ***
	// Ranger
	focusedStrike(new FocusedStrike("Focused Strike", "Lower agility, increase accuracy", 1, 1, 1)),
	jumpAttack(new JumpAttack("Jump Attack", "Leap over walls to strike enemy with both weapons", 5, 1, 4)),
	throwingKnife(new ThrowingKnife("Throwing Knife", "Throw knife at target", 10, 1, 7)),
	tipOfTheBlade(new TipOfTheBlade("Tip of the Blade", "Pinpoint strike to do 3x damage and stun target", 20, 1, 13)),
	// Rogue
	demilitarize(new Demilitarize("Demilitarize", "10% per level chance to disarm enemy (max level 8)", 5, 1, 4)),
	deathBy1000Cuts(new DeathBy1000Cuts("Death By 1000 Cuts", "4 extra attacks and 100 bonus to accuracy",
			20, 1, 10)),
	slay(new Slay("Slay", "40% chance to slay the enemy in one hit", 40, 1, 15)),
	// Shadow Dancer
	acrobaticStrike(new AcrobaticStrike("Acrobatic Strike", "Leap over wall to attack enemy", 1, 1, 1)),
	garrote(new Garrote("Garrote", "Keep spellcaster from casting spells this turn", 10, 1, 7)),
	// Fighter
	parry(new Parry("Parry", "Ignore all damage for one round", 5, 1, 4)),
	// demilitarize here for fighter also
	calledShot(new CalledShot("Called Shot", "Chance to do triple damage. No damamge if miss", 20, 1, 10))
	;

	Abilities(Ability ability)
	{
		setAbility(ability);
	}


	private Ability ability;

	@Override
	public String toString()
	{
		return getAbility().getName();
	}

	public static Ability getAbilityByName(String name)
	{
		for (Abilities a : values())
		{
			if (a.getAbility().getName().equalsIgnoreCase(name))
			{
				return a.getAbility();
			}
		}
		return null;
	}

	public void setAbility(Ability ability)
	{
		this.ability = ability;
	}

	public Ability getAbility()
	{
		return ability;
	}
}
