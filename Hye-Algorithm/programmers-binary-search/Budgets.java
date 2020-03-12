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
		
		// 이분 탐색을 위한 low, high, mid값 초기화
		int low = budgets[0];
		int high = budgets[budgets.length - 1];
		int currentMid = ( low + high ) / 2; // 현재 비교할 상한액
		int preMid = 0; // 앞서 구한 상한액
		
		int tmp = 0; // M 과 비교할 예산들의 합을 저장하는 공간
		
		while(true) {
			
			// 앞에 구한 mid 값과 현재 mid 값이 같다면 반복문 빠져나감
			// 상한액을 구하는 조건문
			if(preMid == currentMid) {
				answer = currentMid;
				break;
			}
			
			// mid 값을 기준으로 예산들의 합 구하는 for문
			for(int budget : budgets) {
				
				// mid 값보다 작으면 요청한 예산을 그대로 더해줌
				if(budget <= currentMid) {
					tmp += budget;
				}
				
				// mid 값보다 크다면 mid 값을 더해줌
				else {
					tmp += currentMid;
				}
			}
			
			
			// 예산들의 합이 M보다 작거나 같을 때
			if(tmp <= M) {
				low = currentMid + 1;
			}
			
			// 예산들의 합이 M보다 클 때
			else {
				high = currentMid - 1;
			}
			
			// preMid 는 currentMid 값 대입
			preMid = currentMid;
			
			// currentMid 값 다시 계산
			currentMid = (low + high) / 2;
			
			// 예산들의 합은 0으로 재초기화
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
		System.out.println(result);
	}
}
