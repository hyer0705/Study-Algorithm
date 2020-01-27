package greedyexam;

import java.util.Arrays;

public class GreedyGymSuit {
	
	public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        // lost 와 reserve 정렬?
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 체육복을 빌려줄 수 있는 배열 만들기 빌려줄 수 있다 -> 2, 빌려야 한다 -> 0
        // reserve 에도 속해있지 않고 lost에도 속해있지 않은 학생은 1
        int[] rentingGym = new int[n];
        for(int i = 0; i < rentingGym.length; i++) {
        	int studentNum = i + 1;
        	
        	boolean isReserve = Arrays.stream(reserve).anyMatch(x -> x == studentNum);
        	boolean isLost = Arrays.stream(lost).anyMatch(x -> x == studentNum);
        	
        	// reserve 에도 속해 있지 않고 lost 에도 속해있지 않은 값은 체육복 갯수 1로 저장
        	if(!isReserve && !isLost) {
        		rentingGym[i] = 1;
        	}
        	// reserve 에도 있고 lost 에도 있는 경우
        	else if(isReserve && isLost) {
        		rentingGym[i] = 1;
        	}
        	// reserve 배열에 숫자 있는지 확인 후 체육복 갯수 2로 값 저장
        	else if(isReserve) {
        		rentingGym[i] = 2;
        	}
        	// lost 배열에 있는 숫자와 비교한 후 체육복 갯수 0으로 값 저장
        	else if(isLost) {
        		rentingGym[i] = 0;
        	}
        	
        }
        
        // 체육복을 빌려줄 수 있는 학생의 배열 확인
        for(int value : rentingGym) {
        	System.out.print(value + " ");
        }System.out.println();
        
        
        // lost에 있는 배열을 중점적으로 살펴보기
        for(int i = 0; i < lost.length; i++) {
        	int currentNum = lost[i] - 1; // 체육복을 잃어버린 학생이 rentingGym 배열에서의 인덱스 번호
        	
        	boolean isFrontNum = true; // 앞 번호가 있는지 유무
        	boolean isReserveFront = false; // 앞 번호가 reserve 배열에 있는지 유무
        	int frontNum=0; // 앞 번호 저장해 놓는 변수
        	
        	boolean isBackNum = true; // 뒷 번호가 있는지 유무
        	boolean isReserveBack = false; // 뒷 번호가 reserve 배열에 있는지 유무
        	int backNum = 0; // 뒷 번호 저장해 놓는 변수
        	
        	// 만약 currentNum 이 0 인경우에는 앞 번호 없음!
        	if(currentNum == 1) {
        		isFrontNum = false;
        	}else {
        		int temp = lost[i] - 1;
        		frontNum = lost[i] - 2; // 앞 번호 저장
        		// 앞 번호가 reserve 배열에 있는지 확인
        		isReserveFront = Arrays.stream(reserve).anyMatch(x -> x == temp);
        	}
        	
        	// 만약 currentNum 이 rentingGym.length - 1 인 경우에는 뒷 번호 없음!
        	if(currentNum == rentingGym.length) {
        		isBackNum = false;
        	}else {
        		int temp = lost[i] + 1;
        		backNum = lost[i]; // 뒷 번호 저장
        		// 뒷 번호가 reserve 배열에 있는지 확인
        		isReserveBack = Arrays.stream(reserve).anyMatch(x -> x == temp);
        	}
        	
        	if(isReserveFront && isFrontNum && rentingGym[frontNum] == 2) { // 내 앞 번호가 체육복을 빌려줄 수 있는 상태(2)
        		rentingGym[currentNum] = 1;
        		rentingGym[frontNum]--;
        	}else if(isReserveBack && isBackNum && rentingGym[backNum] == 2) { // 내 뒷번호가 체육복을 빌려줄 수 있는 상태 (true)
        		rentingGym[currentNum] = 1;
        		rentingGym[backNum]--;
        	}else { // 아무도 빌려주지 못하는 상태
        		//rentingGym[currentNum] = 0;
        	}
        }
        
        // 체육복을 빌려줄 수 있는 학생의 배열 확인
        for(int value : rentingGym) {
        	System.out.print(value + " ");
        }System.out.println();
        
        // 1 이상 카운트
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
		
		// 전체 학생 수
		int n = 5;
		int[] lost = {1,2,3,4,5};
		int[] reserve = {1};
		
		System.out.println(ggs.solution(n, lost, reserve));
		
	}
}
