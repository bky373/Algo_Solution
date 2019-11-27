package study.swea;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1211_Ladder2 {
	static int n;
	static int SIZE = 100;
	static int[][] map;
	static int[] arrCnt;

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

			arrCnt = new int[100];
			int min = Integer.MAX_VALUE, j = 0;
			
			for (int i = 0; i < SIZE; i++) {
				if (map[0][i] == 1) {
					arrCnt[i] = Search(new Location2(0, i));
					if (arrCnt[i] <= min) {
						min = arrCnt[i];
						j = i;
					}
				}
			}
			
			System.out.printf("#%d %d\n", n, j);
		}
	}

	private static int Search(Location2 start) {
		int nx = start.x;
		int ny = start.y;
		int cnt = 0;

		while (nx != SIZE - 1) {
			nx = nx + 1;
			cnt++;

			// 왼쪽으로 길이 나 있을 때 왼쪽 끝까지 이동
			if (ny - 1 >= 0 && map[nx][ny - 1] == 1) {
				while (ny - 1 >= 0 && map[nx][ny - 1] != 0) {
					ny = ny - 1;
					cnt++;
				}
			}

			// 오른쪽으로 길이 나 있을 때 오른쪽 끝까지 이동
			else if (ny + 1 <= SIZE - 1 && map[nx][ny + 1] == 1) {
				while (ny + 1 <= SIZE - 1 && map[nx][ny + 1] != 0) {
					ny = ny + 1;
					cnt++;
				}
			}
		}
		return cnt;
	}
}

class Location2 {
	int x;
	int y;

	Location2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
