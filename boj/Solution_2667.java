package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2667 {
	static int stoi(String s) {return Integer.parseInt(s); }
	static int N;
	static int[][] map;
	static int cntComplex;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = stoi(br.readLine());
		map = new int[N][N];
		
		cntComplex = 0;
		

		for (int r = 0; r < N; r++) {
			String s = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = s.charAt(c) - '0';
			}
		}
				
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1) {
					cntComplex++;
					dfs(map, r, c);
				}
			}
		}
		System.out.println();
		System.out.println(cntComplex);
	}

	private static void dfs(int[][] map, int r, int c) {
		map[r][c] = 0;
		if (map[r][c + 1] == 1) {
			dfs(map, r, c + 1);
		}
		if (map[r][c - 1] == 1) {
			dfs(map, r, c - 1);
		}
		if (map[r + 1][c] == 1) {
			dfs(map, r + 1, c);
		}
		if (map[r - 1][c] == 1) {
			dfs(map, r - 1, c);
		}
	}
}
