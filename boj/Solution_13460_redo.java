package study.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class qqNode {
	int rRow;
	int rCol;
	int bRow;
	int bCol;
	int cnt;

	public qqNode(int rRow, int rCol, int bRow, int bCol, int cnt) {
		super();
		this.rRow = rRow;
		this.rCol = rCol;
		this.bRow = bRow;
		this.bCol = bCol;
		this.cnt = cnt;
	}

	public qqNode() {
	}
}

public class Solution_13460_redo {
	static int MAX = 10;
	static int N, M;
	static char map[][];
	static boolean visited[][][][];
	static int[] dx = new int[] { 0, 0, 1, -1 }; // ��������
	static int[] dy = new int[] { 1, -1, 0, 0 }; // ��������
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[MAX][MAX][MAX][MAX];

		qqNode node = new qqNode();
		node.cnt = 0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);

				if (map[i][j] == 'R') {
					node.rRow = i;
					node.rCol = j;
				}
				if (map[i][j] == 'B') {
					node.bRow = i;
					node.bCol = j;
				}
			}
		}
		bfs(node);
	}

	private static void bfs(qqNode ball) {
		
		Queue<qqNode> q = new LinkedList<qqNode>();
		q.offer(ball);
		visited[ball.rRow][ball.rCol][ball.bRow][ball.bCol] = true;
		
		while(!q.isEmpty()) {
	
			qqNode node = q.poll();
			
			// 11�� �̻� ������ �� �����Ѵ�.
			if(node.cnt >= 10) {
				System.out.println(-1);
				return;
			}
			
			//���� ��ġ�� �������� �������� ��������.
			for(int i=0;i<4;i++) {
				
				//�Ķ� ģ�� ���� ��������.
				int b_nRow = node.bRow;
				int b_nCol = node.bCol;
				while(map[b_nRow + dx[i]][b_nCol + dy[i]] != '#') {
					b_nRow += dx[i];
					b_nCol += dy[i];
					if(map[b_nRow][b_nCol] == 'O') {
						break;
					}
				}
				//�� ����, ���� ģ���� ��������.
				int r_nRow = node.rRow;
				int r_nCol = node.rCol;
				while(map[r_nRow + dx[i]][r_nCol + dy[i]] != '#') {
					r_nRow += dx[i];
					r_nCol += dy[i];
					if(map[r_nRow][r_nCol] == 'O') {
						break;
					}
				}
				
				//�Ķ� ģ���� ���ۿ� �����ϸ� ���� Ž���� �õ��Ѵ�.
				if(map[b_nRow][b_nCol] == 'O') {
					continue;
				}
				
				//���� ģ���� ���ۿ� �����ϸ�, ������ ����Ѵ�.
				if(map[r_nRow][r_nCol] == 'O') {
					System.out.println(node.cnt + 1);
					return;
				}
				
				//�� ģ���� ��ġ�� ���ٸ� ��ġ�� �����Ѵ�.
				if(r_nRow == b_nRow && r_nCol == b_nCol) {
					switch(i) {
					
					case 0 : // ��
						if(node.rCol > node.bCol)
							b_nCol -= 1;
						else r_nCol -= 1;
						break;

					case 1 : // ��
						if(node.rCol > node.bCol)
							r_nCol += 1;
						else b_nCol += 1;
						break;

					case 2 : // ��
						if(node.rRow > node.bRow)
							b_nRow -= 1;
						else r_nRow -= 1;
						break;
						
					case 3 : // ��
						if(node.rRow > node.bRow)
							r_nRow += 1;
						else b_nRow += 1;
						break;
					}
				}
				
				//�̵��� ��ġ�� ó�� �湮�� ���̸� ť�� �־��ְ� cnt +1 �Ѵ�.
				if(!visited[r_nRow][r_nCol][b_nRow][b_nCol])
					q.offer(new qqNode(r_nRow, r_nCol, b_nRow, b_nCol, node.cnt+1));
			}
		}
		System.out.println(-1);
	}
}