package heap;

import java.util.Collections;
import java.util.PriorityQueue;

// Heap -> �켱���� ť�� ���Ͽ� ������� �ڷᱸ��

public class Heap_RamenFactory {

	public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;

        // supplies ���ؿ� ���� ���޷��� �����ϴ� �켱���� ť
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        // stock �� �ٴڳ� ��, �ٴڳ��� ��¥ �������� �ִ� ���޷��� ����
        // �а��簡 �� ���� �Ǵ� ���� �����ϴ� ����
        int day = stock;
        
        // pq�� �ֱ� ���� dates �迭�� �ε����� �����ϴ� ����
        int index = 0;
        int tmp = 0;
        
        while(day < k) { // day�� ���������� ���޹��� �� �ִ� �� k���� Ŭ �� �ݺ����� ��������
        	for(int i = index; i < dates.length; i++) { // index���� dates�� ���̺��� ���� ������ �ݺ�
        		
        		// ��ᰡ �� �����Ǵ� ������ �۰ų� ���� ���鸸 pq�� add
        		if(day >= dates[i]) {

        			pq.add(supplies[i]);
        			
        			// ���������� pq�� add�� index�� ������ ���� ����
        			tmp = i;
        			
        		}
        	}
        	
        	// ���������� ����� �迭�� �ε������� 1 ���� ���� index�� ����
        	// �ߺ� ������ ���� ����
        	index = tmp + 1;

        	// pq�� ����� �� �� ���� ū ���� day�� plus
        	// supplies �迭�� ����ִ� ���� �а����� ���� ���ϰ� 1�Ͽ� 1���� �Һ���
        	day += pq.remove();

        	// day �� ������ ������ ī��Ʈ
        	answer++;
        }
        
        
//        for(int i = 0; i < supplies.length; i++) {
//        	if(amountFlourNeeded > 0) {
//        		amountFlourNeeded -= supply.remove();
//        		answer++;
//        	} else {
//        		break;
//        	}
//        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		Heap_RamenFactory ramen = new Heap_RamenFactory();
		
		int stock = 4;
		int[] dates = {4,10,15};
		int[] supplies = {20,5,10};
		int k = 30;
//		int[] dates = {1,2,3,4};
//		int[] supplies = {1,1,1,1};
//		int k = 6;
//		int[] dates = {1,2,3,4};
//		int[] supplies = {10,40,30,20};
//		int k = 100;
		
		ramen.solution(stock, dates, supplies, k);
	}
}
