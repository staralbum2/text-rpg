package textrpg.units;

public class UnitRareSister extends UnitRare{

	public UnitRareSister() {
		super("수녀 앨리스", "치유의 기도", 50, 25, 600, 51, 0);
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
