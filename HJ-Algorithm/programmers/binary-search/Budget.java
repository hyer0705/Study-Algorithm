import java.util.Arrays;

public class Budget {
    public static int solution(int[] budgets, int M) {
    	int requestSum = Arrays.stream(budgets).sum(); //예산 요청 총액
//    	System.out.println(requestSum);
    	
    	//모든 요청 ok
    	if(requestSum <= M)
    		return M;
    	
    	int equalBudget = M/budgets.length; //전체 국가 예산 / 지방 수 
//    	System.out.println(equalBudget);
    	
    	int restBudget = equalBudget * (int)Arrays.stream(budgets).filter(n -> n<equalBudget).count()
    			- Arrays.stream(budgets).filter(n -> n<equalBudget).sum();//남는 지방 예산합 - 요청 예산합
        
//    	System.out.println(restBudget);
       
    	//예산
    	int budget = equalBudget + restBudget / (int)Arrays.stream(budgets).filter(n -> n>=equalBudget).count();
    	//121 (equalBudgegt)
    	//120 -> 1 (equalBudget - bud[0])
    	//110 -> 11 (equalBudget - bud[1])
    	//1+11 = 12 (남는 예산 합)
    	//12 / 2 = 6 (남는 예산 합 / 나머지 지방 수)
    	//121 + 6 = 127 = answer (equalBudget + 남는 예산 = answer)

        //9번만 통과..
        return budget;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] bud = {120, 110, 140, 150};
		int M = 485;
		solution(bud, M);
	}

}
