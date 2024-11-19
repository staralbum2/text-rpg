package textrpg.player;

import java.util.ArrayList;

public class Player {
	private int money;
	ArrayList<Guild> member = new ArrayList<>();
	ArrayList<Inventori> inventori = new ArrayList<Inventori>();
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public ArrayList<Guild> getMember() {
		return member;
	}
	public void setMember(ArrayList<Guild> member) {
		this.member = member;
	}
	public ArrayList<Inventori> getInventori() {
		return inventori;
	}
	public void setInventori(ArrayList<Inventori> inventori) {
		this.inventori = inventori;
	}
	
}
