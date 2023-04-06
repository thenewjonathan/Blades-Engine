package com.thenewjonathan.enums;

import com.thenewjonathan.objects.actions.Disarm;
import com.thenewjonathan.objects.actions.FaceThrust;
import com.thenewjonathan.objects.actions.SoftSpot;
import com.thenewjonathan.objects.actions.Taunt;
import com.thenewjonathan.objects.usables.Card;
import com.thenewjonathan.objects.usables.Effect;

public enum Actions
{
	// Arcane (red wizard only)
	faceThrust(new FaceThrust("Face Thrust", 1, 5, 4, true, false), null,
			"Strike enemy in the face with the end of your staff"),
	disarm(new Disarm("Disarm", 1, 15, 7, true, false), null, "Disarm enemy"),
	softSpot(new SoftSpot("Soft Spot", 1, 15, 10, true, false), null, "Strike enemy in the throat with the " +
			"end of your staff. Triple damage and enemy is stunned for one round"),
	taunt(new Taunt("Taunt", 1, 5, 4, true, true), null, "Enrage enemy to cause them to make a mistake");

	private Card action;
	private Effect effect;
	private String description;
	Actions(Card action, Effect effect, String description)
	{
		setAction(action);
		setEffect(effect);
		setDescription(description);

	}

	public static Card getActionByName(String name)
	{
		for (Actions a : values())
		{
			if (a.getAction().getName().equalsIgnoreCase(name))
			{
				return a.getAction();
			}
		}
		return null;
	}

	@Override
	public String toString()
	{
		return getAction().getName();
	}

	public Card getAction()
	{
		return action;
	}

	public void setAction(Card action)
	{
		this.action = action;
	}

	public Effect getEffect()
	{
		return effect;
	}

	public void setEffect(Effect effect)
	{
		this.effect = effect;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

}
