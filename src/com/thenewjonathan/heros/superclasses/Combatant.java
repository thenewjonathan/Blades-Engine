package com.thenewjonathan.heros.superclasses;

import com.thenewjonathan.enums.*;
import com.thenewjonathan.heros.classes.*;
import com.thenewjonathan.interfaces.ICard;
import com.thenewjonathan.objects.usables.*;
import com.thenewjonathan.userinterface.CommonFunctions;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Random;

public class Combatant
{
	Random rand = new Random();
	private String name;
	private Genders gender;
	private int level;
	private int strength;
	private int agility;
	private int intelligence;
	private int accuracy;
	private int wisdom;
	private int constitution;
	private int weaponProficiency;
	private int will;
	private ArrayList<WeaponTypes> weaponProficiencyTypes;
	private int strengthMod;
	private int agilityMod;
	private int intelligenceMod;
	private int accuracyMod;
	private int wisdomMod;
	private int constitutionMod;
	private int weaponProficiencyMod;
	private int willMod;
	private int attackMod;
	private int xp;
	private int damageModifier;
	private int shockDamageModifier;
	private int fireDamageModifier;
	private int coldDamageModifier;
	private int poisonDamageModifier;
	private int diseaseDamageModifier;
	private int currentDamageModifierPercent;
	private int damageModifierPercent;
	private int shockDamageModifierPercent;
	private int fireDamageModifierPercent;
	private int coldDamageModifierPercent;
	private int poisonDamageModifierPercent;
	private int diseaseDamageModifierPercent;
	private int magicResistance; // % meant to mitigate damage from spells no
	// matter what kind of damage it is
	private int currentPower;
	private int currentDefense;
	private int currentLife;
	private int currentStamina;
	private int currentHitChance;
	private int currentDamageBuffer;
	private int maxLife;
	private int maxStamina;
	private int stoneIntegrity;
	private int hardness;
	private boolean unarmed;
	private boolean dead;
	private boolean ignoreDefenders;
	private boolean ignoreArmor;
	private boolean dualWield;
	private boolean hasDefender;
	private boolean stunned;
	private boolean petrified;
	private boolean shattered;
	private boolean ignoreDamage;
	private boolean attackedThisRound;
	private boolean immortal;
	private boolean preventHeal;
	private ArrayList<Trap> currentTraps;
	private ArrayList<Effect> currentEffects;
	private ArrayList<Defender> currentDefenders;
	private ArrayList<Card> library;
	private ArrayList<Card> cardsInDeck;
	private ArrayList<Card> cardsInPlay;
	private ArrayList<Card> cardsInHand;
	private ArrayList<Card> cardsInDiscard;
	private ArrayList<Ability> abilities;
	private ArrayList<Ability> abilityEffects;
	private ArrayList<String> lastDeckPlayed;
	private ArrayList<Weapon> weaponsInPlay;
	private ArrayList<Armor> armorInPlay;
	private ArrayList<Weapon> weaponsCache;
	private ArrayList<Armor> armorCache;
	private ArrayList<Combatant> illegalTargets;
	private Combatant nextTarget;
	private Combatant altTarget;
	private ICard lastCardPlayed;

	public Combatant()
	{
		setName("No Name");
		setGender(Genders.MALE);
		setLevel(1);
		setWeaponProficiencyTypes(new ArrayList<WeaponTypes>());
		setCurrentTraps(new ArrayList<Trap>());
		setCurrentEffects(new ArrayList<Effect>());
		setCurrentDefenders(new ArrayList<Defender>());
		setCardsInDeck(new ArrayList<Card>());
		setCardsInPlay(new ArrayList<Card>());
		setCardsInHand(new ArrayList<Card>());
		setArmorCache(new ArrayList<Armor>());
		setWeaponsCache(new ArrayList<Weapon>());
		setAbilities(new ArrayList<Ability>());
		setAbilityEffects(new ArrayList<Ability>());
		setCardsInDiscard(new ArrayList<Card>());
		setLibrary(new ArrayList<Card>());
		setLastDeckPlayed(new ArrayList<String>());
		setIllegalTargets(new ArrayList<Combatant>());
		setWeaponsInPlay(new ArrayList<Weapon>());
		setArmorInPlay(new ArrayList<Armor>());
		setModifiers();
		initializeStats();
		setUnarmed(true);
		updateStats();
	}

	public Combatant(String name, Genders gender, int level, int strength, int agility, int intelligence, int accuracy,
	                 int wisdom, int constitution, int will, int weaponProficiency, ArrayList<WeaponTypes> weaponProficiencyTypes, int xp,
	                 ArrayList<Weapon> weapons, ArrayList<Armor> armor)
	{
		this();
		setName(name);
		setGender(gender);
		setLevel(level);
		setStrength(strength);
		setAgility(agility);
		setIntelligence(intelligence);
		setAccuracy(accuracy);
		setWisdom(wisdom);
		setConstitution(constitution);
		setWeaponProficiency(weaponProficiency);
		setWeaponProficiencyTypes(weaponProficiencyTypes);
		setWill(will);
		setXp(xp);
		setWeaponsInPlay(weapons);
		setArmorInPlay(armor);
		setHardness(10);
		if (getWeaponsInPlay().size() <= 0)
		{
			setUnarmed(true);
		}
		else
		{
			setUnarmed(false);
		}
	}

