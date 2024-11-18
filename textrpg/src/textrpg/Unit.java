package textrpg;

abstract public class Unit {
	private int power;
	private int defence;
	private int hp;
	private int critical;
	private int speed;
	private String name;
	private String attack;
	public Unit(String name,String attack,int power,int defence, int hp,int speed,int criyical){
		this.name=name;
		this.attack = attack;
		this.power=power;
		this.defence=defence;
		this.hp=hp;
		this.speed = speed;
		this.critical = criyical;
	}
}
