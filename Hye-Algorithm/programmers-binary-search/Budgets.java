package binary_search;

import java.util.Arrays;

public class Budgets {
	
	public static int solution(int[] budgets, int M) {
        int answer = 0;
		
		// �̺� Ž���� ���� ����
		Arrays.sort(budgets);
		
		// �� ������ ��� ������ ���� �� ���꺸�� �۰ų� ���� ���
		// ���Ѿ��� ��� ������ ���� ū ���� ��ȯ���ش�
		long sum = 0;
		for(int budget : budgets) {
			sum += budget;
		}
		
		if(sum <= M) {
			return budgets[budgets.length - 1];
		}
		
		// --------------------------------------------------------
		
		// �̺�Ž���� ���� ���Ѿ��� ���ؾ� ��
		int low = 0;
		int high = budgets[budgets.length - 1];
		int currentMid = ( low + high ) / 2; // ���Ѿ�
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
