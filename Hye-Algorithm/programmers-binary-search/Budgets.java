package binary_search;

import java.util.Arrays;

public class Budgets {
	
	public static int solution(int[] budgets, int M) {
        int answer = 0;
		
		// 이분 탐색을 위해 정렬
		Arrays.sort(budgets);
		
		// 각 지방의 모든 예산의 합이 총 예산보다 작거나 같을 경우
		// 상한액은 모든 예산의 가장 큰 값을 반환해준다
		long sum = 0;
		for(int budget : budgets) {
			sum += budget;
		}
		
		if(sum <= M) {
			return budgets[budgets.length - 1];
		}
		
		// --------------------------------------------------------
		
		// 이분탐색을 통해 상한액을 구해야 함
		int low = 0;
		int high = budgets[budgets.length - 1];
		int currentMid = ( low + high ) / 2; // 상한액
		int preMid = 0;
		
		int tmp = 0;
		
		while(true) {
			
			if(preMid == currentMid) {
				answer = currentMid;
				break;
			}
			
			for(int budget : budgets) {
				if(budget <= currentMid) {
					tmp += budget;
				}
				else {
					tmp += currentMid;
				}
			}
			
			
			if(tmp <= M) {
				low = currentMid + 1;
			}
			else {
				high = currentMid - 1;
			}
			preMid = currentMid;
			currentMid = (low + high) / 2;
			tmp = 0;
		}
		
		return answer;
    }

	public static void main(String[] args) {
		
		int[] budgets = {
				120, 110, 140, 150
		};
		int M = 485;
		
		int result = solution(budgets, M);
		System.out.println("result : " + result);
	}
}
