package study.swea;

import java.util.Scanner;

public class Solution_1208 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int boxLine = 100;
		int[] a = new int[boxLine];
		for (int tc = 1; tc <= 10; tc++) {
			int min = 101, max = 0, j = 0, k = 0;
			int dumpCnt = sc.nextInt();
			for (int i = 0; i < boxLine; i++)
				a[i] = sc.nextInt();
			for (int c = 0; c < dumpCnt; c++) {
				for (int i = 0; i < boxLine; i++) {
					if (max <= a[i]) {
						j = i;
						max = a[j];
					}
					if (min >= a[i]) {
						k = i;
						min = a[k];
					}
				}
				if (a[k] < 100) {
					a[k]++;
					max = a[j];
				}
				if (a[j] > a[k]) {
					a[j]--;
					min = a[k];
				}
			}
			for (int i = 0; i < boxLine; i++) {
				if (max <= a[i]) {
					j = i;
					max = a[j];
				}
				if (min >= a[i]) {
					k = i;
					min = a[k];
				}
			}
			System.out.printf("#%d %d\n", tc, max - min);
		}
	}
}
