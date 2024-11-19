package textrpg.stage;

import textrpg.system.TextRpg;

public class StageRoom extends Stage {

	@Override
	public boolean update() {
		try {
			bw.append("=====[마이룸]=====\n[1. 던전]\n[2. 마을]\n[3. 인벤토리]\n[4. 세이브]\n[5. 로드]\n[0. 종료]");
			bw.flush();
			int sel = Integer.parseInt(br.readLine());
			if (sel == 1)
				TextRpg.nextStage = "Dungeon";
			else if (sel == 2)
				TextRpg.nextStage = "Village";
			else if(sel == 3)
				TextRpg.nextStage = "Inventori";
			else if (sel == 4)
				TextRpg.nextStage = "Save";
			else if (sel == 5)
				TextRpg.nextStage = "Load";
			else if (sel == 0)
				TextRpg.nextStage = "";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
