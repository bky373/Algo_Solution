package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class bky373_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		// @1 ���� ���� ����
		// n: ��� ��
		// k: ���� �ֱ�
		// list : ��� ���� ����Ʈ �� ���� ����
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=1; i<=n; i++) list.offer(i);
		
		// @2 ���� ���� ����
		// cnt: ��ü Ƚ���� ���� ī��Ʈ ����
		// i: �ε��� Ȱ���� ���� ����
		int cnt = 0, i = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!list.isEmpty()) { // @3 ����Ʈ�� ��� ��� ������ �ݺ��Ѵ�. (��, �ݺ��� ������ ��ü Ƚ�� ���� cnt�� ����������� �Ѵ�.)
			cnt++;
			if(cnt % k == 0) { // @4 ���� Ƚ���� ���� �ֱ⿡ �����Ѵٸ� �ش� �ε����� ���� ����Ʈ���� �����Ѵ�.
				sb.append(list.remove(i--));
				if(!list.isEmpty()) sb.append(", ");
			}
			// @5 �ε����� �������� �����ϸ� �� �Ǳ� ������ ������ �ʿ��ϴ�.
			// �ε��� ���� ����Ʈ�� size���� Ŀ���� �� �Ǳ� ������ ����Ʈ�� size�� �����ϱ� ������ 0���� �ʱ�ȭ���شٸ� 
			// �ݺ����� ��������Ʈ�� ���� ��ó�� �� ���̴�.
			i = i == list.size()-1? 0 : i+1; 
			
		}
		sb.append(">");
		System.out.println(sb.toString());
	}
}