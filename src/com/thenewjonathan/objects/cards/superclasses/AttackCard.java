package com.thenewjonathan.objects.cards.superclasses;

import com.thenewjonathan.enums.DamageTypes;
import com.thenewjonathan.enums.Dice;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.admin.Die;
import com.thenewjonathan.objects.usables.Card;
import com.thenewjonathan.objects.usables.Defender;
import com.thenewjonathan.objects.usables.Effect;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.util.ArrayList;

public class AttackCard extends Card implements ICard
{
	private int maxLevel;
	private int dieMultiplier;
	private int maxTargets;
	private int stunChance;
	private boolean stun;
	private boolean perLevel;
	private Die dieToRoll;
	private DamageTypes typeOfDamage;
	private ArrayList<Effect> effects;

	public AttackCard(String name, int cardLife, int cost, int levelRequired, boolean targetOther, boolean ranged,
	                  Die dieToRoll, int dieMultiplier, int maxLevel, boolean perLevel, DamageTypes typeOfDamage,
	                  ArrayList<Effect> effects, int maxTargets, boolean stun, int stunChance, boolean ignoreDefender)
	{
		super(name, cardLife, cost, levelRequired, targetOther, ranged);
		setDieToRoll(dieToRoll);
		setDieMultiplier(dieMultiplier);
		setMaxLevel(maxLevel);
		setPerLevel(perLevel);
		setTypeOfDamage(typeOfDamage);
		setEffects(effects == null ? new ArrayList<Effect>() : effects);
		setMaxTargets(maxTargets);
		setStun(stun);
		setStunChance(stunChance);
	}

	@Override
	public void play(Combatant player, ArrayList<Combatant> targets)
	{
		super.play(player, targets);
		String output = "";
		if (targets.size() > getMaxTargets())
		{
			output += "Number of targets greater than max targets. Removing all targets after max number in " +
					"the array of targets\n";
			while (targets.size() > getMaxTargets())
			{
				targets.remove(getMaxTargets());
			}
		}
		int damage = 0;
		int rollMultiplier = isPerLevel() ? Math.min(getMaxLevel(), player.getLevel()) :
				getDieMultiplier();
		for (int x = 0; x < targets.size(); x++)
		{
			int ice = 0, fire = 0, poison = 0, shock = 0, physical = 0;
			Combatant target = targets.get(x);
			if (!target.isHasDefender())
			{
				for (int i = 0; i < rollMultiplier; i++)
				{
					switch (getTypeOfDamage())
					{
						case ICE:
							ice += getDieToRoll().roll();
							break;
						case FIRE:
							fire += getDieToRoll().roll();
							break;
						case POISON:
							poison += getDieToRoll().roll();
							break;
						case SHOCK:
							shock += getDieToRoll().roll();
							break;
						case PHYSICAL:
							physical += getDieToRoll().roll();
					}
				}
				target.takeDamage(player, physical, poison, ice, fire, 0, shock, 0);
				for (Effect e : getEffects())
				{
					e.setCreator(player);
					target.addEffect(e);
				}
				if (isStun())
				{
					if (Dice.percentageRoll(getStunChance()))
					{
						target.setStunned(true);
					}
				}
			}
			else
			{
				for (int i = 0; i < rollMultiplier; i++)
				{
					damage += getDieToRoll().roll();
				}
				Defender tempDefender = null;
				if (target.getCurrentDefenders().size() > 1)
				{ // won't be used most likely
					tempDefender = target.getRandomDefender();
				}
				else
				{
					tempDefender = target.getCurrentDefenders().get(0);
				}
				if (tempDefender.takeDamage(damage))
				{
					target.removeDefender();
				}
			}
		}
		CommonFunctions.say(output);
	}

	@Override
	public void remove(Combatant combatant)
	{
		super.remove(combatant);
	}

	public int getMaxLevel()
	{
		return maxLevel;
	}

	public void setMaxLevel(int maxLevel)
	{
		this.maxLevel = maxLevel;
	}

	public int getDieMultiplier()
	{
		return dieMultiplier;
	}

	public void setDieMultiplier(int dieMultiplier)
	{
		this.dieMultiplier = dieMultiplier;
	}

	public int getMaxTargets()
	{
		return maxTargets;
	}

	public void setMaxTargets(int maxTargets)
	{
		this.maxTargets = maxTargets;
	}

	public int getStunChance()
	{
		return stunChance;
	}

	public void setStunChance(int stunChance)
	{
		this.stunChance = stunChance;
	}

	public boolean isStun()
	{
		return stun;
	}

	public void setStun(boolean stun)
	{
		this.stun = stun;
	}

	public boolean isPerLevel()
	{
		return perLevel;
	}

	public void setPerLevel(boolean perLevel)
	{
		this.perLevel = perLevel;
	}

	public Die getDieToRoll()
	{
		return dieToRoll;
	}

	public void setDieToRoll(Die dieToRoll)
	{
		this.dieToRoll = dieToRoll;
	}

	public DamageTypes getTypeOfDamage()
	{
		return typeOfDamage;
	}

	public void setTypeOfDamage(DamageTypes typeOfDamage)
	{
		this.typeOfDamage = typeOfDamage;
	}

	public ArrayList<Effect> getEffects()
	{
		return effects;
	}

	public void setEffects(ArrayList<Effect> effects)
	{
		this.effects = effects;
	}
}
