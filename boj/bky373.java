package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class bky373 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=1; i<=n; i++) list.offer(i);
		
		int cnt = 0, i = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!list.isEmpty()) {
			cnt++;
			if(cnt % k == 0) {
				sb.append(list.remove(i--));
				if(!list.isEmpty()) sb.append(",");
			}
			i = i == list.size()-1 ? 0 : i+1;
		}
		sb.append(">");
		System.out.println(sb.toString());
	}
}