	@Override
	public String toString()
	{
		return "(Level " + getLevel() + " " + getClass().getSimpleName() + ") " + getName();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (!(obj.getClass().equals(this.getClass())))
		{
			return false;
		}
		Combatant c = (Combatant) obj;
		return (getName().equals(c.getName()));
	}

	public Combatant clone()
	{
		Combatant c = new Combatant(getName(), getGender(), getLevel(), getStrength(), getAgility(), getIntelligence(),
				getAccuracy(), getWisdom(), getConstitution(), getWill(), getWeaponProficiency(),
				getWeaponProficiencyTypes(), getXp(), getWeaponsInPlay(), getArmorInPlay());
		copyArrays(c);
		return c;
	}

	public void copyArrays(Combatant c)
	{
		c.setArmorCache(getArmorCache());
		c.setWeaponsCache(getWeaponsCache());
		c.setLastDeckPlayed(getLastDeckPlayed());
		c.setLibrary(getLibrary());
		c.setWeaponProficiencyTypes(getWeaponProficiencyTypes());
		c.setCurrentTraps(getCurrentTraps());
		c.setCurrentEffects(getCurrentEffects());
		c.setCurrentDefenders(getCurrentDefenders());
		c.setCardsInDeck(getCardsInDeck());
		c.setCardsInPlay(getCardsInPlay());
		c.setCardsInHand(getCardsInHand());
		c.setAbilities(getAbilities());
		c.setAbilityEffects(getAbilityEffects());
		c.setCardsInDiscard(getCardsInDiscard());
		c.setIllegalTargets(getIllegalTargets());
		c.setWeaponsInPlay(getWeaponsInPlay());
		c.setArmorInPlay(getArmorInPlay());
	}

	// support
	public void initializeStats()
	{ // calculate all current stats to start a
		// fight with
		setModifiers();
		// power
		setCurrentPower(getStrengthMod() + getWeaponProficiencyMod());
		// hit chance
		setCurrentHitChance(getAccuracyMod() + getWeaponProficiencyMod());
		// defense
		setCurrentDefense(getAgilityMod() + getWisdomMod() + getArmorBonus());
		// life
		setCurrentLife(getConstitution() * 2);
		setMaxLife(getCurrentLife());
		// stamina
		int staminaMod = (10 * getConstitutionMod()) + (10 * getWillMod());
		setCurrentStamina(30 + staminaMod);
		setMaxStamina(getCurrentStamina());
	}

	public void updateStats()
	{
		setModifiers();
		// power
		setCurrentPower(getStrengthMod() + getWeaponProficiencyMod());
		// hit chance
		setCurrentHitChance(getAccuracyMod() + getWeaponProficiencyMod());
		// defense
		setCurrentDefense(getAgilityMod() + getWisdomMod() + getArmorBonus());
		setMaxLife(getCurrentLife());
	}

	public void addIllegalTarget(Combatant c)
	{
		if (illegalTargets == null)
		{
			illegalTargets = new ArrayList<Combatant>();
		}
		illegalTargets.add(c);
	}

	public boolean removeIllegalTarget(Combatant c)
	{
		if (illegalTargets == null || !illegalTargets.contains(c))
		{
			return false;
		}
		illegalTargets.remove(c);
		return true;
	}

	public void setModifiers()
	{
		setStrengthMod((getStrength() / 50) - 1);
		setAgilityMod((getAgility() / 100) - 1);
		setConstitutionMod((getConstitution() / 50) - 1);
		setIntelligenceMod((getIntelligence() / 100) - 1);
		setAccuracyMod((getAccuracy() / 50) - 1);
		setWisdomMod((getWisdom() / 50) - 1);
		int wpMod = 0;
		if (!isUnarmed() && isUsingPreferredWeapon())
		{
			wpMod = (getWeaponProficiency() / 50) - 1;
		}
		setWeaponProficiencyMod(wpMod);
		setWillMod((getWill() / 50) - 1);
		if (getAgilityMod() <= 0)
		{
			setAttackMod(1);
		}
		else
		{
			setAttackMod(getAgilityMod());
		}
	}

	public int getArmorBonus()
	{
		if (getArmorInPlay().size() <= 0)
		{
			return 0;
		}
		int bonus = 0;
		for (Armor a : getArmorInPlay())
		{
			bonus += a.getDefenseModifier();
		}
		return bonus;
	}

