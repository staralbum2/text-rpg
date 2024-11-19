package textrpg.units;

public class UnitLegendZeus extends UnitLegend{

	public UnitLegendZeus() {
		super("신들의 왕 제우스", "분노의 벼락", 999, 300, 1700, 60, 40);
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
