import java.util.ArrayList;
import java.util.List;

public class Number_baseball {
	public static void compare(int ball1, int ball2, int[] answer){
		int num1 = ball1;
		int num2 = ball2;
		int index = 2;
		
		while(num1 > 0){
			if(num1 % 10 == num2 % 10){
				answer[index] = num1 % 10;
			}
			num1 = num1 / 10;
			num2 = num2 / 10;
			index--;
		}
	}
	
	public static int numZero(int[] arr){
		int zero = 0;
		for(int i:arr){
			if(i == 0)
				zero++;
		}
		
		return zero;
	}
	
    public static int solution(int[][] baseball) {
    	int[] answer = new int[3];
        //숫자 배열
        int[][] number = new int[baseball.length][3];
        //숫자 저장
        for(int i = 0; i<number.length; i++){
    		int num = baseball[i][0];
    		int j = 2;
    		while(num > 0 && j>=0){
    			number[i][j] = num % 10;
    			num = num / 10;
    			j--;
    		}	
        }
        

        //확실한 답 채우기 (스트라이크)
        for(int i = 0; i<number.length; i++){
        	if(baseball[i][1] == 3){
        		return 1;
        	}
        	else if(baseball[i][1] >= 1){
        		for(int j=0; j<number.length; j++){
        			if(i != j && baseball[j][1] >= 1){
        				compare(baseball[i][0], baseball[j][0], answer);
        			}
        		}
        	}
        }
        
        //정답이 완성 됬을 경우 리턴 1
//        for(int i = 0; i<answer.length; i++){
//        	if(answer[i] == 0)
//        		break;
//        	else if(i == 2)
//        		return 1;
//        }
        
        if(numZero(answer) == 0)
        	return 1;
        
        //볼 찾기
        int cases = 0;
        for(int i = 0; i<number.length; i++){
        	if(baseball[i][2] > 0){
        		
        	}
        }
        
        
        
        for(int i:answer)
        	System.out.println(i);
        
        
        return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		solution(arr);

	}

}
