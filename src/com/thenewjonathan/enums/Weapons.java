package com.thenewjonathan.enums;

import com.thenewjonathan.objects.usables.Effect;
import com.thenewjonathan.objects.usables.MagicWeapon;
import com.thenewjonathan.objects.usables.Weapon;

public enum Weapons
{
	// club types
	lightClub(new Weapon("Light Club", "Made from a tree branch", 1, WeaponTypes.CLUB, Dice.D4.getDie(), 0, false,
			false)),
	heavyClub(new Weapon("Heavy Club", "Made from the root of a tree", 3, WeaponTypes.CLUB, Dice.D6.getDie(), 0, false,
			false)),
	clubOfGirth(new Weapon("Club Of Girth",
			"Taken from a tree in an elven forrest. Enchanted to give it's wielder a bonus" + " to their attack", 5,
			WeaponTypes.CLUB, Dice.D6.getDie(), 1, false, false)),
	bogClub(new MagicWeapon("Bog Club", "Festering club, inflicts 2 rounds of disease damage", 9, WeaponTypes.CLUB,
			Dice.D6.getDie(), 0, false, false, false, 0, null, null, null, new Effect(15, 3, EffectTypes.DISEASE), null,
			0, 0, 0, 3, 0)),
	// light blade types
	dagger(new Weapon("Dagger", "Small blade", 1, WeaponTypes.LIGHTBLADE, Dice.D4.getDie(), 0, false, false)),
	snakeTooth(new MagicWeapon("Snake Tooth", "poisoned dagger", 4, WeaponTypes.LIGHTBLADE, Dice.D4.getDie(), 0, false,
			false, false, 0, null, null, new Effect(10, 2, EffectTypes.POISON), null, null, 0, 0, 0, 5, 0)),
	sickle(new Weapon("Sickle", "Wooden handle, steel blade", 2, WeaponTypes.LIGHTBLADE, Dice.D6.getDie(), 0, false,
			false)),
	rapier(new Weapon("Rapier", "Forged from steel", 3, WeaponTypes.LIGHTBLADE, Dice.D8.getDie(), 0, false, false)),
	shortSword(new Weapon("Short Sword", "Small blade built for speed", 1, WeaponTypes.LIGHTBLADE, Dice.D6.getDie(), 0,
			false, false)),
	doubleSword(new Weapon("Double Sword", "Double edges sword", 6, WeaponTypes.LIGHTBLADE, Dice.DD6.getDie(), 0, false,
			false)),
	shortSwordOfZeus(
			new MagicWeapon("Short Sword of Zeus", "+5 shock damage", 9, WeaponTypes.LIGHTBLADE, Dice.D6.getDie(), 0,
					false, false, false, 0, null, null, null, null, null, 0, 0, 5, 0, 0)),
	katar(new MagicWeapon("Katar", "Small blade, increased chance for critical hit", 11, WeaponTypes.LIGHTBLADE,
			Dice.D6.getDie(), 1, false, false, true, 0, null, null, null, null, null, 0, 0, 0, 0, 35)),
	// heavy blade types
	greatSword(new Weapon("Great Sword", "Massive two-handed sword", 6, WeaponTypes.HEAVYBLADE, Dice.D10.getDie(), 0,
			false, true)),
	longSword(new Weapon("Long Sword", "Forged in human forges, made of steel", 5, WeaponTypes.HEAVYBLADE,
			Dice.D8.getDie(), 0, false, false)),
	scythe(new Weapon("Scythe", "Long bole with curved blade at the end", 5, WeaponTypes.HEAVYBLADE, Dice.DD4.getDie(),
			0, false, true)),
	broadsword(new Weapon("Broadsword", "Two-sided large steel sword", 6, WeaponTypes.HEAVYBLADE, Dice.D10.getDie(), 0,
			false, true)),
	khopesh(new Weapon("Khopesh", "Blade that is straight for 4 inches then bulges out towards the front", 8,
			WeaponTypes.HEAVYBLADE, Dice.D8.getDie(), 0, false, false)),
	scimitar(new Weapon("Scimitar", "Curved blade with a fatter tip", 4, WeaponTypes.HEAVYBLADE, Dice.D8.getDie(), 0,
			false, false)),
	falchion(new Weapon("Falchion", "Forged of strong steel", 5, WeaponTypes.HEAVYBLADE, Dice.DD4.getDie(), 0, false,
			false)),

