package study.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int rRow;
	int rCol;
	int bRow;
	int bCol;
	int cnt;

	public Node(int rRow, int rCol, int bRow, int bCol, int cnt) {
		super();
		this.rRow = rRow;
		this.rCol = rCol;
		this.bRow = bRow;
		this.bCol = bCol;
		this.cnt = cnt;
	}

	public Node() {
	}

}

public class Solution_13460 {
	static final int R = 0, B = 1;
	static int N, M;
	static char[][] map;
	static boolean[][][][] visited;
	static int[] dx = new int[] { 0, 0, 1, -1 }; // 동서 남북
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[10][10][10][10];

		Node node = new Node();
		node.cnt = 0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'R') {
					node.rRow = i;
					node.rCol = j;
				} else if (map[i][j] == 'B') {
					node.bRow = i;
					node.bCol = j;
				}
			}
		}
		bfs(node);
	}

	private static void bfs(Node ball) {

		Queue<Node> q = new LinkedList<Node>();
		q.offer(ball);

		while (!q.isEmpty()) {

			Node node = q.poll();
			visited[node.rRow][node.rCol][node.bRow][node.bCol] = true;

			// 11번 이상 굴렸을 경우 -1을 출력한다.
			if (node.cnt >= 10) {
				System.out.println(-1);
				return;
			}

			// 현재 두 구슬의 위치를 기준으로 동서남북으로 굴려본다.
			for (int i = 0; i < 4; i++) {

				// 파란색 구슬을 먼저 굴린다.
				int b_nRow = node.bRow;
				int b_nCol = node.bCol;
				while (map[b_nRow + dx[i]][b_nCol + dy[i]] != '#') {
					b_nRow += dx[i];
					b_nCol += dy[i];
					if (map[b_nRow][b_nCol] == 'O') {
						break;
					}
				}

				// 그 다음, 빨간색 구슬을 굴린다.
				int r_nRow = node.rRow;
				int r_nCol = node.rCol;
				while (map[r_nRow + dx[i]][r_nCol + dy[i]] != '#') {
					r_nRow += dx[i];
					r_nCol += dy[i];
					if (map[r_nRow][r_nCol] == 'O') {
						break;
					}
				}

				// 파란색 구슬이 'O'에 빠졌다면, 탐색을 멈춘다.
				if (map[b_nRow][b_nCol] == 'O') {
					continue;
				}

				// 빨간색 구슬만 'O'에 빠졌다면, 정답을 출력한다.
				if (map[r_nRow][r_nCol] == 'O') {
					System.out.println(node.cnt + 1);
					return;
				}

				// 두 구슬의 위치가 같다면, 위치를 조정한다.
				if (r_nRow == b_nRow && r_nCol == r_nRow) {
					switch (i) {

					case 0: // 동
						if (node.rCol > node.bCol)
							b_nCol -= 1;
						else
							r_nCol -= 1;
						break;

					case 1: // 서
						if (node.rCol > node.bCol)
							r_nCol += 1;
						else
							b_nCol += 1;
						break;
						
					case 2: // 남
						if (node.rRow > node.bRow)
							b_nRow -= 1;
						else
							r_nRow -= 1;
						break;

					case 3: // 북
						if (node.rRow > node.bRow)
							r_nRow += 1;
						else
							b_nRow += 1;
						break;
					}
				}
				//두 구슬을 구린 후의 각각의 위치가 처음 탐색하는 것이라면 큐에 넣는다.
				if(!visited[r_nRow][r_nCol][b_nRow][b_nCol])
					q.offer(new Node(r_nRow, r_nCol, b_nRow, b_nCol, node.cnt + 1));
			}
		}
		System.out.println(-1);
	}
	
	public static void showMap(char[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
