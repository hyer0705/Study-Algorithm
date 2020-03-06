import java.util.Arrays;

public class Budget {
    public static int solution(int[] budgets, int M) {
    	int requestSum = Arrays.stream(budgets).sum(); //���� ��û �Ѿ�
//    	System.out.println(requestSum);
    	
    	//��� ��û ok
    	if(requestSum <= M)
    		return M;
    	
    	int equalBudget = M/budgets.length; //��ü ���� ���� / ���� �� 
//    	System.out.println(equalBudget);
    	
    	int restBudget = equalBudget * (int)Arrays.stream(budgets).filter(n -> n<equalBudget).count()
    			- Arrays.stream(budgets).filter(n -> n<equalBudget).sum();//���� ���� ������ - ��û ������
        
//    	System.out.println(restBudget);
       
    	//����
    	int budget = equalBudget + restBudget / (int)Arrays.stream(budgets).filter(n -> n>=equalBudget).count();
    	//121 (equalBudgegt)
    	//120 -> 1 (equalBudget - bud[0])
    	//110 -> 11 (equalBudget - bud[1])
    	//1+11 = 12 (���� ���� ��)
    	//12 / 2 = 6 (���� ���� �� / ������ ���� ��)
    	//121 + 6 = 127 = answer (equalBudget + ���� ���� = answer)

        //9���� ���..
        return budget;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] bud = {120, 110, 140, 150};
		int M = 485;
		solution(bud, M);
	}

}
