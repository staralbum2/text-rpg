package textrpg.units.epic;

import textrpg.units.Unit;

abstract public class UnitEpic extends Unit{

	public UnitEpic(String name, String attack, int power, int defence, int hp, int speed, int criyical) {
		super(name, attack, power, defence, hp, speed, criyical);
	}
}
