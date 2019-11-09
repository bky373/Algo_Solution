package test.woo2th;

import java.util.Arrays;

public class Solution3 {
	public static void main(String[] args) {

		int[] prices = {39999, 18000, 42500};
		int[] discounts = {50, 20, 33};
		System.out.println(solution(prices, discounts));
	}
	public static int solution(int[] prices, int[] discounts) {
        int answer = 0;
        Arrays.sort(prices);
        Arrays.sort(discounts);
        
        int j=1;
        for(int i=discounts.length-1; i>=0;i--) {
        	answer += prices[prices.length-j] * (100-discounts[i]) / 100;
        	j++;
        }
        for(int i=0; i<prices.length-j+1; i++){
        	answer += prices[i];
        }
        return answer;
    }
}
