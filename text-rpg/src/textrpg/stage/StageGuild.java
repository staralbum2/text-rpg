package textrpg.stage;

import textrpg.TextRpg;

public class StageGuild extends Stage{

	@Override
	public boolean update() {
		try {
			bw.append("=====[길드관리소]=====\n[1. 파티 편성]\n[2. 길드원 확인]\n[3. 돌아가기]");
			bw.flush();
			int sel = Integer.parseInt(br.readLine());
			
			 if (sel == 3) 
				TextRpg.nextStage = "Village";			
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
