package stackOrQueue;

import java.util.Stack;

public class SQ_IronBar {

	public int solution(String arrangement) {
        int answer = 0;
        
        // 막대기와 레이저를 비교하기 위한 Stack 선언
        Stack<Character> stack = new Stack<Character>();
        
        // 레이저 갯수를 카운트 하는 변수
        int laserCnt = 0;
        
        // 막대기 카운트 하는 변수
        int barCnt = 0;
        
        // test로 strArr의 요소들을 Stack에 push
        for(int i = 0; i < arrangement.length(); i++) {
        	
        	char current = arrangement.charAt(i);
        	
        	// 레이저 갯수를 카운트
        	if(i != 0) {
        		char before = arrangement.charAt(i - 1);
        		if(before == '(' && current == ')') {
        			laserCnt++;
        			if(i < 2) {
        				laserCnt--;
        			}
        			System.out.println("레이저!");
        		}
        		else if ( before == '(' && current == '(') {
        			System.out.println("bar!");
        			barCnt++;
        		}
        	}
        	
        	stack.push(current);
        }
        
        System.out.println(stack.toString());
        System.out.println("laser : " + laserCnt + ", bar : " + barCnt);
        
        return answer;
    }
	
	public static void main(String[] args) {
		SQ_IronBar bar = new SQ_IronBar();

		String arrangement = "()(((()())(())()))(())";

		bar.solution(arrangement);
	}
}
