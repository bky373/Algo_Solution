package study.swea;

import java.util.Scanner;

public class Solution_1223_String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 0; tc < 10; tc++) {

			int n = sc.nextInt();
			char[] arrChar = sc.next().toCharArray();
			String sLine = sc.next();

			int cnt = 0;
			for (int i = 0; i < sLine.length()-1; i++) {
				if (sLine.charAt(i) == arrChar[0]) {
					int j = 1, k = 1;
					while (k < arrChar.length && sLine.charAt(i + j) == arrChar[k]) {
						j++;
						k++;
					}
					if (j == arrChar.length)
						cnt++;
				}
			}
			System.out.printf("#%d %d\n", n, cnt);
		}
	}
}
