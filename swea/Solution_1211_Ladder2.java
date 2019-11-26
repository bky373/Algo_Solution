package study.swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1211_Ladder2 {
	static int n;
	static int SIZE = 100;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 0; tc < 10; tc++) {
			n = sc.nextInt();
			map = new int[SIZE][SIZE];

			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int endY = 0;
			for (int i = 0; i < SIZE; i++) {
				if (map[SIZE - 1][i] == 2) {
					endY = i;
					break;
				}
			}
			
			int ans = Search(new Location(SIZE - 1, endY));
			
			System.out.printf("#%d %d\n", n, ans);
		}
	}

	private static int Search(Location last) {
		int nx = last.x;
		int ny = last.y;

		while (nx != 0) {
			nx = nx - 1; // 한 칸씩 위로 이동
			
			// 왼쪽으로 길이 나 있을 때 왼쪽 끝까지 이동
			if (ny - 1 >= 0 && map[nx][ny - 1] == 1) {
				while (ny - 1 >= 0 && map[nx][ny - 1] != 0) {
					ny = ny - 1;
				}
			} 
			
			// 오른쪽으로 길이 나 있을 때 오른쪽 끝까지 이동
			else if (ny + 1 <= SIZE - 1 && map[nx][ny + 1] == 1) {
				while (ny + 1 <= SIZE - 1 && map[nx][ny + 1] != 0) {
					ny = ny + 1;
				}
			}
		}
		return ny;
	}
}

class Location {
	int x;
	int y;

	Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
