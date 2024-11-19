package textrpg.units.common;

import textrpg.units.Unit;

public abstract class UnitCommon extends Unit{

	public UnitCommon(String name, String attack, int power, int defence, int hp, int speed, int criyical) {
		super(name, attack, power, defence, hp, speed, criyical);
	}
}
