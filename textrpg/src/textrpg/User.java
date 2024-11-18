package textrpg;

abstract public class User {
	private int power;
	private int defence;
	private int hp;
	private int mp;
	private int evasion;
	private int accuracy;
	private int critical;
	
	public User(int power,int defence, int hp, int mp, int evasion,int accuracy,int criyical){
		this.power=power;
		this.defence=defence;
		this.hp=hp;
		this.mp = mp;
		this.evasion = evasion;
		this.accuracy = accuracy;
		this.critical = criyical;
	}
}
