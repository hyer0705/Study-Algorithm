package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Heap_MoreSpicy {
	
/* heap sort 공부
	// heap sort method
	public void heapSort(int[] scoville) {
		
		// scoville len
		int len = scoville.length;
		
		// heapify 불러서 heap 구조 만들기
		for(int i = len / 2 - 1; i >= 0; i--) {
			heapify(scoville, i, len);
		}
		
		// test print
		System.out.println("heap 구조 완성 : " + Arrays.toString(scoville));
		
		// sort 구현
		// 1. root와 leaf change
		// 2. leaf 를 제외하고 heap 구조 다시 만들기
		for(int i = (len - 1); i >= 0; i--) {
			
			int tmp = scoville[0];
			scoville[0] = scoville[i];
			scoville[i] = tmp;
			
			heapify(scoville, 0, i);
		}
	}
	
	// heap 구조 만들어주는 method
	// heap 구조화 하기 위한 배열, 부모 노드, 배열의 길이(크기)
	public void heapify(int[] scoville, int root, int len) {
				
		int max = root;
		int left = 2 * root + 1;
		int right = 2 * root + 2;
		
		int heap_len = len;
		
		if( left < heap_len && scoville[max] < scoville[left]) {
			max = left;
		}
		
		if(right < heap_len && scoville[max] < scoville[right]) {
			max = right;
		}
		
		if(root != max) {
			int temp = scoville[root];
			scoville[root] = scoville[max];
			scoville[max] = temp;
			
			root = max;
			
			heapify(scoville, root, len);
		}
	}
*/
	public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 우선순위 큐 생성
        // 숫자가 작은 순으로 정렬되어 저장된다
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int value : scoville) {
        	pq.add(value);
        }
        
        // test print
        System.out.println(pq);
        
        for(int i = 0; i < scoville.length; i++) {

        	// pq에 들어간 숫자 중 가장 작은 수가 K보다 작을 때
        	if(pq.peek() < K) {
        		answer++;
        		int pop1 = pq.remove();
        		int pop2 = pq.remove();

        		int result = pop1 + (pop2 * 2);

        		pq.add(result);
        	}
        }
        
        System.out.println(pq);
        System.out.println(answer);
        
        return pq.peek() < K ? -1 : answer;
    }
	
	public static void main(String[] args) {
		Heap_MoreSpicy ms = new Heap_MoreSpicy();
		
//		int[] scoville = {12, 11, 13, 5, 6, 7};
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		
		ms.solution(scoville, K);
	}
}
