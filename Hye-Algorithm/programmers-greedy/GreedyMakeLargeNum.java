package greedyexam;

public class GreedyMakeLargeNum {
	
	public String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();
        sb.append(number.charAt(0));
        
        int cntK = k;
        
        // ���� ���� ����Ű�� ���ڿ� ���� ���ڸ� ������ �� ���� ���ڰ� �� ũ�� delete �ۿ�
		
        //numbers�� ���̸�ŭ �ݺ�
        for(int i = 1; i < number.length(); i++) {
        	char currentNum = number.charAt(i);
        	
        	if(sb.length() >= 1) { 
                // �տ� �ִ� ���� ��� ���� �ݴϴ�.
        		int currentStackSize = sb.length();
        		for(int j = currentStackSize - 1; cntK > 0 && j >= 0; j--) {
        			
        			if(sb.charAt(j) < currentNum) { // ���ڿ��� �־��� �� �� ���� ������ �� < ���� ���ϴ� ����
        				sb.deleteCharAt(j);
        				cntK--;
        			}
        		}
        		sb.append(currentNum);
        	} 
        } 	
        if (sb.length() != (number.length() - k)) {
        	for(int i = sb.length() - 1; (sb.length() != (number.length() - k)) && i >= 0; i--) {
        		sb.deleteCharAt(i);
        	}
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		GreedyMakeLargeNum largeNum = new GreedyMakeLargeNum();
		String number = new String("1020");
		int k = 2;
		
		System.out.println(largeNum.solution(number, k));
	}
}
