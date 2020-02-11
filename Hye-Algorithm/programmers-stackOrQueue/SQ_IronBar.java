package stackOrQueue;

import java.util.Stack;

public class SQ_IronBar {

	public int solution(String arrangement) {
        int answer = 0;
        
        // ������ �������� push, pop �ϱ� ���� ���� ����
        Stack<Character> stack = new Stack<Character>();
        
        // arrangement �迭 ��ŭ �ݺ�
        for(int i = 0; i < arrangement.length(); i++) {
        	
        	// ���� ���� ���ϰ��� ��Ҹ� �����ϴ� ����
        	char current = arrangement.charAt(i);
        	
        	// ���� ���� ���ϴ� ��� �ٷ� ���� �ִ� ���
        	char before = '\0';
        	
        	// i �� 0�� ��� �߻��ϴ� ������ ���ϱ� ���� ���ǹ�
        	if(i != 0) {
        		before = arrangement.charAt(i - 1);
        	}
        	
        	// ���� ��Ұ� '(' �� ��� ����� Ȥ�� �������� ���� �ϴ� ���ÿ� ����
        	if(current == '(') {
        		stack.push(current);
        	}else { // ���� ��Ұ� ')' �� ��� ����� Ȥ�� �������� ��
        		stack.pop();// ������ ��� �κ��� ����
        		
        		// ���� '(' �� ���, ���� ��Ҵ� �������� �� �κ��� ����
        		if(before == '(') {
//        			System.out.println("laser!");
        			// ���ÿ��� �������� ���� �κ��� �����Ƿ� ���� ���ÿ� �����ִ� ��ҵ��� ���̰� answer�� ����
        			answer += stack.size();
        		}else {// '))' �̷� ��쿡 ������� �� �κ��� ����, �߸� ������� �� �κ��� �տ��� �������� �ʾ����Ƿ� �����ش�
//        			System.out.println("����� �� �κ�");
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
