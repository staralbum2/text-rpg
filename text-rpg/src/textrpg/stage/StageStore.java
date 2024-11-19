package textrpg.stage;

import textrpg.system.TextRpg;

public class StageStore  extends Stage{

	@Override
	public boolean update() {
		try {
			bw.append("=====[모험가 마트]=====\n[1. 영웅 박스] 1회 2500g\n[2. 아이템 박스] 1회 1500g\n[3. 돌아가기]");
			bw.flush();
			int sel = Integer.parseInt(br.readLine());
			if(sel == 1) {}
			else if(sel == 2) {}
			else if (sel == 3)
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
