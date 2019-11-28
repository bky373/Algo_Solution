package study.swea;

import java.util.Scanner;

public class Solution_1216_회문2 {
	static char[][] arrChar;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			arrChar = new char[100][100];

			int n = sc.nextInt();
			for (int i = 0; i < 100; i++) {
				arrChar[i] = sc.next().toCharArray();
			}
			
			System.out.format("#%d %d\n", tc, findMaxLen());
		}
		sc.close();
	}
	
	private static int findMaxLen() {
		
		for (int len = 100; len >= 1; len--) {
			for (int s = 0; s < 100 - len + 1; s++) {
				boolean flag;
				for (int i = 0; i < 100; i++) {
					flag = true;
					for (int j = 0; j < len / 2; j++) { // 길이의 절반 -1만큼만 확인
						if (arrChar[i][s + j] != arrChar[i][s + len - 1 - j]) { 
							flag = false;
							continue;
						}
					}
					if (flag) {
						return len;
					}
					
					flag = true;
					for (int j = 0; j < len / 2; j++) { // 길이의 절반 -1만큼만 확인
						if (arrChar[s + j][i] != arrChar[s + len - 1 - j][i]) {
							flag = false;
						}
					}
					if (flag) {
						return len;
					}
				}
			}
		}
		return 0;
	}
}
