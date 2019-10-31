package study.swea;

import java.util.Scanner;

public class Solution_1208 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = 100;
		int[] a = new int[len];
		for (int tc = 1; tc <= 10; tc++) {
			int min = 101, max = 0, j = 0, k = 0;
			int dumpCnt = sc.nextInt();
			for (int i = 0; i < len; i++)
				a[i] = sc.nextInt();
			for (int c = 0; c < dumpCnt; c++) {
				for (int i = 0; i < len; i++) {
					if (max < a[i]) {
						k = i;
						max = a[k];
					}
					if (min > a[i]) {
						j = i;
						min = a[j];
					}
				}
				if (a[k] > 1) {
					a[k]--;
					min = a[j];
				}
				if (a[j] < 100) {
					a[j]++;
					max = a[k];
				}
			}
			System.out.printf("#%d %d\n", tc, max - min + 1);
		}
	}
}
