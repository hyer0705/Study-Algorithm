package stackOrQueue;

import java.util.Arrays;
import java.util.Stack;

public class SQ_Tower {
	
	public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        
        // Stack ����
        Stack<Integer> stack = new Stack<Integer>();
        
        // heigths �迭 stack�� push
        for(int value : heights) {
        	stack.push(value);
        }

        for(int i = stack.size(); i > 0; i--) {
        	// stack�� ���� �������� �� ��� pop()
        	int popNum = stack.pop();
        	
        	// stack�� �ִ� ����� popNum ���ؼ� ������ ž ã��
        	for(int index = stack.size() - 1; index >= 0; index--) {

        		// stack�� ����ִ� ��� ��ҿ� ���ϱ� ���� ���� ���� �ִ� ��Һ��� comparison ������ �־ ��
        		int comparison = stack.elementAt(index);
        		
        		// popNum ���� comparison�� �� Ŭ �� -> �����ϴ� ž ã�� �Ϸ� �ݺ��� ����� �� answer�� ���� �ֱ�
        		if(popNum < comparison) {
        			
        			// i �� stack.size() ���� ���۵� (stack�� �ε������� 1 ū ������ ���۵�)
        			// i - 1�� heights�� ����Ǿ� �ִ� ������ ����
        			// index�� stack�� ��¡ ���� �ִ� ����� ��ġ���� �����Ѵ�
        			// ������ ���������� �迭�� ������ 1���� �����ϹǷ� index + 1 ���� ���� answer �迭�� �����Ѵ�.
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
