package textrpg.units;

public class UnitLegendApollon extends UnitLegend{

	public UnitLegendApollon() {
		super("의학 신 아폴론", "태양의 찬가", 450, 100, 2000, 101, 0);
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
			target.setHp(target.getHp() + damage);
			bw.append(String.format("%s hp : %d/%d", target.getName(), target.getHp(), target.getMaxHp()));
			bw.flush();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
