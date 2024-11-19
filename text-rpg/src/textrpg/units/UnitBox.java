package textrpg.units;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Random;

import textrpg.TextRpg;
import textrpg.player.Guild;
import textrpg.player.Player;

public class UnitBox {
	private Random ran = new Random();
	private Unit ranUnit;
	private TextRpg textRpg = new TextRpg();
	private int currentRound = textRpg.getCurrentRound();
	private Player player = new Player();

	private int max = 400;
	private int min = 0;

	public UnitBox() {
		maxAndMinSet();
		Unit[] rateUnits = setRateUnits();
		int ranIdx = ran.nextInt(rateUnits.length);
		Guild temp = new Guild();
		temp.setMember(rateUnits[ranIdx]);
		player.getMember().add(temp);

		try {
			StringBuffer bf = new StringBuffer();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for (int i = 0; i < 3; i++) {
				bw.append("두근두근... ");
				bw.flush();
				Thread.sleep(1000);
				bw.append("~");
			}
			bw.append(String.format("%s가 당신의 동료로 합류했습니다.", rateUnits[ranIdx]));
			bw.flush();
		} catch (Exception e) {
		}
	}

	private Unit[] setRateUnits() {
		int ranCnt = ran.nextInt(max) + min;
		Unit[] rateUnits = new Unit[3];
		;
		if (ranCnt >= 125) {
			rateUnits[0] = new UnitCommonGoblin();
			rateUnits[1] = new UnitCommonPeasant();
			rateUnits[2] = new UnitCommonWolf();
		} else if (ranCnt >= 250) {
			rateUnits[0] = new UnitUncommonThief();
			rateUnits[1] = new UnitUncommonArcher();
			rateUnits[2] = new UnitUnCommonWarrior();
		} else if (ranCnt >= 321) {
			rateUnits[0] = new UnitRareMage();
			rateUnits[1] = new UnitRareSister();
			rateUnits[2] = new UnitRareWitch();
		} else if (ranCnt >= 510) {
			rateUnits[0] = new UnitUniqueArchor();
			rateUnits[1] = new UnitUniqueThief();
			rateUnits[2] = new UnitUniqueWarrior();
		} else if (ranCnt >= 580) {
			rateUnits[0] = new UnitEpicArcher();
			rateUnits[1] = new UnitEpicThief();
			rateUnits[2] = new UnitEpicWarrier();
		} else if (ranCnt >= 600) {
			rateUnits = new Unit[6];
			rateUnits[0] = new UnitLegendApollon();
			rateUnits[1] = new UnitLegendArtemis();
			rateUnits[2] = new UnitLegendHera();
			rateUnits[3] = new UnitLegendHermes();
			rateUnits[4] = new UnitLegendZeus();
			rateUnits[5] = new UnitLegendHercules();
		}
		return rateUnits;

	}

	private void maxAndMinSet() {
		if (currentRound <= 6) {
			max = Math.min(max + (currentRound - 1) * 50, 600);
		} else if (currentRound >= 7 && currentRound <= 9) {
			min = Math.min(min + (currentRound - 6) * 50, max);
		} else if (currentRound >= 10) {
			min = 200;
		}
	}

}