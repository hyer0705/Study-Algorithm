package stackOrQueue;

import java.util.Stack;

public class SQ_IronBar {

	public int solution(String arrangement) {
        int answer = 0;
        
        // ������ �������� ���ϱ� ���� Stack ����
        Stack<Character> stack = new Stack<Character>();
        
        // ������ ������ ī��Ʈ �ϴ� ����
        int laserCnt = 0;
        
        // ����� ī��Ʈ �ϴ� ����
        int barCnt = 0;
        
        // test�� strArr�� ��ҵ��� Stack�� push
        for(int i = 0; i < arrangement.length(); i++) {
        	
        	char current = arrangement.charAt(i);
        	
        	// ������ ������ ī��Ʈ
        	if(i != 0) {
        		char before = arrangement.charAt(i - 1);
        		if(before == '(' && current == ')') {
        			laserCnt++;
        			if(i < 2) {
        				laserCnt--;
        			}
        			System.out.println("������!");
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
