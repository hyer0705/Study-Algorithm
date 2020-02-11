package stackOrQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SQ_Printer {
	public int solution(int[] priorities, int location) {
int answer = 0;
		
		// �켱���� ť ����
		// ���� ���ڸ� ���� ���ڰ� �켱������ �����Ƿ� ������������ ����
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
		for(int value : priorities) {
			pq.add(value);
		}

		// priority queue �� ������� ������ �ݺ�
		while(!pq.isEmpty()) {
			
			// removePrint�� �ִ� ��Һ��� ū ���� �ִ��� Ȯ���ϴ� �ݺ���

			// �ٽ� �����غ���
			for(int i = 0; i < priorities.length; i++) {
				
				// ���� ó���� ���� ��� ����
				int removePrint = pq.peek();
				
				// ���� ���� ����Ű�� ���
				int current = priorities[i]; // �̷������� �񱳸� �� ����

				
				// ���� ���� �ִ� ��ҿ� ���� ���� ���Ϸ��� ��Ұ� ���� ��!
				// queue ���� ��忡 �ִ� ���� �����Ѵ�. -> answer++
				// why? location �տ� �ִ� �ֵ��� ���� �� 1 �����Ͽ��� ���� ����Ʈ�ϰ� ���� ������
				// �� ��°�� �������� �� �� �ִ�.
				if(removePrint == current) { 
					pq.poll();
					answer++;
					
					// location�� ���� priorities �迭�� �ε��� ���� ���� ��
					// ���� ����Ʈ�ϰ� ���� �����̹Ƿ� while �ݺ����� ���������� ���� 
					// priority queue�� �ִ� �ε����� ��� ����
					// and for�� ����������
					if(location == i) {
						pq.clear();
						break;
					}
				}
			}
			
		}
        
		return answer;
    }
	
	public static void main(String[] args) {
		SQ_Printer printer = new SQ_Printer();
		
//		int[] priorities = {1,1,9,1,1,1};
//		int location = 0;
		int[] priorities = {2,1,3,2};
		int location = 2;
		
		System.out.println(printer.solution(priorities, location));
	}
}
