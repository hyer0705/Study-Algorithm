
public class StockPrice {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        int i = 0;
        for(i=0; i<prices.length - 1; i++){
        	int time = 0;
        	for(int j=i+1; j<prices.length; j++){
        		//�⺻���� 1�ʵ����� �������� ����.
        		time++;
        		//�������� ��
        		if(prices[i] > prices[j]){
        			break;
        		}
        	}
        	answer[i] = time;
        }
        answer[i] = 0; //�������� �׻� 0
                
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 2, 3, 1};
		//5, 4, 1, 2, 1, 0
		solution(arr);
		
		//Solved.

	}

}
