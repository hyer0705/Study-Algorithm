package hash;

import java.util.Arrays;

public class HashPhoneBook {
	public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        for(int i = 0; i < phone_book.length - 1; i++) { // phone_book�� �迭�� ���̺��� 1 ���� ������ �ݺ� 
        	
        	for(int j = i + 1; j < phone_book.length; j++) { // phone_book �ι�° ��Һ��� ������ ��ұ��� �ݺ�
        		
        		// �� ���� ��Ҹ� ���� �� ���� ��ҿ� ���� ���� ����� ���̰� ���� ����� ���̺��� ��ų� ���ƾ���
        		if(phone_book[j].length() >= phone_book[i].length()) {
        			
        			// ���� ��Ҹ� ���� ����� ���̸�ŭ �ڸ� why? ���� ����� ���ڿ� ������ Ȯ���ϱ� ����
        			String currentStr = phone_book[j].substring(0, phone_book[i].length());        			
//        			System.out.println(phone_book[i] + " " + currentStr); test output
        			
        			// ���� ��ҿ� ���� ��Ұ� ���ٸ� �ݺ����� ��������
        			if(phone_book[i].equals(currentStr)) {
        				return false;
        			}
        		}
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		HashPhoneBook pb = new HashPhoneBook();
		
		String[] phone_book = {
				"119",
				"97674223",
				"1195524421"
		};
		
		System.out.println(pb.solution(phone_book));
	}
}
