package textrpg;

public class StageStore  extends Stage{

	@Override
	public boolean update() {
		try {
			bw.append("=====[모험가 마트]=====\n[1. 구매하기] [2. 판매하기] [3. 돌아가기]");
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
