import java.util.Arrays;
import java.util.Comparator;

public class Biggest_Num {
	
    public static String solution(int[] numbers) {
        String answer = "";
        String[] strNum = new String[numbers.length];
        for(int i=0; i<strNum.length; i++){
        	strNum[i] = String.valueOf(numbers[i]);
        }
        
        
        Arrays.sort(strNum, new Comparator<String>(){
			@Override
			public int compare(String str1, String str2) {
				// TODO Auto-generated method stub
				int num1 = Integer.parseInt(str1 + str2);
				int num2 = Integer.parseInt(str2 + str1);
				if(num1 > num2){
					return -1;
				}
				else if(num1 < num2){
					return 1;
				}
				else{
					return 0;
				}
			}
        });
        
        for(String s: strNum){
        	answer += s;
        }
        
        /* 이 부분 추가하면 왜 틀리지?
        if(Integer.valueOf(answer) == 0){
        	answer = "0";
        }
        */
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6, 10, 2};
		Biggest_Num.solution(arr);

	}

}