	public boolean isUsingPreferredWeapon()
	{
		if (getWeaponsInPlay().size() > 0)
		{
			for (Weapon w : getWeaponsInPlay())
			{
				for (WeaponTypes type : getWeaponProficiencyTypes())
				{
					if (w.getType().equals(type))
					{
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean startsWithVowel(String str)
	{
		return str.startsWith("A") || str.startsWith("E") || str.startsWith("I") || str.startsWith("O") ||
				str.startsWith("U");
	}

	public boolean hasArmorOn()
	{
		for (Armor a : getArmorInPlay())
		{
			if (a.getType().equals(ArmorTypes.HEAVY) || a.getType().equals(ArmorTypes.MEDIUM) ||
					a.getType().equals(ArmorTypes.LIGHT))
			{
				return true;
			}
		}
		return false;
	}

	public boolean hasHelmetOn()
	{
		for (Armor a : getArmorInPlay())
		{
			if (a.getType().equals(ArmorTypes.HELMET))
			{
				return true;
			}
		}
		return false;
	}

	public boolean hasGreavesOn()
	{
		for (Armor a : getArmorInPlay())
		{
			if (a.getType().equals(ArmorTypes.GREAVE))
			{
				return true;
			}
		}
		return false;
	}

	public boolean hasGauntletsOn()
	{
		for (Armor a : getArmorInPlay())
		{
			if (a.getType().equals(ArmorTypes.GAUNTLET))
			{
				return true;
			}
		}
		return false;
	}

	public boolean hasShieldOn()
	{
		for (Armor a : getArmorInPlay())
		{
			if (a.getType().equals(ArmorTypes.HELMET))
			{
				return true;
			}
		}
		return false;
	}

	public boolean hasWizardOn()
	{
		for (Armor a : getArmorInPlay())
		{
			if (a.getType().equals(ArmorTypes.WIZARD))
			{
				return true;
			}
		}
		return false;
	}

	public void attackDamageRoll(boolean doubleDamage, Combatant target)
	{
		if (getWeaponsInPlay().size() <= 0)
		{
			int damage = (this instanceof Monk) ? Dice.DD4.getDie().roll() : Dice.D4.getDie().roll();
			target.takeDamage(this, doubleDamage ? damage * 2 : damage, 0, 0, 0, 0, 0, 0);
		}
		else
		{
			for (Weapon w : getWeaponsInPlay())
			{
				if (w instanceof MagicWeapon)
				{
					w.swing(this, target, doubleDamage);
				}
				else
				{
					w.swing(this, target, doubleDamage);
				}
			}
		}
	}

	public int getLifePercentage()
	{
		return (getCurrentLife() * 100) / getMaxLife();
	}

	public Defender getCurrentDefender()
	{
		return getCurrentDefenders().size() <= 0 ? null : getCurrentDefenders().get(0);
	}

	public boolean hasEffects()
	{
		return getCurrentEffects() != null && getCurrentEffects().size() > 0;
	}

	// functional
	public void attack(Combatant target)
	{
		if (target.isDead())
		{
			CommonFunctions.say(target.getName() + " is dead already");
			return;
		}
		CommonFunctions.say(this + " is attacking " + target);
		if (getNextTarget() != null)
		{
			target = getNextTarget();
			setNextTarget(null);
		}
		if (hasAttackedThisRound())
		{
			CommonFunctions.say(target + " has already attacked this turn");
			return;
		}
		if ((getIllegalTargets().size() > 0) && getIllegalTargets().contains(target))
		{
			CommonFunctions.say(target + " may not be targeted by you this round");
			return;
		}
		setAttackedThisRound(true);
		String output = "";
		if (target.getCurrentTraps().size() > 0)
		{
			target.executeTraps(this);
		}
		// see if the attacker hit the target
		if(isStunned() || isDead() || isPetrified() || isShattered())
		{
			return;
		}
		int attackRoll = Dice.D20.getDie().roll();
		boolean crit = attackRoll + getAccuracyMod() >= 20;
		if (attackRoll == 1)
		{
			if ((getWeaponsInPlay().size() <= 0) || !getWeaponsInPlay().get(0).isRanged())
			{
				target.counterAttack(this);
			}
			CommonFunctions.say("Miss\n" + output);
			return;
		}
		// distribute damage out to defenders (no trample)
		if (target.isHasDefender() && !isIgnoreDefenders())
		{
			for (int i = 0; i < getAttackMod(); i++)
			{
				if (getWeaponsInPlay().size() <= 0)
				{
					if (this instanceof Monk)
					{
						target.getCurrentDefender().takeDamage(Dice.DD4.getDie().roll());
					}
					else
					{
						target.getCurrentDefender().takeDamage(Dice.D4.getDie().roll()); // un armed combat damage
					}
				}
				else
				{
					for (Weapon w : getWeaponsInPlay())
					{
						if (w instanceof MagicWeapon)
						{
							w.swing(this, target.getCurrentDefender(), crit);
						}
						else
						{
							w.swing(this, target.getCurrentDefender(), attackRoll == 20);
						}
					}
				}
			}
			int defenderPower = target.getCurrentDefenders().get(0).getAttack();
			if (defenderPower > 0)
			{
				takeDamage(this, defenderPower, 0, 0, 0, 0, 0, 0);
				output += getName() + " took " + defenderPower + " damage from the defender";
			}
			if (target.getCurrentDefender().getLife() <= 0)
			{
				target.removeDefender();
				return;
			}
			return;
		}
		int defenderScore = 10 + target.getAgilityMod();
		if (!isIgnoreArmor())
		{
			defenderScore += target.getArmorBonus();
		}
		int attackerScore = attackRoll + getCurrentHitChance();
		if (defenderScore > attackerScore)
		{ // attacker missed
			if (((getWeaponsInPlay().size() == 0) || !getWeaponsInPlay().get(0).isRanged()) && !target.isStunned())
			{
				CommonFunctions.say(output + this + " missed");
				target.counterAttack(this);
				return;
			}
			else
			{
				CommonFunctions.say(output + " " + this + " missed");
				return;
			}
		}
		// actually attack the target
		for (int i = 0; i < getAttackMod(); i++)
		{
			if (i == 0)
			{
				CommonFunctions.say("Attack number " + (i+1));
				attackDamageRoll(crit, target);
			}
			else
			{
				CommonFunctions.say("Attack number " + (i + 1));
				attackRoll = Dice.D20.getDie().roll() + getCurrentHitChance();
				defenderScore -= 2;
				if (defenderScore < attackRoll)
				{
					CommonFunctions.say("Attack number " + (i + 1));
					attackDamageRoll(attackRoll == 20, target);
				}
				else
				{
					CommonFunctions.say("Attack number " + (i + 1) + " missed");
				}
			}
		}
		// counter attack
		if (!target.isStunned() && (getWeaponsInPlay().size() > 0) && !getWeaponsInPlay().get(0).isRanged())
		{
			target.counterAttack(this);
		}
	}

	public void executeTraps(Combatant target)
	{
		if (getCurrentTraps().size() > 0)
		{
			int trapsSize = getCurrentTraps().size();
			for (int i = 0; i < trapsSize; i++)
			{
				getCurrentTraps().get(0).executeTrap(target);
				getCurrentTraps().remove(0);
			}
		}
	}

	public void executeEffects()
	{
		if (getCurrentEffects().size() > 0)
		{
			for (int i = 0; i < getCurrentEffects().size(); i++)
			{
				if (getCurrentEffects().get(i).execute(this))
				{
					getCurrentEffects().remove(i--);
				}
			}
		}
	}

	public void counterAttack(Combatant target)
	{
		// hit chance
		int attackRoll = Dice.D20.getDie().roll();
		int defenderScore = 10 + target.getAgilityMod() + target.getArmorBonus();
		int attackerScore = attackRoll + getCurrentHitChance();
		if ((defenderScore > attackerScore) || (attackRoll == 1))
		{
			CommonFunctions.say("Counter attack missed");
			return;
		}
		// calculate damage
		attackDamageRoll(attackRoll == 20, target);
	}

	public void takeStamina(int cost)
	{
		currentStamina -= cost;
	}

	public void addStamina(int stamina)
	{
		if (currentStamina + stamina > maxStamina)
		{
			stamina = maxStamina;
		}
		currentStamina += stamina;
	}

	public void addCardToLibrary(Card c)
	{
		library.add(c);
	}

	public void addWeaponToCache(Weapon w)
	{
		weaponsCache.add(w);
	}

	public void addArmorToCache(Armor a)
	{
		armorCache.add(a);
	}

	public void drawCard()
	{
		Card drawnCard = cardsInDeck.get(rand.nextInt(cardsInDeck.size()));
		cardsInHand.add(drawnCard);
		cardsInDeck.remove(drawnCard);
		CommonFunctions.say("Drew " + drawnCard);
	}

	public void addWeaponProficiencyTypes(WeaponTypes type)
	{
		getWeaponProficiencyTypes().add(type);
	}

	public Defender getRandomDefender()
	{
		if (!isHasDefender())
		{
			return null;
		}
		else
		{
			return getCurrentDefenders().get(rand.nextInt(getCurrentDefenders().size()));
		}
	}

	public void addEffect(Effect e)
	{
		getCurrentEffects().add(e);
		CommonFunctions.say("Added " + e + " (" + e.getStartingPoint() + ", " + e.getDuration() + ")");
	}

	public boolean addDefender(Defender d)
	{
		if (isHasDefender())
		{
			return false;
		}
		getCurrentDefenders().add(d);
		setHasDefender(true);
		return true;
	}

	public void removeDefender()
	{
		Defender d = getCurrentDefenders().get(0);
		if (!isHasDefender())
		{
			CommonFunctions.say("No defenders are currently in place");
			return;
		}
		if (getCurrentDefenders().remove(d))
		{
			setHasDefender(false);
			CommonFunctions.say("Your " + d + " has been defeated");
		}
		else
		{
			CommonFunctions.say("error removing defender");
		}
	}

	public void takeDamage(Combatant attacker, int physical, int poison, int cold, int fire, int disease, int shock,
	                       int drain)
	{
		// damage shock fire cold poison disease
		int damage = 0;
		if (physical > 0)
		{
			physical = (attacker != null) ? physical + attacker.getCurrentPower() : physical;
			physical *= ((100 - getDamageModifierPercent()) / 100);
			physical -= getDamageModifier();
			if (getCurrentDamageBuffer() > 0)
			{
				int damageBuff = getCurrentDamageBuffer();
				int tempDamage = physical;
				physical = (physical - damageBuff) < 0 ? 0 : physical - damageBuff;
				setCurrentDamageBuffer((damageBuff - tempDamage) < 0 ? 0 : damageBuff - tempDamage);
			}
			if (isPetrified())
			{
				physical -= getHardness();
			}
			damage += physical;
			CommonFunctions.say(physical + " physical damage attempt");
		}
		if ((poison > 0) && !isPetrified())
		{
			poison *= ((100 - getPoisonDamageModifierPercent()) / 100);
			damage += poison - getPoisonDamageModifier();
			CommonFunctions.say(poison + " poison damage attempt");
		}
		if ((cold > 0) && !isPetrified())
		{
			cold *= ((100 - getColdDamageModifierPercent()) / 100);
			damage += cold - getColdDamageModifier();
			CommonFunctions.say(cold + " cold damage attempt");
		}
		if ((fire > 0) && !isPetrified())
		{
			fire *= ((100 - getFireDamageModifierPercent()) / 100);
			damage += fire - getFireDamageModifier();
			CommonFunctions.say(fire + " fire damage attempt");
		}
		if ((disease > 0) && !isPetrified())
		{
			disease *= ((100 - getDiseaseDamageModifierPercent()) / 100);
			damage += disease - getDiseaseDamageModifier();
			CommonFunctions.say(disease + " disease damage attempt");
		}
		if ((shock > 0) && !isPetrified())
		{
			shock *= ((100 - getShockDamageModifierPercent()) / 100);
			damage += shock - getShockDamageModifier();
			CommonFunctions.say(shock + " shock damage attempt");
		}
		if ((attacker != null) && (drain > 0) && !isPetrified())
		{
			damage = drain;
			CommonFunctions.say(attacker + " attempting to drain " + drain + " life from " + getName());
		}
		if (!isIgnoreDamage())
		{
			if (isPetrified())
			{
				setStoneIntegrity(getStoneIntegrity() - physical);
				if (getStoneIntegrity() <= 0)
				{
					CommonFunctions.say(getName() + " has been shattered");
					setStoneIntegrity(0);
					setDead(true);
					setShattered(true);
				}
				else
				{
					CommonFunctions.say(getName() + "'s stone integrity reduced by " + damage);
				}
			}
			else
			{
				// set magic resistance
				if (this instanceof BlackWizard || this instanceof WhiteWizard || this instanceof BlueWizard ||
						this instanceof RedWizard || this instanceof RaoFollower || this instanceof HextorFollower ||
						this instanceof ElementalBlade || this instanceof ShadowDancer)
				{
					if (physical <= 0)
					{
						damage *= 0.75;
					}
				}
				setCurrentLife(getCurrentLife() - damage);
				if (drain > 0)
				{
					attacker.gainLife(damage);
				}
				if (getCurrentLife() <= 0)
				{
					if (isImmortal())
					{
						setCurrentLife(1);
						CommonFunctions.say(getName() + " ignored the pain of death");
					}
					else
					{
						setCurrentLife(0);
						setDead(true);
					}
				}
				CommonFunctions.say(damage + " taken");
			}
		}
		else
		{
			CommonFunctions.say(getName() + " ignored the damage");
		}
	}

	public void gainLife(int life)
	{
		if (!isPreventHeal())
		{
			if (getCurrentLife() <= 0)
			{
				setDead(false);
				setPetrified(false);
				CommonFunctions.say(this + " has been ressurected");
			}
			setCurrentLife(getCurrentLife() + life);
		}
		else
		{
			CommonFunctions.say(this + " does not have the ability to be healed");
		}
	}

	public boolean addTrap(Trap t)
	{
		if (t.getLevel() <= getLevel())
		{
			getCurrentTraps().add(t);
			return true;
		}
		return false;
	}

	public String putOnArmor(Armor armor)
	{
		switch (armor.getType())
		{
			case LIGHT:
			case MEDIUM:
			case HEAVY:
				if (hasArmorOn())
				{
					return "You must remove your current armor before donning this set";
				}
				break;
			case SHIELD:
				if (hasShieldOn())
				{
					return "You must first remove your current shield before using this one";
				}
				break;
			case GREAVE:
				if (hasGreavesOn())
				{
					return "You mush first remove your current greaves before donning these";
				}
				break;
			case GAUNTLET:
				if (hasGauntletsOn())
				{
					return "You must first remove your current gauntlets before donning these";
				}
				break;
			case HELMET:
				if (hasHelmetOn())
				{
					return "You must first remove your current helmet before donning this one";
				}
				break;
			case WIZARD:
				if (hasWizardOn())
				{
					return "You must first remove your current robe before donning this one";
				}
				break;
			default:
				return "error when determining the type of armor";
		}
		if (armor.getLevel() <= getLevel())
		{
			getArmorInPlay().add(armor);
			if (armor instanceof MagicArmor)
			{
				CommonFunctions.say(armor + " is magic");
				armor.applyBonus(this);
			}
			updateStats();
			return "Donned the " + armor;
		}
		else
		{
			return "You are not high enough level to wear the " + armor;
		}
	}

	public boolean takeOffArmor(Armor armor)
	{
		boolean success = getArmorInPlay().remove(armor);
		if (armor instanceof MagicArmor)
		{
			armor.removeBonus(this);
		}
		updateStats();
		return success;
	}

	public String pickUpWeapon(Weapon weapon)
	{
		if (getWeaponsInPlay().size() >= 2)
		{
			return "Your hands are full.";
		}
		else if ((getWeaponsInPlay().size() == 1) && !isDualWield())
		{
			return "You need to unlock 'Dual Wield' before" + " you can wield two weapons at once";
		}
		else if (weapon.getLevel() <= getLevel())
		{
			getWeaponsInPlay().add(weapon);
			if (weapon instanceof MagicWeapon)
			{
				if (((MagicWeapon) weapon).isIgnoreArmor())
				{
					setIgnoreArmor(true);
				}
			}
			setUnarmed(false);
			updateStats();
			if (startsWithVowel(weapon.getName()))
			{
				return "Picked up an " + weapon;
			}
			else
			{
				return "Picked up a " + weapon;
			}
		}
		else
		{
			return "You are not high enough level to use the " + weapon;
		}
	}

	public boolean dropWeapon(Weapon weapon)
	{
		boolean success = getWeaponsInPlay().remove(weapon);
		if (weapon instanceof MagicWeapon)
		{
			if (((MagicWeapon) weapon).isIgnoreArmor())
			{
				setIgnoreArmor(false);
			}
		}
		if (getWeaponsInPlay().size() <= 0)
		{
			setUnarmed(true);
		}
		updateStats();
		return success;
	}

	public void addAbilityEffect(Ability a)
	{
		abilityEffects.add(a);
	}

	public Ability getAbilityByName(String name)
	{
		if (getAbilities().size() <= 0)
		{
			CommonFunctions.say("Hero has no abilities");
			return null;
		}
		for (Ability a : getAbilities())
		{
			if (a.getName().equalsIgnoreCase(name))
			{
				return a;
			}
		}
		CommonFunctions.say("Error finding ability " + name);
		return null;
	}

	// getter and setters
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Genders getGender()
	{
		return gender;
	}

	public void setGender(Genders gender)
	{
		this.gender = gender;
	}

	public int getLevel()
	{
		return level;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

	public int getStrength()
	{
		return strength;
	}

	public void setStrength(int strength)
	{
		this.strength = strength;
	}

	public int getAgility()
	{
		return agility;
	}

	public void setAgility(int agility)
	{
		this.agility = agility;
	}

	public int getIntelligence()
	{
		return intelligence;
	}

	public void setIntelligence(int intelligence)
	{
		this.intelligence = intelligence;
	}

	public int getAccuracy()
	{
		return accuracy;
	}

	public void setAccuracy(int accuracy)
	{
		this.accuracy = accuracy;
	}

	public int getWisdom()
	{
		return wisdom;
	}

	public void setWisdom(int wisdom)
	{
		this.wisdom = wisdom;
	}

	public int getConstitution()
	{
		return constitution;
	}

	public void setConstitution(int constitution)
	{
		double percentageLife = 100;
		if (this.constitution > 0)
		{
			percentageLife = (constitution * 100) / this.constitution;
		}
		this.constitution = constitution;
		if (this.constitution > 0)
		{
			maxLife *= percentageLife / 100;
		}
	}

	public int getWeaponProficiency()
	{
		return weaponProficiency;
	}

	public void setWeaponProficiency(int weaponProficiency)
	{
		this.weaponProficiency = weaponProficiency;
	}

	public int getWill()
	{
		return will;
	}

	public void setWill(int will)
	{
		this.will = will;
	}

	public ArrayList<WeaponTypes> getWeaponProficiencyTypes()
	{
		return weaponProficiencyTypes;
	}

	public void setWeaponProficiencyTypes(ArrayList<WeaponTypes> weaponProficienctyTypes)
	{
		weaponProficiencyTypes = weaponProficiencyTypes == null ? new ArrayList<WeaponTypes>() : weaponProficiencyTypes;
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

	public int getWisdomMod()
	{
		return wisdomMod;
	}

	public void setWisdomMod(int wisdomMod)
	{
		this.wisdomMod = wisdomMod;
	}

	public int getConstitutionMod()
	{
		return constitutionMod;
	}

	public void setConstitutionMod(int constitutionMod)
	{
		this.constitutionMod = constitutionMod;
	}

	public int getWeaponProficiencyMod()
	{
		return weaponProficiencyMod;
	}

	public void setWeaponProficiencyMod(int weaponProficiencyMod)
	{
		this.weaponProficiencyMod = weaponProficiencyMod;
	}

	public int getWillMod()
	{
		return willMod;
	}

	public void setWillMod(int willMod)
	{
		this.willMod = willMod;
	}

	public int getAttackMod()
	{
		return attackMod;
	}

	public void setAttackMod(int attackMod)
	{
		this.attackMod = attackMod;
	}

	public int getXp()
	{
		return xp;
	}

	public void setXp(int xp)
	{
		this.xp = xp;
	}

	public int getDamageModifier()
	{
		return damageModifier;
	}

	public void setDamageModifier(int damageModifier)
	{
		this.damageModifier = damageModifier;
	}

	public int getShockDamageModifier()
	{
		return shockDamageModifier;
	}

	public void setShockDamageModifier(int shockDamageModifier)
	{
		this.shockDamageModifier = shockDamageModifier;
	}

	public int getFireDamageModifier()
	{
		return fireDamageModifier;
	}

	public void setFireDamageModifier(int fireDamageModifier)
	{
		this.fireDamageModifier = fireDamageModifier;
	}

	public int getColdDamageModifier()
	{
		return coldDamageModifier;
	}

	public void setColdDamageModifier(int coldDamageModifier)
	{
		this.coldDamageModifier = coldDamageModifier;
	}

	public int getPoisonDamageModifier()
	{
		return poisonDamageModifier;
	}

	public void setPoisonDamageModifier(int poisonDamageModifier)
	{
		this.poisonDamageModifier = poisonDamageModifier;
	}

	public int getDiseaseDamageModifier()
	{
		return diseaseDamageModifier;
	}

	public void setDiseaseDamageModifier(int diseaseDamageModifier)
	{
		this.diseaseDamageModifier = diseaseDamageModifier;
	}

	public int getDamageModifierPercent()
	{
		return damageModifierPercent;
	}

	public void setDamageModifierPercent(int damageModifierPercent)
	{
		this.damageModifierPercent = damageModifierPercent;
	}

	public int getShockDamageModifierPercent()
	{
		return shockDamageModifierPercent;
	}

	public void setShockDamageModifierPercent(int shockDamageModifierPercent)
	{
		this.shockDamageModifierPercent = shockDamageModifierPercent;
	}

	public int getFireDamageModifierPercent()
	{
		return fireDamageModifierPercent;
	}

	public void setFireDamageModifierPercent(int fireDamageModifierPercent)
	{
		this.fireDamageModifierPercent = fireDamageModifierPercent;
	}

	public int getColdDamageModifierPercent()
	{
		return coldDamageModifierPercent;
	}

	public void setColdDamageModifierPercent(int coldDamageModifierPercent)
	{
		this.coldDamageModifierPercent = coldDamageModifierPercent;
	}

	public int getPoisonDamageModifierPercent()
	{
		return poisonDamageModifierPercent;
	}

	public void setPoisonDamageModifierPercent(int poisonDamageModifierPercent)
	{
		this.poisonDamageModifierPercent = poisonDamageModifierPercent;
	}

	public int getDiseaseDamageModifierPercent()
	{
		return diseaseDamageModifierPercent;
	}

	public void setDiseaseDamageModifierPercent(int diseaseDamageModifierPercent)
	{
		this.diseaseDamageModifierPercent = diseaseDamageModifierPercent;
	}

	public int getMagicResistance()
	{
		return magicResistance;
	}

	public void setMagicResistance(int magicResistance)
	{
		this.magicResistance = magicResistance;
	}

	public int getCurrentPower()
	{
		return currentPower;
	}

	public void setCurrentPower(int currentPower)
	{
		this.currentPower = currentPower;
	}

	public int getCurrentDefense()
	{
		return currentDefense;
	}

	public void setCurrentDefense(int currentDefense)
	{
		this.currentDefense = currentDefense;
	}

	public int getCurrentLife()
	{
		return currentLife;
	}

	public void setCurrentLife(int currentLife)
	{
		if (currentLife < 0)
		{
			currentLife = 0;
		}
		dead = currentLife == 0;
		this.currentLife = currentLife;
	}

	public int getCurrentStamina()
	{
		return currentStamina;
	}

	public void setCurrentStamina(int currentStamina)
	{
		this.currentStamina = currentStamina;
	}

	public int getCurrentHitChance()
	{
		return currentHitChance;
	}

	public void setCurrentHitChance(int currentHitChance)
	{
		this.currentHitChance = currentHitChance;
	}

	public int getCurrentDamageBuffer()
	{
		return currentDamageBuffer;
	}

	public void setCurrentDamageBuffer(int currentDamageBuffer)
	{
		this.currentDamageBuffer = currentDamageBuffer;
	}

	public int getCurrentDamageModifierPercent()
	{
		return currentDamageModifierPercent;
	}

	public void setCurrentDamageModifierPercent(int currentDamageBufferPercent)
	{
		currentDamageModifierPercent = currentDamageBufferPercent;
	}

	public int getMaxLife()
	{
		return maxLife;
	}

	public void setMaxLife(int maxLife)
	{
		this.maxLife = maxLife;
	}

	public int getMaxStamina()
	{
		return maxStamina;
	}

	public void setMaxStamina(int maxStamina)
	{
		this.maxStamina = maxStamina;
	}

	public int getStoneIntegrity()
	{
		return stoneIntegrity;
	}

	public void setStoneIntegrity(int stoneIntegrity)
	{
		this.stoneIntegrity = stoneIntegrity;
	}

	public int getHardness()
	{
		return hardness;
	}

	public void setHardness(int hardness)
	{
		this.hardness = hardness;
	}

	public boolean isUnarmed()
	{
		return unarmed;
	}

	public void setUnarmed(boolean unarmed)
	{
		this.unarmed = unarmed;
	}

	public boolean isDead()
	{
		return dead;
	}

	public void setDead(boolean dead)
	{
		this.dead = dead;
		if (!this.shattered)
		{
			CommonFunctions.say(getName() + " has been slain");
		}
	}

	public boolean isIgnoreDefenders()
	{
		return ignoreDefenders;
	}

	public void setIgnoreDefenders(boolean ignoreDefenders)
	{
		this.ignoreDefenders = ignoreDefenders;
	}

	public boolean isIgnoreArmor()
	{
		return ignoreArmor;
	}

	public void setIgnoreArmor(boolean ignoreArmor)
	{
		this.ignoreArmor = ignoreArmor;
	}

	public boolean isDualWield()
	{
		return dualWield;
	}

	public void setDualWield(boolean dualWield)
	{
		this.dualWield = dualWield;
	}

	public boolean isHasDefender()
	{
		return hasDefender;
	}

	public void setHasDefender(boolean hasDefender)
	{
		this.hasDefender = hasDefender;
	}

	public boolean isStunned()
	{
		return stunned;
	}

	public void setStunned(boolean stunned)
	{
		if (stunned)
		{
			CommonFunctions.say(this + " is stunned.");
		}
		this.stunned = stunned;
	}

	public boolean isPetrified()
	{
		return petrified;
	}

	public void setPetrified(boolean petrified)
	{
		this.petrified = petrified;
		if (petrified)
		{
			setStoneIntegrity(getCurrentLife() * 2);
			setCurrentEffects(new ArrayList<Effect>());
			setCardsInPlay(new ArrayList<Card>());
		}
		else
		{
			setStoneIntegrity(0);
		}
	}

	public void processAbilityEffects()
	{
		for (int i = 0; i < getAbilityEffects().size(); i++)
		{
			Ability a = getAbilityEffects().get(i);
			a.setDuration(a.getDuration() - 1);
			if (a.getDuration() <= 0 && Abilities.getAbilityByName(a.getName()) != null)
			{
				Abilities.getAbilityByName(a.getName()).remove(this);
			}
		}
	}

	public boolean isShattered()
	{
		return shattered;
	}

	public void setShattered(boolean shattered)
	{
		this.shattered = shattered;
	}

	public boolean isIgnoreDamage()
	{
		return ignoreDamage;
	}

	public void setIgnoreDamage(boolean ignoreDamage)
	{
		this.ignoreDamage = ignoreDamage;
	}

	public boolean hasAttackedThisRound()
	{
		return attackedThisRound;
	}

	public void setAttackedThisRound(boolean attackedThisRound)
	{
		this.attackedThisRound = attackedThisRound;
	}

	public boolean isImmortal()
	{
		return immortal;
	}

	public void setImmortal(boolean immortal)
	{
		this.immortal = immortal;
	}

	public boolean isPreventHeal()
	{
		return preventHeal;
	}

	public void setPreventHeal(boolean preventHeal)
	{
		this.preventHeal = preventHeal;
	}

	public ArrayList<Trap> getCurrentTraps()
	{
		return currentTraps;
	}

	public void setCurrentTraps(ArrayList<Trap> currentTraps)
	{
		this.currentTraps = currentTraps;
	}

	public ArrayList<Effect> getCurrentEffects()
	{
		return currentEffects;
	}

	public void setCurrentEffects(ArrayList<Effect> currentEffects)
	{
		this.currentEffects = currentEffects;
	}

	public ArrayList<Defender> getCurrentDefenders()
	{
		return currentDefenders;
	}

	public void setCurrentDefenders(ArrayList<Defender> currentDefenders)
	{
		this.currentDefenders = currentDefenders;
	}

	public ArrayList<Card> getLibrary()
	{
		return library;
	}

	public void setLibrary(ArrayList<Card> library)
	{
		this.library = library;
	}

	public ArrayList<Card> getCardsInDeck()
	{
		return cardsInDeck;
	}

	public void setCardsInDeck(ArrayList<Card> cardsInDeck)
	{
		this.cardsInDeck = cardsInDeck;
	}

	public ArrayList<Card> getCardsInPlay()
	{
		return cardsInPlay;
	}

	public void setCardsInPlay(ArrayList<Card> cardsInPlay)
	{
		this.cardsInPlay = cardsInPlay;
	}

	public ArrayList<Card> getCardsInHand()
	{
		return cardsInHand;
	}

	public void setCardsInHand(ArrayList<Card> cardsInHand)
	{
		this.cardsInHand = cardsInHand;
	}

	public ArrayList<Card> getCardsInDiscard()
	{
		return cardsInDiscard;
	}

	public void setCardsInDiscard(ArrayList<Card> cardsInDiscard)
	{
		this.cardsInDiscard = cardsInDiscard;
	}

	public ArrayList<Ability> getAbilities()
	{
		return abilities;
	}

	public void setAbilities(ArrayList<Ability> abilities)
	{
		this.abilities = abilities;
	}

	public ArrayList<Ability> getAbilityEffects()
	{
		return abilityEffects;
	}

	public void setAbilityEffects(ArrayList<Ability> abilityEffects)
	{
		this.abilityEffects = abilityEffects;
	}

	public ArrayList<String> getLastDeckPlayed()
	{
		return lastDeckPlayed;
	}

	public void setLastDeckPlayed(ArrayList<String> lastDeckPlayed)
	{
		this.lastDeckPlayed = lastDeckPlayed;
	}

	public ArrayList<Weapon> getWeaponsInPlay()
	{
		return weaponsInPlay;
	}

	public void setWeaponsInPlay(ArrayList<Weapon> weaponsInPlay)
	{
		this.weaponsInPlay = weaponsInPlay == null ? new ArrayList<Weapon>() : weaponsInPlay;
	}

	public ArrayList<Armor> getArmorInPlay()
	{
		return armorInPlay;
	}

	public void setArmorInPlay(ArrayList<Armor> armorInPlay)
	{
		this.armorInPlay = armorInPlay == null ? new ArrayList<Armor>() : armorInPlay;
	}

	public ArrayList<Weapon> getWeaponsCache()
	{
		return weaponsCache;
	}

	public void setWeaponsCache(ArrayList<Weapon> weaponsCache)
	{
		this.weaponsCache = weaponsCache;
	}

	public ArrayList<Armor> getArmorCache()
	{
		return armorCache;
	}

	public void setArmorCache(ArrayList<Armor> armorCache)
	{
		this.armorCache = armorCache;
	}

	public ArrayList<Combatant> getIllegalTargets()
	{
		return illegalTargets;
	}

	public void setIllegalTargets(ArrayList<Combatant> illegalTargets)
	{
		this.illegalTargets = illegalTargets;
	}

	public Combatant getNextTarget()
	{
		return nextTarget;
	}

	public void setNextTarget(Combatant nextTarget)
	{
		this.nextTarget = nextTarget;
	}

	public Combatant getAltTarget()
	{
		return altTarget;
	}

	public void setAltTarget(Combatant altTarget)
	{
		this.altTarget = altTarget;
	}

	public ICard getLastCardPlayed()
	{
		return lastCardPlayed;
	}

	public void setLastCardPlayed(ICard lastCardPlayed)
	{
		this.lastCardPlayed = lastCardPlayed;
	}

	public boolean hasWeapon()
	{
		return getWeaponsInPlay().size() > 0;
	}
}