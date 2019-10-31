package study.swea;

import java.util.Scanner;

public class Solution_1209 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int[][] a = new int[100][100];
		int max = 0;
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					a[r][c] = sc.nextInt();
				}
			}
			int[] sum = new int[202];
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					sum[r] += a[r][c];
				}
			}
			for (int c = 0, s = 100; c < 100; c++, s++) {
				for (int r = 0; r < 100; r++) {
					sum[s] += a[r][c];
				}
			}
			for (int r = 0, c = r; r < 100; r++) {
				sum[200] += a[r][c];
				sum[201] += a[r][100 - c - 1];
			}
			for (int i = 0; i < sum.length; i++) {
				if (max < sum[i])
					max = sum[i];
			}
			System.out.printf("#%d %d\n", tc, max);
			max = 0;
		}
	}
}
