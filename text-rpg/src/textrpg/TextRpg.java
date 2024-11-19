package textrpg;

import java.util.HashMap;
import java.util.Map;

import textrpg.stage.Stage;
import textrpg.stage.StageBattle;
import textrpg.stage.StageChurch;
import textrpg.stage.StageGuild;
import textrpg.stage.StageMainMenu;
import textrpg.stage.StageRoom;
import textrpg.stage.StageStore;
import textrpg.stage.StageVillage;

public class TextRpg {

	
	private String name;
	Map<String, Stage> stageList = new HashMap<String, Stage>();
	
	public static String nextStage = "";
	public static int currentRound;
	String curStage = "";
	
	public int getCurrentRound() {
		return currentRound;
	}
	public void setCurrentRound(int currentRound) {
		this.currentRound = currentRound;
	}
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
