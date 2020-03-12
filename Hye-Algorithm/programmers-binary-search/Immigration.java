package binary_search;

import java.util.Arrays;

public class Immigration {

	public static long solution(int n, int[] times) {
		
		// times 정렬 하기 ** 이분탐색은 정렬이 되어 있다고 가정하고 시작하기 때문
		Arrays.sort(times);
		
		// binary search 준비
		long low = 1; // 1분을 뜻함
		long high = (long)times[times.length - 1] * n;// 최악의 경우의 수 계산
		long mid = (low + high) / 2;
		
		// low 와 high 가 같거나 작을 경우에만 반복
		// low > high 인 경우 반복문 종료
		// low 가 답이 됨!
		while(low <= high) {

			long total = 0; // 각 심사관들이 mid 시간에 맡을 수 있는 인원들의 합
			
			// 각 심사관들이 심사를 맡을 수 있는 인원들의 총 합 계산
			for(int time: times) {
				total += (mid / time);
			}

			// 인원들의 합과 입력받은 인원수가 같다면 반복문 탈출
			// ** 조건 다시 생각하기
			if ( total >= n ) {
				high = mid - 1;
			} else if ( total < n ) {
				low = mid + 1;
			}
			
			mid = (low + high) / 2;
		}
		
		System.out.println("low : " + low + ", high : " + high + ",mid : " + mid);
		
		return low;
	}
	
	public static void main(String[] args) {
		int n = 6; // 입국 심사를 기다리는 사람
		int[] times = {7, 10}; // 각 심사관이 한 명을 심사하는데 걸리는 시간
		
		long result = solution(n, times);
		System.out.println(result);
	}
}
