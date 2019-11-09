package study.test.woo1th;

import java.util.Scanner;

// #3 청개구리
public class Solution3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String words = sc.nextLine();
		String frog = solution(words);
		System.out.println(frog);
	}
	private static String solution(String words) {
		String answer = "";
		char[] c_word = words.toCharArray();
		for (int i = 0; i < c_word.length; i++) {
			if(c_word[i] >= 'A' && c_word[i] <= 'Z') {
				answer += (char)('Z'+'A'- c_word[i]);
			} else if(c_word[i] >= 'a' && c_word[i] <= 'z') {
				answer += (char)('z'+'a'- c_word[i]);
			} else answer += c_word[i];
		}
		return answer;
	}
}
