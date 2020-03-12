package binary_search;

import java.util.Arrays;

public class SteppingBridge {

	public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        // binary search 를 위한 정렬
        Arrays.sort(rocks);
        
        // 이분 탐색을 위한 start, end
        // 바위 사이의 최소 거리를 이분 탐색으로 검색!
        int start = 1; // 거리 1을 뜻함
        int end = distance; // 입력받은 distnace 값
        int mid = 0;
        
        // 만약 입력받은 바위의 갯수만큼 n이 입력 됐다면 answer 는 distance 값이 되어야만 한다
        if(n == rocks.length) {
        	return distance;
        }
        
        // 이분탐색 반복문 - start 값이 end 값보다 작거나 같을 경우에만 반복
        while(start <= end) {
        	// start와 end의 중간값 계산 = 바위 사이의 거리를 뜻함
        	mid = (start + end)/2; 
        	
        	int currentD = 0; // 바위 사이를 계산하기 위한 변수, 앞의 바위라고 생각(처음에는 무조건 0)
        	int removeCnt = 0; // 제거한 바위의 갯수를 저장하는 변수
        	for(int i = 0; i < rocks.length; i++) { // 바위 배열의 길이만큼 반복
        		
        		// 현재 바위와 앞에 바위(처음에는 무조건 0)와의 거리
        		int cha = rocks[i] - currentD;
        		
        		// 바위 사이의 거리 기준값인 mid 와 현재 바위와 앞의 바위와의 거리를 계산한 cha의 비교
        		// cha가 mid 보다 작을 경우에만 바위를 제거
        		if( cha < mid ) {
        			removeCnt++;
        		} else { // 바위를 빼지 않을 경우 앞에 바위의 거리를 뜻하는 currentD에 현재 바위가 위치를 저장
        			currentD = rocks[i];
        		}
        	}
        	
        	// 제거한 돌의 갯수가 n 보다 크거나 같을 경우 end 값 변경
        	if(removeCnt > n) {
        		end = mid - 1;
        	} 
        	// 제거한 돌의 갯수가 n 보다 작을 경우 start 값 변경
        	else {
        		start = mid + 1;
        		
        		//answer 에 mid 값 저장
        		// 제거된 돌의 갯수와 조건의 입력받은 갯수 n이 큰 경우는 신경을 쓰지 않는다.
        		// n 보다 큰 경우는 조건이 성립하지 않으므로! ( 입국 심사와 같은 원리 )
        		answer = mid;
        	}
        }
        
        // test 출력
        System.out.println("answer : "+answer);
        System.out.println("start : " + start);
        System.out.println("mid : " + mid);
        System.out.println("end : " + end);
        
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		int distance = 25;
		int[] rocks = {
				2, 14, 11, 21, 17
		};
		int n = 2;
		
		solution(distance, rocks, n);
		
	}
}
