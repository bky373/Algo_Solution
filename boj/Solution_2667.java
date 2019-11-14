package study.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Solution_2667 {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int N;
	static int[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int eachComplex;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = stoi(br.readLine());
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			String s = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = s.charAt(c) - '0';
			}
		}
		 /**
         * totalComplexd은 총 단지수
         * eachComplex는 각 단지의 개수
         * 오름차순으로 출력하기 위해 PriorityQueue에 저장함
         */
		int totalComplex = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (map[x][y] == 1) {
					eachComplex = 0;
					totalComplex++;
					
					dfs(x, y);
					
					pq.offer(eachComplex);
				}
			}
		}
		
		bw.write(totalComplex + "\n");

		while(!pq.isEmpty())
			bw.write(pq.poll() +"\n");
		
		bw.flush();
	}

	private static void dfs(int x, int y) {
		map[x][y] = 0;
		eachComplex++;
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0<=nx && nx <N && 0<=ny && ny<N) {
				if(map[nx][ny] == 1) {
					dfs(nx,ny);
				}
			}
		}
	}
}
