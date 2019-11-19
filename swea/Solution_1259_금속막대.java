package study.swea;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Nasa implements Comparator<Integer> {
	int left;
	int right;

	public Nasa(int left, int right) {
		super();
		this.left = left;
		this.right = right;
	}

	public int compare(Integer o1, Integer o2) {
		return 0;
	}

}

public class Solution_1259_금속막대 {
	static int T, n;
	static int[] cntArr;
	static Nasa[] arrNasa;
	static StringBuilder sb;
	static Queue<Nasa> q = new LinkedList<Nasa>();
	static Queue<Nasa> ansQ;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			n = sc.nextInt();
			arrNasa = new Nasa[n];
			
			
			for (int i = 0; i < n; i++) {
				arrNasa[i] = new Nasa(sc.nextInt(), sc.nextInt());
			}

			matchInPairs(); // 짝 맞추기

			System.out.printf("#%d %s\n", tc + 1, sb.toString());

		}
	}

	private static void matchInPairs() {
		cntArr = new int[n];
		for (int i = 0; i < n; i++) {
			ansQ = new LinkedList<Nasa>();
			
			q.offer(arrNasa[i]);
			ansQ.offer(arrNasa[i]);
			cntArr[i]++;
			while (!q.isEmpty()) {
				Nasa nasa = q.poll();
				for (int k = 0; k < arrNasa.length; k++) {
					if (nasa.right == arrNasa[k].left) {
						ansQ.offer(arrNasa[k]);
						cntArr[i]++;
						q.offer(arrNasa[k]);
					}
				}
			}
			if(cntArr[i] == n) {
				sb = new StringBuilder();
				while (!ansQ.isEmpty()) {
					Nasa tmp = ansQ.poll();
					sb.append(tmp.left + " " + tmp.right + " ");
				}
			}
			
		}
	}
	
//	private static void sortArrNasa() {
//		Arrays.sort(arrNasa, new Comparator<Nasa>() {
//
//			@Override
//			public int compare(Nasa n1, Nasa n2) {
//				int v1 = n1.right;
//				int v2 = n2.right;
//				return Integer.compare(v1, v2); // 오름차순
//			}
//		});
//		for (Nasa ns : arrNasa) {
//			System.out.print(ns.left + "," + ns.right + " ");
//		}
//		System.out.println();
//	}

}
