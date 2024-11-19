package textrpg.stage;

import java.util.ArrayList;

import textrpg.player.Guild;
import textrpg.player.Player;
import textrpg.system.TextRpg;
import textrpg.units.Unit;

public class StageGuild extends Stage {
	Player player = new Player();

	private int selNum(String msg) {

		int sel = -1;
		try {
			bw.append(msg + " : ");
			bw.flush();
			sel = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("숫자를 입력해");
		}
		return sel;
	}

	private void managementMember(ArrayList<Guild> member) {
		try {
			while (true) {
				bw.append("현재 파티중인 맴버\n");
				for (int i = 0; i < member.size(); i++)
					if (member.get(i).isParty())
						bw.append(String.format("%d) %s\n", i + 1, member.get(i).getMember()));
				bw.append("1)파티맴버 추가\n2)파티탈퇴\n3)돌아가기");
				int input = selNum("메뉴를 선택해");

				if (input == 1) {
					joinMember();
				} else if (input == 2) {
					fireMember();
				} else if (input == 3) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void joinMember() {
		try {
			if (player.getPartyCnt() == 4) {
				bw.append("파티 인원수가 최대야");
				return;
			}
			int join = selNum("추가할 맴버를 선택해") - 1;
			player.setPartyCnt(player.getPartyCnt() + 1);
			player.getMember().get(join).setParty(true);
			bw.append(String.format("%s를 파티맴버로 영입했어.", player.getMember().get(join).toString()));
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void fireMember() {
		try {
			if (player.getPartyCnt() == 0) {
				bw.append("파티에 가입된 맴버가 없어");
				return;
			}
			int join = selNum("해고할 맴버를 선택해") - 1;
			player.setPartyCnt(player.getPartyCnt() - 1);
			player.getMember().get(join).setParty(false);
			bw.append(String.format("%s를 파티에서 해고했어", player.getMember().get(join).toString()));
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void showMember(ArrayList<Guild> member) {
		try {
			bw.append("현제 가입중인 맴버\n");
			for (int i = 0; i < member.size(); i++)
				bw.append(member.get(i).getMember() + "\n");
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean update() {
		while (true) {
			try {
				bw.append("=====[길드관리소]=====\n[1. 파티 편성]\n[2. 길드원 확인]\n[3. 돌아가기]");
				bw.flush();
				int sel = selNum("메뉴를 선택해");
				if (player.getMember().size() <= 0 && (sel == 1 || sel == 2)) {
					bw.append("길드에 가입중인 동료가 없어!");
					bw.flush();
					continue;
				}
				ArrayList<Guild> member = player.getMember();
				if (sel == 1)
					managementMember(member);
				else if (sel == 2) {
					showMember(member);
				} else if (sel == 3) {
					TextRpg.nextStage = "Village";
					break;
				} else {
					bw.append("잘못된 메뉴 선택이야");
					bw.flush();
					continue;
				}

			} catch (

			Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
