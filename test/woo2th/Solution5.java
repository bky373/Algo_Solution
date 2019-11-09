package study.test.woo2th;

import java.util.Arrays;

public class Solution5 {
	public static void main(String[] args) {

		String[] history = { "1.0", "2.0", "1.5" };
		System.out.println(Arrays.toString(solution(history)));
	}

	public static int[] solution(String[] history) {
		int[] answer = {};
		// 초기값
		int pork = 5, onion = 100, longOnion = 10, garlic = 5, pepper = 2;
		
		answer = new int[history.length];
		for (int i = 0; i < history.length; i++) {
			double amount = Double.parseDouble(history[i]);
			int cost = 0;
			// 제한사항
			if(amount==0.0) {
				return new int[]{-1};
			} 
			
			// 돼지
			if (pork < (int) (amount * 4)) {
				cost += 10000;
				pork = pork + 10 - (int) (amount * 4);
			} else {
				pork -= (int) (amount * 4);
			}
			
			// 양파
			if (onion < (int) (amount * 50)) {
				cost += 3000;
				onion = onion + 100 - (int) (amount * 50);
			} else {
				onion -= (int) (amount * 50);
			}
			
			// 대파
			if (longOnion < (int) (amount * 10)) {
				cost += 1000;
				longOnion = longOnion + 30 - (int) (amount * 10);
			} else {
				longOnion -= (int) (amount * 10);
			}
			
			// 마늘
			if (garlic < (int) (amount * 10)) {
				cost += 2000;
				garlic = garlic + 50 - (int) (amount * 10);
			} else {
				garlic -= (int) (amount * 10);
			}
			
			// 고추
			double half = amount;
			if (amount == 0.5 || amount == 1.5 || amount == 2.5) {
				half = amount/2;
			}
			if (pepper < (int) (half * 4)) {
				cost += 1000;
				pepper = pepper + 10 - (int) (half * 4);
			}  else {
				pepper -= (int) (half * 4);
			}
			answer[i] = cost;
		}
		return answer;
	}
}
