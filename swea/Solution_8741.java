package study.swea;

import java.io.IOException;
import java.util.Scanner;

public class Solution_8741 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for (int tc = 0; tc < t; tc++) {
			String line = sc.nextLine();
			char[] cline = line.toUpperCase().toCharArray();
			String out = cline[0]+"";
			for(int i =0; i<cline.length;i++) {
				if(cline[i] == ' ') out += cline[i+1];
			}
			System.out.printf("#%d %s\n", tc+1, out);
		}
	}
}