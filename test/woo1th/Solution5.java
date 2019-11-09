package test.woo1th;

import java.util.Scanner;

// #5 369∞‘¿”
public class Solution5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		System.out.println(solution(number));
	}

	private static int solution(int number) {
		int answer = 0;
		
		for (int c = 1; c <= number; c++) {
			int i = c;
			while( i >= 3 ) {
				int rem = i % 10;
				i /= 10;
				if (rem == 0) continue;
				if (rem % 3 == 0 || rem % 6 == 0 || rem % 9 == 0) {
					answer++;
				}
			}
		}
		return answer;
	}
}
