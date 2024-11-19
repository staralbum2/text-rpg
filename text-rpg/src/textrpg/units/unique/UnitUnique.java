package textrpg.units.unique;

import textrpg.units.Unit;

public abstract class UnitUnique extends Unit{

	public UnitUnique(String name, String attack, int power, int defence, int hp, int speed, int criyical) {
		super(name, attack, power, defence, hp, speed, criyical);
	}
	
}
