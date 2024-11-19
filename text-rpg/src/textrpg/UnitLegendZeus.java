package textrpg;

public class UnitLegendZeus extends UnitLegend{

	public UnitLegendZeus(String name, String attack, int power, int defence, int hp, int speed, int criyical) {
		super("신들의 왕 제우스", "분노의 벼락", 999, 300, 1700, 60, 40);
	}
	private void attack(Unit target) {
		try {
			bw.append(String.format("%s의 %s", name, attack));
			bw.flush();
			int damage = power;

			target.hp -= damage;
			bw.append(String.format("%s hp : %d/%d", target.name, target.hp, target.MAX_HP));
			bw.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
