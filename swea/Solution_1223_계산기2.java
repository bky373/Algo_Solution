package study.swea;

import java.util.Scanner;
import java.util.Stack;

public class Solution_1223_����2 {
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
				// ���ڸ� ���ÿ� ����
				if(Character.isDigit(c)){
					numbers.push(c - '0');
				} 
				// ���� ���� ���
				else if(c == '*') {
					// *�� ������ �� �ڿ� �ִ� ���ڵ� ���ÿ� �־��ְ� ���
					numbers.push(char_Arr[i+1] - '0'); 
					int v1 = numbers.pop();
					int v2 = numbers.pop();
					numbers.push(v1*v2);
					i++;
				} 
				// ���� �и�
				else if (c == '+'){
					plus.push(c);
				}
			}
			// ���� ����ŭ ���ÿ��� ���� 2���� ������ ���
			for(char c : plus)
				if(c== '+') {
					numbers.push(numbers.pop() + numbers.pop());
				}
			
			System.out.printf("#%d %d\n", tc + 1, numbers.pop());
		}
	}
}
