package hash;

import java.util.Arrays;
import java.util.HashMap;

public class HashMarathon {
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // array 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        // hashmap 사용하여 저장
        
        // key = name, value = 동명이인인지 확인을 위해 숫자 저장 동명이인이면 2, 아니면 1
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        
        // 완주자를 hash에 저장
        for(String key : participant) {
        	if(hash.containsKey(key)) { // 같은 키가 존재할 때 ( 동명이인 o)
        		hash.replace(key, hash.get(key) + 1);
        	}else { // 같은 키가 존재하지 않을 때 (동명이인 x)
        		hash.put(key, 1);
        	}
        }
        
//        System.out.println(hash.toString());
        
        // 완주자와 hash 비교
        for(String key : completion) {
        	if(hash.containsKey(key)) {
        		hash.replace(key, hash.get(key) - 1);        		
        	}
        }
        
        for(String key : hash.keySet()) {
        	if(hash.get(key) == 1) {
        		answer = key;
        	}
        }
        
//        System.out.println(hash.toString());
        
        return answer;
    }
	
	public static void main(String[] args) {
		HashMarathon marathon = new HashMarathon();
		
		String[] participant = {
				"leo", "kiki", "eden"
		};
		
		String[] completion = {
			"eden", "kiki"	
		};
		
		System.out.println(marathon.solution(participant, completion));
	}
}
