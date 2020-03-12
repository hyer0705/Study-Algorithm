package binary_search;

import java.util.Arrays;

public class Immigration {

	public static long solution(int n, int[] times) {
		long answer = 0;
		// times 정렬 하기 ** 이분탐색은 정렬이 되어 있다고 가정하고 시작하기 때문
		Arrays.sort(times);
		
		// binary search 준비
		long low = 1; // 1분을 뜻함
		long high = (long)times[times.length - 1] * n;// 최악의 경우의 수 계산
		long mid = 0;
		
		while(low <= high) { // low 값이 high 값보다 작거나 같을 때까지만 반복
			
			mid = (low + high) / 2;

			long total = 0; // 각 심사관들이 mid 시간에 맡을 수 있는 인원들의 합
			
			// 각 심사관들이 심사를 맡을 수 있는 인원들의 총 합 계산
			for(int time: times) {
				total += (mid / time);
			}

			// 인원들의 합이 입력받은 인원수보다 크거나 같을 경우 high 값 변경
			if ( total >= n ) {
				high = mid - 1;
				// answer 에 mid 값 저장
				// 인원수의 합은 n과 크거나 같을 경우에만 mid 값에 넣는다.
				// 많은 경우의 수를 따져봤을 때 answer는 가장 짧은 시간을 답으로 하는 것이므로
				// 인원수의 총 합이 조건의 인원수보다 작을 경우는 생각하지 않는다.
				answer = mid;
//				System.out.println("mid : " + mid);
			} 
			// 인원들의 합이 입력받은 인원수보다 작을 경우 low 값 변경
			else {
				low = mid + 1;		
//				System.out.println("mid :" + mid);
			}
			
		}
		
		return answer;
    }
	
	public static void main(String[] args) {
		int n = 6;
		int[] times = {
				7, 10
		};
		
		long result = solution(n, times);
		System.out.println("result : " + result);
	}
}
