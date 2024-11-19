package textrpg;

public class UnitLegendApollon extends UnitLegend{

	public UnitLegendApollon(String name, String attack, int power, int defence, int hp, int speed, int criyical) {
		super("의학 신 아폴론", "태양의 찬가", 450, 100, 2000, 101, 0);
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
