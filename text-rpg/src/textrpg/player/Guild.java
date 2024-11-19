package textrpg.player;

import java.util.ArrayList;

import textrpg.units.Unit;

public class Guild {
	private Unit member;
	private boolean isParty;
	


	public boolean isParty() {
		return isParty;
	}
	
	
	public void setParty(boolean isParty) {
		this.isParty = isParty;
	}

	public Unit getMember() {
		return member;
	}

	public void setMember(Unit member) {
		this.member = member;
	}
	 
	
}