	// mace types
	mace(new Weapon("Mace", "Steel shaft and head", 4, WeaponTypes.MACE, Dice.D8.getDie(), 0, false, false)),
	crackle(new MagicWeapon("Crackle", "Electrified mace", 7, WeaponTypes.MACE, Dice.D8.getDie(), 0, false, false,
			false, 35, null, null, null, null, null, 0, 0, 10, 0, 0)),
	morningStar(new Weapon("Morningstar", "Ordinary quality", 7, WeaponTypes.MACE, Dice.D10.getDie(), 0, false, false)),
	// spear types
	spear(new Weapon("Spear", "Wooden shaft, meatal tip", 2, WeaponTypes.SPEAR, Dice.D8.getDie(), 0, false, true)),
	trident(new Weapon("Trident", "Spear with three prong tip", 5, WeaponTypes.SPEAR, Dice.D8.getDie(), 0, false,
			true)),
	urgrosh(new Weapon("Urgrosh", "Spear with axe head", 8, WeaponTypes.SPEAR, Dice.DD8.getDie(), 0, false, true)),
	piercingSpear(new MagicWeapon("Piercing Spear", "Spear with tip of diamond to pierce armor", 12, WeaponTypes.SPEAR,
			Dice.DD6.getDie(), 1, false, true, true, 20, null, null, null, null, null, 0, 0, 0, 0, 0)),
	// unarmed augment types
	fistPack(new Weapon("Fist pack", "Molded rock to hold in hand when striking to make the blow heaver", 1,
			WeaponTypes.UNARMEDAUGMENT, Dice.D4.getDie(), 2, false, false)),
	knuckleBlades(new Weapon("Knuckel Blades", "Blades to strap around the hand", 7, WeaponTypes.UNARMEDAUGMENT,
			Dice.DD6.getDie(), 0, false, false)),
	knuckleSpikes(new Weapon("Knuckle Spikes", "Spikes that strap around the hand", 5, WeaponTypes.UNARMEDAUGMENT,
			Dice.D8.getDie(), 0, false, false)),
	fireFists(new MagicWeapon("Fire Fists", "Knuckle covers that burn", 8, WeaponTypes.UNARMEDAUGMENT, Dice.D6.getDie(),
			0, false, true, false, 0, new Effect(15, 3, EffectTypes.BURNING), null, null, null, null, 5, 0, 0, 0, 0)),
	// staff types
	quarterstaff(new Weapon("Quarterstaff", "Wooden staff", 1, WeaponTypes.STAFF, Dice.D8.getDie(), 0, false, true)),
	ironStaff(new Weapon("Iron Staff", "Staff of iron", 4, WeaponTypes.STAFF, Dice.D10.getDie(), 0, false, true)),
	bladedStaff(
			new Weapon("Bladed Staff", "Wooden staff with blades on each end", 7, WeaponTypes.STAFF, Dice.DD8.getDie(),
					0, false, true)),
	frostStaff(
			new MagicWeapon("Frost Staff", "The staff eminates cold", 9, WeaponTypes.STAFF, Dice.D8.getDie(), 0, false,
					true, false, 0, null, null, null, null, null, 0, 10, 0, 0, 0)),
	// axe types
	battleAxe(new Weapon("Battle Axe", "Large axe", 3, WeaponTypes.AXE, Dice.D10.getDie(), 0, false, true)),
	handAxe(new Weapon("Hand Axe", "Small axe", 1, WeaponTypes.AXE, Dice.D6.getDie(), 0, false, false)),
	jaggedAxe(new MagicWeapon("Jagged Axe", "Axe with a jagged edge to cause bleeding", 9, WeaponTypes.AXE,
			Dice.D8.getDie(), 0, false, false, false, 0, null, new Effect(10, 5, EffectTypes.BLEEDING), null, null,
			null, 0, 0, 0, 0, 0)),
	doubleSidedAxe(
			new Weapon("Double Sided Axe", "Axe with two blades", 8, WeaponTypes.AXE, Dice.DD10.getDie(), 0, false,
					true)),

