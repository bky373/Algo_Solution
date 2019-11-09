package study.test.woo;

import java.util.Iterator;
import java.util.Stack;

class Solution {
	public static void main(String[] args) {
		//#2 토지 분양 
		int lands1[][] = { { 10, 0, 30, 5 }, { 0, 30, 20, 50 }, { 30, 30, 40, 40 } };
		int wells1[][] = { { 15, 15, 25, 25 }, { 40, 10, 50, 20 } };
		int points1[] = { 10, 10, 30, 30 };
		System.out.println(solution(lands1, wells1, points1));

		int lands2[][] = { { 0, 0, 20, 10 }, { 10, 20, 20, 40 }, { 30, 0, 50, 20 } };
		int wells2[][] = { { 20, 40, 30, 50 }, { 30, 20, 50, 30 } };
		int points2[] = { 20, 30, 30, 40 };
		System.out.println(solution(lands2, wells2, points2));
	}

	private static boolean solution(int[][] lands, int[][] wells, int[] point) {
		boolean a = false;

		int num_lands = lands.length;
		int num_wells = wells.length;
		for (int i = 0; i < num_lands; i++) { // 땅이랑 겹치면 false
			if ((point[0] >= lands[i][2] || point[2] <= lands[i][0] || point[1] >= lands[i][3] || point[3] <= lands[i][1]) == false)
				return false;
		}
		for (int i = 0; i < num_wells; i++) { // 식수원이 겹치면 true
			if ((point[0] >= wells[i][2] || point[2] <= wells[i][0] || point[1] >= wells[i][3] || point[3] <= wells[i][1]) == false)
				a = true;
		}
		return a;
	}
}
		
		
		
//		#5 369게임
//				int number = 13;
//				int clap = 0;
//				for (int c = 3; c <= number; c++) {
//					for (int i = c; i > 2; i /= 10) {
//						int rem = i % 10;
//						if (rem % 10 == 0)
//							continue;
//						if (rem % 3 == 0 || rem % 6 == 0 || rem % 9 == 0) {
//							clap++;
//						}
//					}
//				}
//				System.out.println(clap);
		
//		#7 암호문 
//		String input = "zyelleyz";
//		char[] cinput = input.toCharArray();
//		Stack s = new Stack();
//		for (char c : cinput) {
//			s.push(c);
//		}
//		for (int c = s.size(); c > 1 && s.size()!=0; c--) {
//			for (int i = 0; i < s.size() - 1; i++) {
//				if (s.elementAt(i).equals(s.elementAt(i + 1))) {
//					s.remove(i);
//					s.remove(i);
//				}
//			}
//		}
//		Iterator iter = s.iterator();
//		String a = "";
//		while(iter.hasNext()) {
//			a += iter.next();
//		}
//		System.out.println(a);

	