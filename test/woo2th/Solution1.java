//package test.woo2th;
//
//public class Solution1 {
//	public static void main(String[] args) {
//
//		System.out.println(solution());
//	}
//
//	public int solution(int[] restaurant, int[][] riders, int k) {
//		int answer = 0;
//		int store_x = restaurant[0];
//		int store_y = restaurant[1];
//
//		for (int i = 0; i < riders.length; i++) {
//			int r_x = riders[i][0];
//			int r_y = riders[i][1];
//
//			int xlen = r_x - store_x;
//			int ylen = r_y - store_y;
//
//			int dlen = (int) Math.sqrt(Math.pow(xlen, 2) + Math.pow(ylen, 2));
//			if (dlen <= k) {
//				answer++;
//			}
//		}
//		return answer;
//	}
//}
