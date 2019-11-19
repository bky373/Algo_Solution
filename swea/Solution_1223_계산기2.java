package study.swea;

import java.util.Scanner;
import java.util.Stack;

public class Solution_1223_계산기2 {
	static int LENGTH, T = 10;
	static char[] char_Arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 0; tc < T; ++tc) {
			Stack<Integer> numbers = new Stack<Integer>();
			Stack<Character> plus = new Stack<Character>();

			int LENGTH = sc.nextInt();
			char_Arr = sc.next().toCharArray();

			for (int i = 0; i < LENGTH; i++) {
				char c = char_Arr[i];
				// 숫자면 스택에 보관
				if(Character.isDigit(c)){
					numbers.push(c - '0');
				} 
				// 곱셈 먼저 계산
				else if(c == '*') {
					// *가 나오면 그 뒤에 있는 숫자도 스택에 넣어주고 계산
					numbers.push(char_Arr[i+1] - '0'); 
					int v1 = numbers.pop();
					int v2 = numbers.pop();
					numbers.push(v1*v2);
					i++;
				} 
				// 덧셈 분리
				else if (c == '+'){
					plus.push(c);
				}
			}
			// 덧셈 수만큼 스택에서 숫자 2개씩 꺼내어 계산
			for(char c : plus)
				if(c== '+') {
					numbers.push(numbers.pop() + numbers.pop());
				}
			
			System.out.printf("#%d %d\n", tc + 1, numbers.pop());
		}
	}
}
