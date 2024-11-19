
package textrpg.stage;

import textrpg.system.TextRpg;

public class StageMainMenu extends Stage {
	@Override
	public boolean update() {

		try {
			bw.append("=====[TextRpg]=====\n[1. 처음부터]\n[2. 이어하기]\n[3. 종료]");
			bw.flush();
			int sel = Integer.parseInt(br.readLine());
			if (sel == 1)
				TextRpg.nextStage = "Beginning";
			else if (sel == 2)
				TextRpg.nextStage = "Continue";
			else if (sel == 3)
				TextRpg.nextStage = "";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public void init() {

	}
}
