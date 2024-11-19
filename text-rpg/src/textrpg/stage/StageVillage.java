package textrpg.stage;

import textrpg.system.TextRpg;

public class StageVillage  extends Stage{

	@Override
	public boolean update() {
		try {
			bw.append("=====[모험가 마을]=====\n[1. 길드방문] [2. 교회방문] [3. 마이룸]");
			bw.flush();
			int sel = Integer.parseInt(br.readLine());
			if (sel == 1)
				TextRpg.nextStage = "Guild";
			else if (sel == 2)
				TextRpg.nextStage = "Church";
			else if (sel == 3)
				TextRpg.nextStage = "Room";
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
