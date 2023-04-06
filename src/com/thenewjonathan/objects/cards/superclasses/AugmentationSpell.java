package com.thenewjonathan.objects.cards.superclasses;

import com.thenewjonathan.heros.superclasses.Combatant;

import java.util.ArrayList;


public class AugmentationSpell extends AugmentationCard
{
	private int lifeMod;
	private int strengthMod;
	private int agilityMod;
	private int intelligenceMod;
	private int accuracyMod;
	private int constitutionMod;
	private int willpowerMod;
	private int weaponProficencyMod;

	public AugmentationSpell(String name, int cardLife, int cost, int levelRequired, boolean targetOther,
	                         boolean ranged)
	{
		super(name, cardLife, cost, levelRequired, targetOther, ranged);
	}

	/**
	 * All mods will be added to the targets score
	 *
	 * @param name
	 * @param cardLife
	 * @param cost
	 * @param levelRequired
	 * @param targetOther
	 * @param ranged
	 * @param lifeMod
	 * @param strengthMod
	 * @param agilityMod
	 * @param intelligenceMod
	 * @param accuracyMod
	 * @param constitutionMod
	 * @param willpowerMod
	 * @param weaponProficiencyMod
	 */
	public AugmentationSpell(String name, int cardLife, int cost, int levelRequired, boolean targetOther,
	                         boolean ranged, int lifeMod, int strengthMod, int agilityMod, int intelligenceMod,
	                         int accuracyMod, int constitutionMod, int willpowerMod, int weaponProficiencyMod)
	{
		this(name, cardLife, cost, levelRequired, targetOther, ranged);
		setLifeMod(lifeMod);
		setStrengthMod(strengthMod);
		setAgilityMod(agilityMod);
		setIntelligenceMod(intelligenceMod);
		setAccuracyMod(accuracyMod);
		setConstitutionMod(constitutionMod);
		setWillpowerMod(willpowerMod);
		setWeaponProficencyMod(weaponProficiencyMod);
	}

	@Override
	public void play(Combatant player, ArrayList<Combatant> targets)
	{
		super.play(player, targets);
		for (Combatant c : targets)
		{
			c.setCurrentLife(c.getCurrentLife() + getLifeMod());
			c.setStrength(c.getStrength() + getStrengthMod());
			c.setAgility(c.getAgility() + getAgilityMod());
			c.setIntelligence(c.getIntelligence() + getIntelligenceMod());
			c.setAccuracy(c.getAccuracy() + getAccuracyMod());
			c.setConstitution(c.getConstitution() + getConstitutionMod());
			c.setWill(c.getWill() + getWillpowerMod());
			c.setWeaponProficiency(c.getWeaponProficiency() + getWeaponProficencyMod());
			c.updateStats();
		}

	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
		combatant.setStrength(combatant.getStrength() - getStrengthMod());
		combatant.setAgility(combatant.getAgility() - getAgilityMod());
		combatant.setIntelligence(combatant.getIntelligence() - getIntelligenceMod());
		combatant.setAccuracy(combatant.getAccuracy() - getAccuracyMod());
		combatant.setConstitution(combatant.getConstitution() - getConstitutionMod());
		combatant.setWill(combatant.getWill() - getWillpowerMod());
		combatant.setWeaponProficiency(combatant.getWeaponProficiency() - getWeaponProficencyMod());
		combatant.updateStats();
	}

	public int getLifeMod()
	{
		return lifeMod;
	}

	public void setLifeMod(int lifeMod)
	{
		this.lifeMod = lifeMod;
	}

	public int getStrengthMod()
	{
		return strengthMod;
	}

	public void setStrengthMod(int strengthMod)
	{
		this.strengthMod = strengthMod;
	}

	public int getAgilityMod()
	{
		return agilityMod;
	}

	public void setAgilityMod(int agilityMod)
	{
		this.agilityMod = agilityMod;
	}

	public int getIntelligenceMod()
	{
		return intelligenceMod;
	}

	public void setIntelligenceMod(int intelligenceMod)
	{
		this.intelligenceMod = intelligenceMod;
	}

	public int getAccuracyMod()
	{
		return accuracyMod;
	}

	public void setAccuracyMod(int accuracyMod)
	{
		this.accuracyMod = accuracyMod;
	}

	public int getConstitutionMod()
	{
		return constitutionMod;
	}

	public void setConstitutionMod(int constitutionMod)
	{
		this.constitutionMod = constitutionMod;
	}

	public int getWillpowerMod()
	{
		return willpowerMod;
	}

	public void setWillpowerMod(int willpowerMod)
	{
		this.willpowerMod = willpowerMod;
	}

	public int getWeaponProficencyMod()
	{
		return weaponProficencyMod;
	}

	public void setWeaponProficencyMod(int weaponProficencyMod)
	{
		this.weaponProficencyMod = weaponProficencyMod;
	}
}
