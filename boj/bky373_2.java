package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class bky373_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		// @1 기초 변수 세팅
		// n: 사람 수
		// k: 제거 주기
		// list : 사람 순서 리스트 및 순서 세팅
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=1; i<=n; i++) list.offer(i);
		
		// @2 기초 변수 세팅
		// cnt: 전체 횟수를 비교할 카운트 변수
		// i: 인덱스 활용을 위한 변수
		int cnt = 0, i = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!list.isEmpty()) { // @3 리스트를 모두 비울 때까지 반복한다. (단, 반복할 때마다 전체 횟수 값인 cnt를 증가시켜줘야 한다.)
			cnt++;
			if(cnt % k == 0) { // @4 만약 횟수가 제거 주기에 도달한다면 해당 인덱스의 값을 리스트에서 제거한다.
				sb.append(list.remove(i--));
				if(!list.isEmpty()) sb.append(", ");
			}
			// @5 인덱스가 무한으로 증가하면 안 되기 때문에 조정이 필요하다.
			// 인덱스 값이 리스트의 size보다 커지면 안 되기 때문에 리스트의 size에 도달하기 직전에 0으로 초기화해준다면 
			// 반복문은 원형리스트를 도는 것처럼 될 것이다.
			i = i == list.size()-1? 0 : i+1; 
			
		}
		sb.append(">");
		System.out.println(sb.toString());
	}
}