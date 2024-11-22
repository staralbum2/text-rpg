package textrpg.units;

public class UnitRareMage extends UnitRare {

	public UnitRareMage() {
		super("궁정 마도사", "파이어 볼", 80, 19, 500, 10, 0);
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
			bw.append(String.format("%s hp : %d/%d", target.getName(), target.getHp(), target.getMaxHp()));
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
