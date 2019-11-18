package study.swea;

import java.util.*;

public class Solution_1258_행렬찾기 {
	static int T, n, k, cnt_subMatrix;
	static int[][] map, arr_subRC;
	static int[] dx = { 0, 1 }; // 동 남
	static int[] dy = { 1, 0 };
	static HashMap<Integer, Integer> hm;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			n = sc.nextInt();

			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			arr_subRC = new int[20][3];
			cnt_subMatrix = 0;
			k = 0;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] != 0) {
						cnt_subMatrix++; // 부분행렬 개수
						cntSubRCs(map, i, j); // 각 부분행렬의 행,열 개수 세기
						Search(new Dot(i, j)); // 화학물질 조사
					}
					// 제약사항 점검
//					if (isException(cnt_subMatrix)) {
//						System.out.println(cnt_subMatrix);
//						System.out.println(-1);
//						return;
//					}
				}
			}
			sortArrRC(arr_subRC); // subRC 배열 정렬하기
			
			String str = new String();
			for (int[] tmp : arr_subRC)
				if (tmp[0] != 0)
					str += tmp[0] + " " + tmp[1] +" ";
			System.out.printf("#%d %d %s\n", tc + 1, cnt_subMatrix, str);
		}
	}

	private static boolean isException(int cnt_subMatrix) {
		if (80 < n && n <= 100)
			return (15 < cnt_subMatrix && cnt_subMatrix <= 20) ? false : true;
		else if (n > 40)
			return (10 < cnt_subMatrix && cnt_subMatrix <= 15) ? false : true;
		else if (n > 10)
			return (5 < cnt_subMatrix && cnt_subMatrix <= 10) ? false : true;
		else
			return false;
	}

	private static void cntSubRCs(int[][] map, int i, int j) {
		int x = i, y = j;
		if (k < 20) {
			while (x < n && map[x][y] != 0) {
				arr_subRC[k][0] += 1;
				x += 1;
			}
			x = i;
			while (y < n && map[x][y] != 0) {
				arr_subRC[k][1] += 1;
				y += 1;
			}
			k++;
			for (int n = 0; n < k; n++)
				arr_subRC[n][2] = arr_subRC[n][0] * arr_subRC[n][1];
		}
	}

	private static void sortArrRC(int[][] arr_subRC) {
		Arrays.sort(arr_subRC, new Comparator<int[]>() {
			public int compare(int[] entry1, int[] entry2) {
				int v1 = entry1[2];
				int v2 = entry2[2];
				return v1 != v2 ? Integer.compare(v1, v2) : entry1[0] - entry2[1];
			}
		});
	}

	private static void Search(Dot d1) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.offer(d1);
		while (!q.isEmpty()) {
			Dot d = q.poll();
			int k = 0;

			// 현위치를 기준으로 동,남 탐색
			for (int i = 0; i < 2; i++) {
				int cur_x = d.x;
				int cur_y = d.y;

				// 화학물질 0으로 값 변환
				map[cur_x][cur_y] = 0;

				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				// 탐색하려는 인덱스가 범위 초과하면, 다른 방향 탐색
				if (nx >= n || ny >= n)
					continue;

				// 인접지역에 화학물질 있으면 큐에 추가
				if (map[nx][ny] != 0) {
					q.add(new Dot(nx, ny));
				}
			}
		}
//		printMap();
	}

	private static void printMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}

class Dot {
	int x;
	int y;

	Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
