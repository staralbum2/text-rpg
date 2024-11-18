package textrpg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class TextRpg {
	
	protected StringBuffer bf = new StringBuffer();
	protected BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	protected BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
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
	
	TextRpg(String name){
		this.name=name;
	}
	public void run() {
		printMainMenu();
	}
	
	private void printMainMenu() {
		bf.append(String.format("====%s====", name));
		
		try {
			bw.append(bf);
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
