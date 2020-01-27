package greedyexam;

import java.util.Arrays;

public class GreedyGymSuit {
	
	public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        // lost �� reserve ����?
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // ü������ ������ �� �ִ� �迭 ����� ������ �� �ִ� -> 2, ������ �Ѵ� -> 0
        // reserve ���� �������� �ʰ� lost���� �������� ���� �л��� 1
        int[] rentingGym = new int[n];
        for(int i = 0; i < rentingGym.length; i++) {
        	int studentNum = i + 1;
        	
        	boolean isReserve = Arrays.stream(reserve).anyMatch(x -> x == studentNum);
        	boolean isLost = Arrays.stream(lost).anyMatch(x -> x == studentNum);
        	
        	// reserve ���� ���� ���� �ʰ� lost ���� �������� ���� ���� ü���� ���� 1�� ����
        	if(!isReserve && !isLost) {
        		rentingGym[i] = 1;
        	}
        	// reserve ���� �ְ� lost ���� �ִ� ���
        	else if(isReserve && isLost) {
        		rentingGym[i] = 1;
        	}
        	// reserve �迭�� ���� �ִ��� Ȯ�� �� ü���� ���� 2�� �� ����
        	else if(isReserve) {
        		rentingGym[i] = 2;
        	}
        	// lost �迭�� �ִ� ���ڿ� ���� �� ü���� ���� 0���� �� ����
        	else if(isLost) {
        		rentingGym[i] = 0;
        	}
        	
        }
        
        // ü������ ������ �� �ִ� �л��� �迭 Ȯ��
        for(int value : rentingGym) {
        	System.out.print(value + " ");
        }System.out.println();
        
        
        // lost�� �ִ� �迭�� ���������� ���캸��
        for(int i = 0; i < lost.length; i++) {
        	int currentNum = lost[i] - 1; // ü������ �Ҿ���� �л��� rentingGym �迭������ �ε��� ��ȣ
        	
        	boolean isFrontNum = true; // �� ��ȣ�� �ִ��� ����
        	boolean isReserveFront = false; // �� ��ȣ�� reserve �迭�� �ִ��� ����
        	int frontNum=0; // �� ��ȣ ������ ���� ����
        	
        	boolean isBackNum = true; // �� ��ȣ�� �ִ��� ����
        	boolean isReserveBack = false; // �� ��ȣ�� reserve �迭�� �ִ��� ����
        	int backNum = 0; // �� ��ȣ ������ ���� ����
        	
        	// ���� currentNum �� 0 �ΰ�쿡�� �� ��ȣ ����!
        	if(currentNum == 1) {
        		isFrontNum = false;
        	}else {
        		int temp = lost[i] - 1;
        		frontNum = lost[i] - 2; // �� ��ȣ ����
        		// �� ��ȣ�� reserve �迭�� �ִ��� Ȯ��
        		isReserveFront = Arrays.stream(reserve).anyMatch(x -> x == temp);
        	}
        	
        	// ���� currentNum �� rentingGym.length - 1 �� ��쿡�� �� ��ȣ ����!
        	if(currentNum == rentingGym.length) {
        		isBackNum = false;
        	}else {
        		int temp = lost[i] + 1;
        		backNum = lost[i]; // �� ��ȣ ����
        		// �� ��ȣ�� reserve �迭�� �ִ��� Ȯ��
        		isReserveBack = Arrays.stream(reserve).anyMatch(x -> x == temp);
        	}
        	
        	if(isReserveFront && isFrontNum && rentingGym[frontNum] == 2) { // �� �� ��ȣ�� ü������ ������ �� �ִ� ����(2)
        		rentingGym[currentNum] = 1;
        		rentingGym[frontNum]--;
        	}else if(isReserveBack && isBackNum && rentingGym[backNum] == 2) { // �� �޹�ȣ�� ü������ ������ �� �ִ� ���� (true)
        		rentingGym[currentNum] = 1;
        		rentingGym[backNum]--;
        	}else { // �ƹ��� �������� ���ϴ� ����
        		//rentingGym[currentNum] = 0;
        	}
        }
        
        // ü������ ������ �� �ִ� �л��� �迭 Ȯ��
        for(int value : rentingGym) {
        	System.out.print(value + " ");
        }System.out.println();
        
        // 1 �̻� ī��Ʈ
        int cnt = 0;
        for(int value : rentingGym) {
        	if(value >= 1) {
        		cnt++;
        	}
        }
        answer = cnt;
        
        return answer;
    }
	
	public static void main(String args[]) {
		GreedyGymSuit ggs = new GreedyGymSuit();
		
		// ��ü �л� ��
		int n = 5;
		int[] lost = {1,2,3,4,5};
		int[] reserve = {1};
		
		System.out.println(ggs.solution(n, lost, reserve));
		
	}
}
