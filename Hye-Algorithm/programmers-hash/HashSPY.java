package hash;

import java.util.HashMap;

public class HashSPY {
	public int solution(String[][] clothes) {
        
        // clothes 들을 저장할 hash 생성
        // key = 옷의 종류 clothe[][1], value = 옷 갯수
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        
        for(int i = 0; i < clothes.length; i++) {
        	String current = clothes[i][1];	// 반복문에서 현재 비교할 옷
        	
        	if(hash.containsKey(current)) { // 이미 저장되어 있는 종류의 옷이라면 옷 갯수를 한개 증가한다.
        		hash.replace(current, hash.get(current) + 1);
        	} else { // 저장되어 있지 않다면 1로 저장해준다.
        		hash.put(current, 1);        		
        	}
        }
        
        int answer = 1; // 옷의 경우의 수를 저장할 변수
        
        for(String key : hash.keySet()) { // hash의 키 값들을 모두 비교
        	answer *= (hash.get(key) + 1); // 옷 종류마다 갯수+1(안 입은 경우 + 옷 갯수) 한만큼 answer에 곱해준다.
        }
        answer--; // 아무것도 입지 않은 경우를 빼주어야한다.
        return answer;
    }
	
	public static void main(String[] args) {
		HashSPY spy = new HashSPY();
		
		String[][] clothes = {
				{"crow_mask", "face"},
				{"blue_sunglasses", "face"},
				{"smoky_makeup", "face"}
		};
		
		System.out.println("return: " + spy.solution(clothes));
	}
}
