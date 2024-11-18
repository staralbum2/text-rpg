package textrpg;

import java.util.HashMap;
import java.util.Map;

public class TextRpg {

	
	private String name;
	Map<String, Stage> stageList = new HashMap<String, Stage>();
	
	static String nextStage = "";
	
	String curStage = "";
	
	void init(){
	    stageList.put("MainMenu", new StageMainMenu());
	    stageList.put("Batte", new StageBattle());
	    stageList.put("Room", new StageRoom());
	    stageList.put("Village", new StageVillage());
	    stageList.put("Store", new  StageStore());
	    stageList.put("Guild", new StageGuild());
	    stageList.put("Church", new StageChurch());
	    nextStage = "MainMenu";
	  }
	public void run() {
	
	}
	
}
