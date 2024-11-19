package textrpg.stage;

import textrpg.TextRpg;

public class StageChurch extends Stage {

	@Override
	public boolean update() {
		try {
			bw.append("=====[교회]=====\n[1. 치유하기]\n[2. 부활하기]\n[3. 돌아가기]");
			bw.flush();
			int sel = Integer.parseInt(br.readLine());
			
			if (sel == 3)
				TextRpg.nextStage = "village";
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
