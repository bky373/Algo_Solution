package study.swea;

import java.util.Scanner;

public class Solution_1206 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int MAX_HEIGHT = 256;
		int cnt, N;
		int[][] map;
		
		for (int tc = 0; tc < 10; tc++) {
			cnt = 0;
			N = sc.nextInt();
			map = new int[MAX_HEIGHT][N];
			for (int c = 0; c < N; c++) {
				int wall = sc.nextInt();
				for (int r = MAX_HEIGHT - 1; r > MAX_HEIGHT - wall - 1; r--) {
					map[r][c] = 1;
				}
			}
			for (int r = 0; r < map.length; r++) {
				for (int c = 2; c < map[0].length - 2; c++) {
					if (map[r][c] == 1 && map[r][c - 1] != 1 && map[r][c - 2] != 1 && map[r][c + 1] != 1 && map[r][c + 2] != 1) {
						cnt++;
					}
				}
			}
			System.out.printf("#%d %d\n", tc + 1, cnt);
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
