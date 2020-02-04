package hash;

import java.util.Arrays;
import java.util.HashMap;

public class HashMarathon {
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // array ����
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        // hashmap ����Ͽ� ����
        
        // key = name, value = ������������ Ȯ���� ���� ���� ���� ���������̸� 2, �ƴϸ� 1
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        
        // �����ڸ� hash�� ����
        for(String key : participant) {
        	if(hash.containsKey(key)) { // ���� Ű�� ������ �� ( �������� o)
        		hash.replace(key, hash.get(key) + 1);
        	}else { // ���� Ű�� �������� ���� �� (�������� x)
        		hash.put(key, 1);
        	}
        }
        
//        System.out.println(hash.toString());
        
        // �����ڿ� hash ��
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
