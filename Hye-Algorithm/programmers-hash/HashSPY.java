package hash;

import java.util.HashMap;

public class HashSPY {
	public int solution(String[][] clothes) {
        
        // clothes ���� ������ hash ����
        // key = ���� ���� clothe[][1], value = �� ����
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        
        for(int i = 0; i < clothes.length; i++) {
        	String current = clothes[i][1];	// �ݺ������� ���� ���� ��
        	
        	if(hash.containsKey(current)) { // �̹� ����Ǿ� �ִ� ������ ���̶�� �� ������ �Ѱ� �����Ѵ�.
        		hash.replace(current, hash.get(current) + 1);
        	} else { // ����Ǿ� ���� �ʴٸ� 1�� �������ش�.
        		hash.put(current, 1);        		
        	}
        }
        
        int answer = 1; // ���� ����� ���� ������ ����
        
        for(String key : hash.keySet()) { // hash�� Ű ������ ��� ��
        	answer *= (hash.get(key) + 1); // �� �������� ����+1(�� ���� ��� + �� ����) �Ѹ�ŭ answer�� �����ش�.
        }
        answer--; // �ƹ��͵� ���� ���� ��츦 ���־���Ѵ�.
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
