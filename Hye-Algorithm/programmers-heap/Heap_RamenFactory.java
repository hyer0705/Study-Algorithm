package heap;

import java.util.Collections;
import java.util.PriorityQueue;

// Heap -> 우선순위 큐를 위하여 만들어진 자료구조

public class Heap_RamenFactory {

	public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;

        // supplies 기준에 따라 공급량을 저장하는 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        // stock 이 바닥날 때, 바닥나는 날짜 이전에서 최대 공급량을 선택
        // 밀가루가 다 소진 되는 날을 저장하는 변수
        int day = stock;
        
        // pq에 넣기 위한 dates 배열의 인덱스를 저장하는 변수
        int index = 0;
        int tmp = 0;
        
        while(day < k) { // day가 정상적으로 공급받을 수 있는 날 k보다 클 때 반복문을 빠져나감
        	for(int i = index; i < dates.length; i++) { // index부터 dates의 길이보다 작을 때까지 반복
        		
        		// 재료가 다 소진되는 날보다 작거나 같은 날들만 pq에 add
        		if(day >= dates[i]) {

        			pq.add(supplies[i]);
        			
        			// 마지막으로 pq에 add된 index를 저장해 놓는 변수
        			tmp = i;
        			
        		}
        	}
        	
        	// 마지막으로 저장된 배열의 인덱스보다 1 더한 값을 index에 저장
        	// 중복 저장을 막기 위해
        	index = tmp + 1;

        	// pq에 저장된 값 중 가장 큰 값을 day에 plus
        	// supplies 배열에 들어있는 값은 밀가루의 양을 뜻하고 1일에 1톤을 소비함
        	day += pq.remove();

        	// day 에 더해줄 때마다 카운트
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
