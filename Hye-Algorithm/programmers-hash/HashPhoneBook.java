package hash;

import java.util.Arrays;

public class HashPhoneBook {
	public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        for(int i = 0; i < phone_book.length - 1; i++) { // phone_book의 배열의 길이보다 1 작을 때까지 반복 
        	
        	for(int j = i + 1; j < phone_book.length; j++) { // phone_book 두번째 요소부터 마지막 요소까지 반복
        		
        		// 두 개의 요소를 비교할 때 앞의 요소와 비교할 뒤의 요소의 길이가 앞의 요소의 길이보다 길거나 같아야함
        		if(phone_book[j].length() >= phone_book[i].length()) {
        			
        			// 뒤의 요소를 앞의 요소의 길이만큼 자름 why? 앞의 요소의 숫자와 같은지 확인하기 위해
        			String currentStr = phone_book[j].substring(0, phone_book[i].length());        			
//        			System.out.println(phone_book[i] + " " + currentStr); test output
        			
        			// 앞의 요소와 뒤의 요소가 같다면 반복문을 빠져나감
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
