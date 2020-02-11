package stackOrQueue;

import java.util.Stack;

public class SQ_IronBar {

	public int solution(String arrangement) {
        int answer = 0;
        
        // 막대기와 레이저를 push, pop 하기 위한 스택 선언
        Stack<Character> stack = new Stack<Character>();
        
        // arrangement 배열 만큼 반복
        for(int i = 0; i < arrangement.length(); i++) {
        	
        	// 현재 내가 비교하고픈 요소를 저장하는 변수
        	char current = arrangement.charAt(i);
        	
        	// 현재 내가 비교하는 요소 바로 전에 있는 요소
        	char before = '\0';
        	
        	// i 가 0인 경우 발생하는 에러를 피하기 위한 조건문
        	if(i != 0) {
        		before = arrangement.charAt(i - 1);
        	}
        	
        	// 현재 요소가 '(' 인 경우 막대기 혹은 레이저의 시작 일단 스택에 저장
        	if(current == '(') {
        		stack.push(current);
        	}else { // 현재 요소가 ')' 인 경우 막대기 혹은 레이저의 끝
        		stack.pop();// 스택의 헤더 부분을 뺀다
        		
        		// 앞이 '(' 인 경우, 현재 요소는 레이저의 끝 부분을 뜻함
        		if(before == '(') {
//        			System.out.println("laser!");
        			// 스택에서 레이저의 시작 부분을 뺐으므로 남아 스택에 남아있는 요소들의 길이가 answer에 저장
        			answer += stack.size();
        		}else {// '))' 이런 경우에 막대기의 끝 부분을 뜻함, 잘린 막대기의 끝 부분은 앞에서 더해주지 않았으므로 더해준다
//        			System.out.println("막대기 끝 부분");
        			answer++;
        		}
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		SQ_IronBar bar = new SQ_IronBar();

		String arrangement = "()(((()())(())()))(())";

		System.out.println(bar.solution(arrangement));
	}
}
