package com.thenewjonathan.objects.usables;

import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.enums.WeaponTypes;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.objects.admin.Die;
import com.thenewjonathan.userinterface.CommonFunctions;

public class MagicWeapon extends Weapon
{
	private boolean ignoreArmor;
	private int stunChance;
	private Effect burning;
	private Effect bleeding;
	private Effect poison;
	private Effect disease;
	private int fireDamage;
	private int coldDamage;
	private int shockDamage;
	private int poisonDamage;
	private int criticalHitModifier;
	// percentage chance here, roll again inside the swing function to see if it's successful

	public MagicWeapon(String name, String desc, int level, WeaponTypes type, Die dieToRoll, int modifier,
	                   boolean ranged, boolean twoHanded, boolean ignoreArmor, int stunChance, Effect burning,
	                   Effect bleeding, Effect poison, Effect disease, Effect shock, int fireDamage, int coldDamage,
	                   int shockDamage, int poisonDamage, int critHit)
	{
		super(name, desc, level, type, dieToRoll, modifier, ranged, twoHanded);
		setIgnoreArmor(ignoreArmor);
		setStunChance(stunChance);
		setBurning(burning);
		setBleeding(bleeding);
		setPoison(poison);
		setDisease(disease);
		setFireDamage(fireDamage);
		setColdDamage(coldDamage);
		setShockDamage(shockDamage);
		setPoisonDamage(poisonDamage);
		setCriticalHitModifier(critHit);
	}

	@Override
	public void swing(Combatant attacker, Combatant target, boolean doubleDamage)
	{
		boolean critical = doubleDamage;
		if (getCriticalHitModifier() > 0)
		{
			if (Dice.percentageRoll(getCriticalHitModifier()))
			{
				CommonFunctions.say("Critical hit!!");
				critical = true;
			}
		}
		CommonFunctions.say(attacker + " is attacking with the " + this);
		target.takeDamage(attacker,
				critical ? (getDieToRoll().roll() + getModifier()) * 2 : getDieToRoll().roll() + getModifier(),
				(getPoisonDamage() > 0) ? ((critical ? getPoisonDamage() * 2 : getPoisonDamage()) *
						((100 - target.getPoisonDamageModifierPercent()) / 100)) - target.getPoisonDamageModifier() : 0,
				(getColdDamage() > 0) ? ((critical ? getColdDamage() * 2 : getColdDamage()) *
						((100 - target.getColdDamageModifierPercent()) / 100)) - target.getColdDamageModifier() : 0,
				(getFireDamage() > 0) ? ((critical ? getFireDamage() * 2 : getFireDamage()) *
						((100 - target.getFireDamageModifierPercent()) / 100)) - target.getFireDamageModifier() : 0, 0,
				(getShockDamage() > 0) ? ((critical ? getShockDamage() * 2 : getShockDamage()) *
						((100 - target.getShockDamageModifierPercent()) / 100)) - target.getShockDamageModifier() : 0,
				0);
		if (getBurning() != null)
		{
			getBurning().setCreator(attacker);
			target.getCurrentEffects().add(getBurning());
			CommonFunctions.say("Added " + getBurning() + " effect");
		}
		if (getBleeding() != null)
		{
			getBleeding().setCreator(attacker);
			target.getCurrentEffects().add(getBleeding());
			CommonFunctions.say("Added " + getBleeding() + " effect");
		}
		if (getPoison() != null)
		{
			getPoison().setCreator(attacker);
			target.getCurrentEffects().add(getPoison().clone());
			CommonFunctions.say("Added " + getPoison() + " effect");
		}
		if (getDisease() != null)
		{
			getDisease().setCreator(attacker);
			target.getCurrentEffects().add(getDisease());
			CommonFunctions.say("Added " + getDisease() + " effect");
		}
		if (getStunChance() > 0)
		{
			if (Dice.percentageRoll(getStunChance()))
			{
				target.setStunned(true);
			}
		}
	}

	public void swing(Combatant attacker, Defender defender, boolean crit)
	{
		int damage = getDieToRoll().roll() + getFireDamage() + getColdDamage() + getShockDamage() +
				getPoisonDamage();
		if (crit)
		{
			damage *= 2;
		}
		defender.takeDamage(damage);
	}

	public boolean isIgnoreArmor()
	{
		return ignoreArmor;
	}

	public void setIgnoreArmor(boolean ignoreArmor)
	{
		this.ignoreArmor = ignoreArmor;
	}

	public int getStunChance()
	{
		return stunChance;
	}

	public void setStunChance(int stunChance)
	{
		this.stunChance = stunChance;
	}

	public Effect getBurning()
	{
		return burning;
	}

	public void setBurning(Effect burning)
	{
		this.burning = burning;
	}

	public Effect getBleeding()
	{
		return bleeding;
	}

	public void setBleeding(Effect bleeding)
	{
		this.bleeding = bleeding;
	}

	public Effect getPoison()
	{
		return poison;
	}

	public void setPoison(Effect poison)
	{
		this.poison = poison;
	}

	public Effect getDisease()
	{
		return disease;
	}

	public void setDisease(Effect disease)
	{
		this.disease = disease;
	}

	public int getFireDamage()
	{
		return fireDamage;
	}

	public void setFireDamage(int fireDamage)
	{
		this.fireDamage = fireDamage;
	}

	public int getColdDamage()
	{
		return coldDamage;
	}

	public void setColdDamage(int coldDamage)
	{
		this.coldDamage = coldDamage;
	}

	public int getShockDamage()
	{
		return shockDamage;
	}

	public void setShockDamage(int shockDamage)
	{
		this.shockDamage = shockDamage;
	}

	public int getPoisonDamage()
	{
		return poisonDamage;
	}

	public void setPoisonDamage(int poisonDamage)
	{
		this.poisonDamage = poisonDamage;
	}

	public int getCriticalHitModifier()
	{
		return criticalHitModifier;
	}

	public void setCriticalHitModifier(int criticalHitModifier)
	{
		this.criticalHitModifier = criticalHitModifier;
	}
}
