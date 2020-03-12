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
		
		// �̺� Ž���� ���� low, high, mid�� �ʱ�ȭ
		int low = budgets[0];
		int high = budgets[budgets.length - 1];
		int currentMid = ( low + high ) / 2; // ���� ���� ���Ѿ�
		int preMid = 0; // �ռ� ���� ���Ѿ�
		
		int tmp = 0; // M �� ���� ������� ���� �����ϴ� ����
		
		while(true) {
			
			// �տ� ���� mid ���� ���� mid ���� ���ٸ� �ݺ��� ��������
			// ���Ѿ��� ���ϴ� ���ǹ�
			if(preMid == currentMid) {
				answer = currentMid;
				break;
			}
			
			// mid ���� �������� ������� �� ���ϴ� for��
			for(int budget : budgets) {
				
				// mid ������ ������ ��û�� ������ �״�� ������
				if(budget <= currentMid) {
					tmp += budget;
				}
				
				// mid ������ ũ�ٸ� mid ���� ������
				else {
					tmp += currentMid;
				}
			}
			
			
			// ������� ���� M���� �۰ų� ���� ��
			if(tmp <= M) {
				low = currentMid + 1;
			}
			
			// ������� ���� M���� Ŭ ��
			else {
				high = currentMid - 1;
			}
			
			// preMid �� currentMid �� ����
			preMid = currentMid;
			
			// currentMid �� �ٽ� ���
			currentMid = (low + high) / 2;
			
			// ������� ���� 0���� ���ʱ�ȭ
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
