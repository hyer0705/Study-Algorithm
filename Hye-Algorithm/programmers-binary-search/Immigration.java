package binary_search;

import java.util.Arrays;

public class Immigration {

	public static long solution(int n, int[] times) {
		
		// times ���� �ϱ� ** �̺�Ž���� ������ �Ǿ� �ִٰ� �����ϰ� �����ϱ� ����
		Arrays.sort(times);
		
		// binary search �غ�
		long low = 1; // 1���� ����
		long high = (long)times[times.length - 1] * n;// �־��� ����� �� ���
		long mid = (low + high) / 2;
		
		// low �� high �� ���ų� ���� ��쿡�� �ݺ�
		// low > high �� ��� �ݺ��� ����
		// low �� ���� ��!
		while(low <= high) {

			long total = 0; // �� �ɻ������ mid �ð��� ���� �� �ִ� �ο����� ��
			
			// �� �ɻ������ �ɻ縦 ���� �� �ִ� �ο����� �� �� ���
			for(int time: times) {
				total += (mid / time);
			}

			// �ο����� �հ� �Է¹��� �ο����� ���ٸ� �ݺ��� Ż��
			// ** ���� �ٽ� �����ϱ�
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
		int n = 6; // �Ա� �ɻ縦 ��ٸ��� ���
		int[] times = {7, 10}; // �� �ɻ���� �� ���� �ɻ��ϴµ� �ɸ��� �ð�
		
		long result = solution(n, times);
		System.out.println(result);
	}
}
