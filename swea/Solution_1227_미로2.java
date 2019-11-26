package study.swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1227_¹Ì·Î2 {
	static int n;
	static int SIZE = 100;
	static int[][] map;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 10; tc++) {

			n = sc.nextInt();

			map = new int[SIZE][SIZE];
			for (int i = 0; i < SIZE; i++) {
				String str = sc.next();
				for (int j = 0; j < SIZE; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			int ans = search(new Location(1, 1));
			System.out.printf("#%d %d\n", n, ans);
		}
	}

	private static int search(Location startPoint) {
		Queue<Location> q = new LinkedList<Location>();

		q.offer(startPoint);
		map[startPoint.x][startPoint.y] = 1;

		while (!q.isEmpty()) {
			Location p = q.poll();

			for (int i = 0; i < 4; i++) {

				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (map[nx][ny] == 1)
					continue;
				if (map[nx][ny] == 3) {
					return 1;
				}
				if (map[nx][ny] == 0) {
					q.offer(new Location(nx, ny));
					map[nx][ny] = 1;
				}
			}
		}
		return 0;
	}
}

class Point2 {
	int x;
	int y;

	Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
