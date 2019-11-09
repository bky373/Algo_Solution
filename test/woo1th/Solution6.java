package study.test.woo1th;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

// #5 369����
public class Solution6 {
	public static void main(String[] args) {
		int totalTicket = 2000;
		String[] logs = {
				"woni request 09:12:29",
				"brown request 09:23:11",
				"brown leave 09:23:44",
				"jason request 09:33:51",
				"jun request 09:33:56",
				"cu request 09:34:02"
		};
		System.out.println(Arrays.toString(solution(totalTicket, logs)));
	}
	public static String[] solution(int totalTicket, String[] logs) {
		String[] answer = {};
		String[] info;
		String id, state, time;
		LinkedList<String> purchased = new LinkedList<String>();
		int last_Time = -60; // 9:00�� �����ϴ� �� ���
		for(int i=0; i<logs.length;i++){
			info = logs[i].split(" ");
			id = info[0];
			state = info[1];
			time = info[2];
			
			String[] t = time.split(":");
			int min = Integer.parseInt(t[1]);
			int access_Time = min*60 + Integer.parseInt(t[2]);
			// # request�� ��
			if(state.equals("request")) {
				// # 59�� ���� ���� �Ұ���
				if(access_Time > 59*60) continue;
				// # ���� �����ϰ� Ƽ���� ���Ҵٸ�..
				if(access_Time - last_Time >= 60 
						&& totalTicket > 0) {
					purchased.add(id);
					totalTicket -= 1;
					last_Time = access_Time;
				}
			}
			// # ������ �ְ� ���� ��..
			if(state.equals("leave")){
				purchased.remove(id);
				totalTicket += 1;
				// # �ð� �ʱ�ȭ
				last_Time = -60;
			}
		}
		answer = new String[purchased.size()];
		for(int i=0; i<purchased.size();i++) {
			answer[i] = purchased.get(i);
		}
		Arrays.sort(answer);
		return answer;
	}
}
