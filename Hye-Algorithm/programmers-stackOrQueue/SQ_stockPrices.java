package stack_or_queue;

import java.util.Arrays;

public class SQ_stockPrices {

	public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        int index = 0;
        for(int price : prices) {
        	answer[index] = prices.length - (index + 1);
        	index++;
        }
        
        System.out.print("�ֽ� ���� �϶� ��� ��: ");
        System.out.println(Arrays.toString(answer));
        
        // �ڱ⺸�� ���� ������ �ִ��� Ȯ��
        // �� �κ� �ٽû���
        // answer�� ���� ���� �ݺ��� ����
        for(int i = 0; i < prices.length - 1; i++) {
        	
        	// i���� 1 ū ������ prices.length�� ���̺��� 1 ���� ������ �ݺ�
        	// prices[i] �� prices[j]�� �� ���� �� prices[i] �� prices[j] ���� ũ�� ������ �϶��� ���
        	for(int j = i + 1; j < prices.length - 1; j++) {
        		if(prices[i] > prices[j]) {
        			answer[i] = j - i;
        			break;
        		}
        	}
        }
        
        System.out.print("�ֽ� ���� �϶� ��� ��: ");
        System.out.println(Arrays.toString(answer));
        
        return answer;
    }
	
	public static void main(String[] args) {
	
		SQ_stockPrices  stock = new SQ_stockPrices();
		
		int[] prices = {1, 2, 3, 2, 3};

		stock.solution(prices);
	}
}
