package stackOrQueue;

import java.util.Arrays;
import java.util.Stack;

public class SQ_FnDev {
	public int[] solution(int[] progresses, int[] speeds) {
        
        // 배포한 날짜에 몇 개의 작업을 배포했는지 저장, 작업의 개수를 저장하는 STACK 생성
        Stack<Integer> tStack = new Stack<Integer>();
        
        // 배포 가능한 날을 구한 값을 저장할 배열 생성, progresses의 수만큼 생성
        int[] distribution = new int[progresses.length];
        
        // distribution 배열에 값을 넣기 위한 반복문
        for(int i = 0; i < distribution.length; i++) {
        	
        	// 남은 작업의 진도 구하기, 100 - progresses의 값
        	int remainTask = 100 - progresses[i];
        	
        	// 남은 작업이 끝나는 기간 구하기, 남은 작업의 진도 / 작업의 개발 속도
        	double term = remainTask / (double)speeds[i];
        	
        	// Math.ceil() -> 올림을 해주는 메소드
        	distribution[i] = (int)Math.ceil(term);
        }
        
        // test distribution array print
        System.out.println(Arrays.toString(distribution));

        // 배포 기준이 되는 날을 저장할 변수 선언
        int maxTerm = -1;
        
        // maxTerm이 변할 때마다 stack에 값이 변할 때의 요소의 인덱스를 저장해 줌
        for(int i = 0; i < distribution.length; i++) {
        	
        	// max 값을 찾는 for문 max값이 변하면 안쪽 for문을 나간다.
        	for(int j = i; j < distribution.length; j++) {
        		if(maxTerm < distribution[i]) {
        			maxTerm = distribution[i];
        			tStack.push(j);
        			System.out.println(j);
        			System.out.println("break!");
        			break;
        		}
        	}
        }
        
        // stack -> array 
        // stack의 크기만큼 answer 배열 만들기
        int[] answer = new int[tStack.size()];
        for(int i = answer.length - 1; i >= 0; i--) {
        	answer[i] = tStack.pop();
        }
        System.out.print("answer array : ");
        System.out.println(Arrays.toString(answer));
        
        // 배포된 작업의 갯수를 확인 하는 반복문
        for(int i = 0; i < answer.length; i++) {
        	if(i != answer.length - 1) {
        		answer[i] = answer[i + 1] - answer[i];
        	}else {
        		answer[i] = distribution.length - answer[i];
        	}
        }
        
        System.out.print("answer array : ");
        System.out.println(Arrays.toString(answer));
        
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		SQ_FnDev fnDev = new SQ_FnDev();
		
		// test case
//		int[] progresses = {93, 30, 55};
//		int[] speeds = {1, 30, 5};
//		int[] progresses = {40, 93, 30, 55, 60, 65};
//		int[] speeds = {60, 1, 30, 5, 10, 7};
		int[] progresses = {93, 30, 55, 60, 40, 65};
		int[] speeds = {1, 30, 5 , 10, 60, 7};
		
		fnDev.solution(progresses, speeds);
	}
}
