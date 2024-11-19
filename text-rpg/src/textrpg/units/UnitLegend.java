package textrpg.units.legend;

import textrpg.units.Unit;

public abstract class UnitLegend extends Unit{
	public UnitLegend(String name, String attack, int power, int defence, int hp, int speed, int criyical) {
		super(name, attack, power, defence, hp, speed, criyical);
	}

}
