package binary_search;

import java.util.Arrays;

public class Immigration {

	public static long solution(int n, int[] times) {
		long answer = 0;
		// times ���� �ϱ� ** �̺�Ž���� ������ �Ǿ� �ִٰ� �����ϰ� �����ϱ� ����
		Arrays.sort(times);
		
		// binary search �غ�
		long low = 1; // 1���� ����
		long high = (long)times[times.length - 1] * n;// �־��� ����� �� ���
		long mid = 0;
		
		while(low <= high) { // low ���� high ������ �۰ų� ���� �������� �ݺ�
			
			mid = (low + high) / 2;

			long total = 0; // �� �ɻ������ mid �ð��� ���� �� �ִ� �ο����� ��
			
			// �� �ɻ������ �ɻ縦 ���� �� �ִ� �ο����� �� �� ���
			for(int time: times) {
				total += (mid / time);
			}

			// �ο����� ���� �Է¹��� �ο������� ũ�ų� ���� ��� high �� ����
			if ( total >= n ) {
				high = mid - 1;
				// answer �� mid �� ����
				// �ο����� ���� n�� ũ�ų� ���� ��쿡�� mid ���� �ִ´�.
				// ���� ����� ���� �������� �� answer�� ���� ª�� �ð��� ������ �ϴ� ���̹Ƿ�
				// �ο����� �� ���� ������ �ο������� ���� ���� �������� �ʴ´�.
				answer = mid;
//				System.out.println("mid : " + mid);
			} 
			// �ο����� ���� �Է¹��� �ο������� ���� ��� low �� ����
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
