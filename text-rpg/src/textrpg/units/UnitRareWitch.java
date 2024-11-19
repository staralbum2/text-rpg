package textrpg.units;

public class UnitRareWitch extends UnitRare {

	public UnitRareWitch(String name, String attack, int power, int defence, int hp, int speed, int criyical) {
		super("견습마녀 아리", "약화의 저주", 30, 30, 800, 122, criyical);
		
	}
	
	private void attack(Unit target) {
		try {
			bw.append(String.format("%s의 %s", name, attack));
			bw.flush();
			int damage = power;
			if(debuff > 0) 	{		
				damage -= debuff;
				debuff = 0;
			}
			target.setHp(target.getHp() - damage); 
			bw.append(String.format("%s hp : %d/%d", target.getName(), target.getHp(), target.getMAX_HP()));
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
