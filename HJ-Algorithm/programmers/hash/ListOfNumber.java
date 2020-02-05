import java.util.HashMap;

public class ListOfNumber {
    public static boolean solution(String[] phone_book) {
        String prefix = phone_book[0];
        
        for(int i = 1; i < phone_book.length; i++){
        	if(prefix.length() > phone_book[i].length())
        		continue;
        	else if(prefix.equals(phone_book[i].substring(0, prefix.length())))
        		return false;
        }
        
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//8,9번, 효율성 테스트 실패

	}

}
