import java.util.Arrays;
import java.util.Collections;

public class Sort_three {

	public static int solution(int[] citations) {
        int answer = 0;
        
        // 내림차순 정렬을 위해 Integer 배열에 값 저장
        Integer[] arrCitations = new Integer[citations.length];
        for(int i = 0; i < citations.length; i++) {
        	arrCitations[i] = citations[i];
        }
        
        // 논문이 인용된 횟수를 내림차순 정렬
        Arrays.sort(arrCitations, Collections.reverseOrder());
        
        /* H-INDEX 계산
         * 1. 연구자의 발표 논문을 피인용수가 많은 순으로 정렬함
         * 2. 순위와 피인용수가 같아지거나 혹은 순위가 피인용수보다 작은 수들을 구함
         * 3. 구한 값들 중 최대값이 h-index 이다!
         * */
        
        // h-index 값을 저장할 변수
        int max_h = 0;
        for(int i =0; i < arrCitations.length; i++) {
        	// 피인용수에 따른 순위
        	int rank = i + 1;
        	if(rank <= arrCitations[i]) {
        		if(max_h < rank) {
        			max_h = rank;
        		}
        	}
        }
        
        answer = max_h;
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		// 논문이 인용된 횟수를 저장된 배열
		int[] citations = {42, 22};
		
		System.out.println(solution(citations));
	}

}
