package stackOrQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SQ_Printer {
	public int solution(int[] priorities, int location) {
int answer = 0;
		
		// 우선순위 큐 생성
		// 높은 숫자를 가진 숫자가 우선순위가 높으므로 내림차순으로 정렬
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
		for(int value : priorities) {
			pq.add(value);
		}

		// priority queue 가 비어있을 때까지 반복
		while(!pq.isEmpty()) {
			
			// removePrint에 있는 요소보다 큰 수가 있는지 확인하는 반복문

			// 다시 생각해보기
			for(int i = 0; i < priorities.length; i++) {
				
				// 가장 처음에 넣은 요소 빼기
				int removePrint = pq.peek();
				
				// 현재 내가 가리키는 요소
				int current = priorities[i]; // 이런식으로 비교를 할 예정

				
				// 가장 위에 있는 요소와 현재 내가 비교하려는 요소가 같을 때!
				// queue 에서 헤드에 있는 값을 제거한다. -> answer++
				// why? location 앞에 있는 애들을 뺐을 때 1 증가하여야 내가 프린트하고 싶은 문서가
				// 몇 번째로 빠지는지 알 수 있다.
				if(removePrint == current) { 
					pq.poll();
					answer++;
					
					// location과 현재 priorities 배열의 인덱스 값이 같을 때
					// 내가 프린트하고 싶은 문서이므로 while 반복문을 빠져나가기 위해 
					// priority queue에 있는 인덱스를 모두 제거
					// and for문 빠져나가기
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
