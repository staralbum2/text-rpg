package textrpg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

abstract public class Unit {
	

	protected StringBuffer bf = new StringBuffer();
	protected BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	protected BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	protected Random ran = new Random();
	
	protected final int MAX_HP;
	protected int power;
	protected int defence;
	protected int hp;
	protected int critical;
	protected int speed;
	protected String name;
	protected String attack;
	public Unit(String name,String attack,int power,int defence, int hp,int speed,int criyical){
		this.name=name;
		this.attack = attack;
		this.power=power;
		this.defence=defence;
		this.hp=hp;
		this.speed = speed;
		this.critical = criyical;
		this.MAX_HP = hp;
	}
	
	private void attack(Unit target) {
		try {
			bw.append(String.format("%s의 %s", name,attack));
			bw.flush();
			int damage = power - target.defence;
			int miss = ran.nextInt(100);
			if(miss > (speed - target.speed)) {
				try {
					bw.append("Miss!");
					bw.flush();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else {
				target.hp -= damage;
				bw.append(String.format("%s hp : %d/%d", target.name,target.hp,target.MAX_HP));
				bw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
