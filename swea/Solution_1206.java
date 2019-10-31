package study.swea;

import java.util.Scanner;

public class Solution_1206 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[1000], lmax = new int[1000], rmax = new int[1000];
		for (int tc = 1; tc <= 1; ++tc) {
			int n = sc.nextInt();
			int ans = 0;
			for (int i = 0; i < n; ++i) {
				lmax[i] = 0;
				rmax[i] = 0;
				a[i] = sc.nextInt();

				if (i >= 2) {
					lmax[i] = a[i - 2] > a[i - 1] ? a[i - 2] : a[i - 1];
					rmax[i - 2] = a[i] > a[i - 1] ? a[i] : a[i - 1];
					if (a[i - 2] > lmax[i - 2] && a[i - 2] > rmax[i - 2]) {
						ans += a[i - 2] - (lmax[i - 2] > rmax[i - 2] ? lmax[i - 2] : rmax[i - 2]);
					}
				}
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
//for (int r = 0; r < map.length; r++) {
//System.out.print("r:" + r + "|");
//for (int c = 0; c < map[0].length; c++) {
//	System.out.print(map[r][c]);
//}
//System.out.println();
//}
