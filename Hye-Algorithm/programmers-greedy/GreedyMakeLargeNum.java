package greedyexam;

public class GreedyMakeLargeNum {
	
	public String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();
        sb.append(number.charAt(0));
        
        int cntK = k;
        
        // 현재 내가 가르키는 숫자와 앞의 숫자를 비교했을 때 현재 숫자가 더 크면 delete 작용
		
        //numbers의 길이만큼 반복
        for(int i = 1; i < number.length(); i++) {
        	char currentNum = number.charAt(i);
        	
        	if(sb.length() >= 1) { 
                // 앞에 있는 수를 모두 비교해 줍니다.
        		int currentStackSize = sb.length();
        		for(int j = currentStackSize - 1; cntK > 0 && j >= 0; j--) {
        			
        			if(sb.charAt(j) < currentNum) { // 문자열에 넣어진 값 중 제일 마지막 값 < 현재 비교하는 숫자
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
