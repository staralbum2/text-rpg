package textrpg;

public class UnitRareSister extends UnitRare{

	public UnitRareSister(String name, String attack, int power, int defence, int hp, int speed, int criyical) {
		super("수녀 앨리스", "치유의 기도", 50, 25, 600, 51, 0);
	}

	private void attack(Unit target) {
		try {
			bw.append(String.format("%s의 %s", name, attack));
			bw.flush();
			int damage = power;

			target.hp += damage;
			bw.append(String.format("%s hp : %d/%d", target.name, target.hp, target.MAX_HP));
			bw.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
