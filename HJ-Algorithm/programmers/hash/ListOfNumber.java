import java.util.Arrays;

public class ListOfNumber {
    public static boolean solution(String[] phone_book) {
        
        //정렬하기
    	Arrays.sort(phone_book);
    	
        //정렬후 i, j = i + 1 비교
        for(int i = 0; i < phone_book.length - 1; i++){
        	for(int j = i + 1; j < phone_book.length; j++){
        		if(phone_book[i].length() > phone_book[j].length())
        			continue;
        		else if(phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length())))
        			return false;        		
        	}
        }
        
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Solved

	}

}
