package stackOrQueue;

import java.util.Arrays;
import java.util.Stack;

public class SQ_Tower {
	
	public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        
        // Stack 생성
        Stack<Integer> stack = new Stack<Integer>();
        
        // heigths 배열 stack에 push
        for(int value : heights) {
        	stack.push(value);
        }

        for(int i = stack.size(); i > 0; i--) {
        	// stack에 가장 마지막에 들어간 요소 pop()
        	int popNum = stack.pop();
        	
        	// stack에 있는 값들과 popNum 비교해서 수신한 탑 찾기
        	for(int index = stack.size() - 1; index >= 0; index--) {

        		// stack에 들어있는 모든 요소와 비교하기 위해 가장 위에 있는 요소부터 comparison 변수에 넣어서 비교
        		int comparison = stack.elementAt(index);
        		
        		// popNum 보다 comparison이 더 클 때 -> 수신하는 탑 찾기 완료 반복문 벗어나기 및 answer에 정답 넣기
        		if(popNum < comparison) {
        			
        			// i 는 stack.size() 부터 시작됨 (stack의 인덱스보다 1 큰 값으로 시작됨)
        			// i - 1은 heights에 저장되어 있는 순서를 뜻함
        			// index는 stack에 가징 위에 있는 요소의 위치부터 시작한다
        			// 하지만 문제에서는 배열의 순서가 1부터 시작하므로 index + 1 해준 값을 answer 배열에 저장한다.
        			answer[i - 1] = index + 1;
        			break;
        		}
        	}
        }

        return answer;
    }
	
	public static void main(String[] args) {
		SQ_Tower tower = new SQ_Tower();
		
		int[] heights = {3,9,9,3,5,7,2};
		
		System.out.println(Arrays.toString(tower.solution(heights)));
	}
}
