package textrpg;

public class UnitRareMage extends UnitRare {

	public UnitRareMage(String name, String attack, int power, int defence, int hp, int speed, int criyical) {
		super("궁정 마도사", "파이어 볼", 80, 19, 500, 10, 0);
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
