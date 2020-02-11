package stackOrQueue;

import java.util.Arrays;
import java.util.Stack;

public class SQ_FnDev {
	public int[] solution(int[] progresses, int[] speeds) {
        
        // ������ ��¥�� �� ���� �۾��� �����ߴ��� ����, �۾��� ������ �����ϴ� STACK ����
        Stack<Integer> tStack = new Stack<Integer>();
        
        // ���� ������ ���� ���� ���� ������ �迭 ����, progresses�� ����ŭ ����
        int[] distribution = new int[progresses.length];
        
        // distribution �迭�� ���� �ֱ� ���� �ݺ���
        for(int i = 0; i < distribution.length; i++) {
        	
        	// ���� �۾��� ���� ���ϱ�, 100 - progresses�� ��
        	int remainTask = 100 - progresses[i];
        	
        	// ���� �۾��� ������ �Ⱓ ���ϱ�, ���� �۾��� ���� / �۾��� ���� �ӵ�
        	double term = remainTask / (double)speeds[i];
        	
        	// Math.ceil() -> �ø��� ���ִ� �޼ҵ�
        	distribution[i] = (int)Math.ceil(term);
        }
        
        // test distribution array print
        System.out.println(Arrays.toString(distribution));

        // ���� ������ �Ǵ� ���� ������ ���� ����
        int maxTerm = -1;
        
        // maxTerm�� ���� ������ stack�� ���� ���� ���� ����� �ε����� ������ ��
        for(int i = 0; i < distribution.length; i++) {
        	
        	// max ���� ã�� for�� max���� ���ϸ� ���� for���� ������.
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
        // stack�� ũ�⸸ŭ answer �迭 �����
        int[] answer = new int[tStack.size()];
        for(int i = answer.length - 1; i >= 0; i--) {
        	answer[i] = tStack.pop();
        }
        System.out.print("answer array : ");
        System.out.println(Arrays.toString(answer));
        
        // ������ �۾��� ������ Ȯ�� �ϴ� �ݺ���
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
