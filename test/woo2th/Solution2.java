package test.woo2th;

import java.util.Arrays;

public class Solution2 {
	public static void main(String[] args) {
		
		String logs = "2019/05/01 00:59:19\r\n" + 
				"2019/06/01 01:35:20\r\n" + 
				"2019/08/01 02:01:22\r\n" + 
				"2019/08/01 02:01:23\r\n" + 
				"2019/08/02 03:02:35\r\n" + 
				"2019/10/03 04:05:40\r\n" + 
				"2019/10/04 06:23:10\r\n" + 
				"2019/10/10 08:23:20\r\n" + 
				"2019/10/12 08:42:24\r\n" + 
				"2019/10/23 08:43:26\r\n" + 
				"2019/11/14 08:43:29\r\n" + 
				"2019/11/01 10:19:02\r\n" + 
				"2019/12/01 11:23:10";
		
		System.out.println(Arrays.toString(solution(logs)));
	}
	public static int[] solution(String logs) {
        int[] answer = new int[24];
        String[] dates = new String[100];
        String[] part;
        int timeInKorea = -1;
        dates = logs.split("\n");
        for(int i=0; i<dates.length; i++) {
        	part = dates[i].split(" ");
        	timeInKorea = Integer.parseInt(part[1].substring(0, 2)) + 9;
        	answer[timeInKorea]++;
        }
//        for(int i=0; i<=logs.length()-19;i+=19) {
//        	dates[i] = logs.substring(i,i+19);
//        	part = dates[i].split(" ");
//        	timeInKorea = Integer.parseInt(part[1].substring(0, 2)) + 9;
//        	System.out.println(timeInKorea);
//        	answer[timeInKorea]++;
//        }
        
        return answer;
    }
}
