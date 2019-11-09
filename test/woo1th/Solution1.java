package test.woo1th;

import java.util.Arrays;
import java.util.Scanner;

//#1 µ∑ √‚±›
public class Solution1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		System.out.println(Arrays.toString(solution(input)));
	}
	private static int[] solution(int input) {
		int[] money = {50000,10000,5000,1000,500,100,50,10,1};
		int[] answer = new int[money.length];
			
		int i=0;
		while(input!=0) {
			answer[i] = input/money[i];
			input %= money[i];
			i++;
		}
		return answer;
	}
}
