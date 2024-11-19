package textrpg.units;

public class UnitLegendHera extends UnitLegend{

	public UnitLegendHera() {
		super("신들의 여왕 헤라", "여왕의 질투", 80, 200, 1800, 5000, 0);
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
