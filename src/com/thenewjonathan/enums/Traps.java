package com.thenewjonathan.enums;

import com.thenewjonathan.objects.usables.Trap;
import com.thenewjonathan.objects.usables.customtraps.Snare;
import com.thenewjonathan.objects.usables.customtraps.SpringTrap;

public enum Traps
{
	cantrip(new Trap("Metal Trap", 1, 5, 0, 0, 0, 0), "Simple trap with metal shards."),
	iceTrap(new Trap("Ice Trap", 3, 0, 0, 0, 5, 0), "Releases a burst of cold into the face."),
	fireTrap(new Trap("Fire Trap", 3, 0, 0, 5, 0, 0), "Releases a burst of fire into the face."),
	poisonTrap(new Trap("Poison Trap", 3, 0, 5, 0, 0, 0), "Releases a burst of poison into the face."),
	shockTrap(new Trap("Shock Trap", 3, 0, 0, 0, 0, 5), "Releases a burst of electric energy into the face."),
	springTrap(new SpringTrap("Spring Trap", 2, 5, 0, 0, 0, 0),
			"Metal shards powered by a spring. If target's agility is " +
					"below 100, the chance to stun is determined by that score. 60 agility means there's a 40% chance to " +
					"be stunned."),
	snare(new Snare("Snare", 1, 0, 0, 0, 0, 0), "Keep combatant from executing melee attack")
	;

	Traps(Trap trap, String desc)
	{
		setTrap(trap);
		setDescription(desc);
	}

	private Trap trap;
	private String description;

	@Override
	public String toString()
	{
		return getTrap().getName();
	}

	public void setTrap(Trap trap)
	{
		this.trap = trap;
	}

	public Trap getTrap()
	{
		return trap;
	}

	public void setDescription(String desc)
	{
		description = desc;
	}

	public String getDescription()
	{
		return description;
	}
}