	// flail types
	flail(new Weapon("Flail", "Wooden handle, steel ball", 3, WeaponTypes.FLAIL, Dice.D8.getDie(), 0, false, false)),
	scourge(new Weapon("Scourge", "Iron handle, spiked ball", 5, WeaponTypes.FLAIL, Dice.D10.getDie(), 0, false,
			false)),
	heavyFlail(
			new Weapon("Heavy Flail", "Two handed handle, larger spiked ball", 8, WeaponTypes.FLAIL, Dice.DD8.getDie(),
					0, false, true)),
	doubleHeadedFlail(
			new Weapon("Double Headed Flail", "Flail with two heads", 5, WeaponTypes.FLAIL, Dice.DD6.getDie(), 0, false,
					false)),
	// pick types
	lightWarPick(new Weapon("Light War Pick", "Wood handle, iron head", 1, WeaponTypes.PICK, Dice.D6.getDie(), 0, false,
			false)),
	heavyWarPick(new Weapon("Heavy War Pick", "Two handed war pick", 4, WeaponTypes.PICK, Dice.D12.getDie(), 0, false,
			true)),
	// hammer types
	lightWarHammer(
			new Weapon("Light Warhammer", "Iron head, blunt back", 1, WeaponTypes.HAMMER, Dice.D6.getDie(), 0, false,
					false)),
	warHammer(new Weapon("Warhammer", "Steel head, spike on back", 6, WeaponTypes.HAMMER, Dice.D10.getDie(), 0, false,
			true)),
	maul(new Weapon("Maul", "50 pound hammer", 9, WeaponTypes.HAMMER, Dice.D12.getDie(), 0, false, true)),
	// polearm types
	glaive(new Weapon("Glaive", "Pole with a large, straight blade on the end", 5, WeaponTypes.POLEARM,
			Dice.DD6.getDie(), 0, false, true)),
	longSpear(
			new Weapon("Longspear", "10' pole with metal tip. Can attack from ranged position", 6, WeaponTypes.POLEARM,
					Dice.D10.getDie(), 0, true, true)),
	// crossbow types
	crossbow(new Weapon("Crossbow", "Mechanical bow", 1, WeaponTypes.CROSSBOW, Dice.D6.getDie(), 0, true, true)),
	heavyCrossbow(
			new Weapon("Heavy Crossbow", "Shoots harder than the first", 5, WeaponTypes.CROSSBOW, Dice.D10.getDie(), 0,
					true, true)),
	rapidCrossbow(
			new Weapon("Rapid Crossbow", "Fires two bolts per turn", 7, WeaponTypes.CROSSBOW, Dice.DD8.getDie(), 0,
					true, true)),
	dragonsBreath(
			new MagicWeapon("Dragon's Breath", "Ignites bolt when fired", 13, WeaponTypes.CROSSBOW, Dice.DD8.getDie(),
					0, true, true, false, 0, new Effect(10, 2, EffectTypes.BURNING), null, null, null, null, 5, 0, 0, 0,
					0)),
	// bow types
	bow(new Weapon("Bow", "Ordinary bow", 1, WeaponTypes.BOW, Dice.D4.getDie(), 0, true, true)),
	shortBow(new Weapon("Short Bow", "Small bow", 2, WeaponTypes.BOW, Dice.D6.getDie(), 0, true, true)),
	longBow(new Weapon("Long Box", "Large bow", 3, WeaponTypes.BOW, Dice.D8.getDie(), 0, true, true)),
	warBow(new Weapon("War Bow", "Heavy bow", 5, WeaponTypes.BOW, Dice.D10.getDie(), 0, true, true)),
	splitBow(new Weapon("Great Bow", "Fire two arrorws", 9, WeaponTypes.BOW, Dice.DD8.getDie(), 0, true, true));

	Weapons(Weapon w)
	{
		setWeapon(w);
	}

	private Weapon weapon;

	@Override
	public String toString()
	{
		return getWeapon().getName();
	}

	public static Weapon getWeaponByName(String name)
	{
		for (Weapons w : values())
		{
			if (w.getWeapon().getName().equalsIgnoreCase(name))
			{
				return w.getWeapon();
			}
		}
		return null;
	}

	public void setWeapon(Weapon w)
	{
		weapon = w;
	}

	public Weapon getWeapon()
	{
		return weapon;
	}
}
