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
        
        System.out.print("주식 가격 하락 계산 전: ");
        System.out.println(Arrays.toString(answer));
        
        // 자기보다 작은 가격이 있는지 확인
        // 이 부분 다시생각
        // answer에 답을 넣을 반복문 실행
        for(int i = 0; i < prices.length - 1; i++) {
        	
        	// i보다 1 큰 값부터 prices.length의 길이보다 1 작을 때까지 반복
        	// prices[i] 와 prices[j]를 비교 했을 때 prices[i] 가 prices[j] 보다 크면 가격이 하락한 경우
        	for(int j = i + 1; j < prices.length - 1; j++) {
        		if(prices[i] > prices[j]) {
        			answer[i] = j - i;
        			break;
        		}
        	}
        }
        
        System.out.print("주식 가격 하락 계산 후: ");
        System.out.println(Arrays.toString(answer));
        
        return answer;
    }
	
	public static void main(String[] args) {
	
		SQ_stockPrices  stock = new SQ_stockPrices();
		
		int[] prices = {1, 2, 3, 2, 3};

		stock.solution(prices);
	}
}
