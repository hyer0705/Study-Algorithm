import java.util.LinkedList;
import java.util.Queue;

public class TrucksPassingRoad {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; //��ü �ð�
        Queue<Integer> road = new LinkedList<>();//���� ť ����
        int[] time = new int[truck_weights.length];//Ʈ�� �̵� �ð� 

        
        int sum = 0; //���� ����
        int truck = 0; //Ʈ�� ��ȣ
        int start = 0;
        int end = 0;

        //ù�� ����  
        sum += truck_weights[truck];
        road.add(truck_weights[truck++]);
        end++;
        
        while(!road.isEmpty()){
        	//Ʈ�� �ð� �帧
        	timeFlow(time, start, end);
        	//�ð� ����
        	answer++;
        	//Ʈ�� ���� �˻�
        	for(int i=start; i<end; i++){
        		if(time[i] == bridge_length){
        			start++;
        			sum -= road.poll();
        		}
        	}
        	//���� �� ���� + ���� �� < ���� ����, ���� �� ����
        	if(truck < truck_weights.length){
				if(sum + truck_weights[truck] <= weight){
					sum += truck_weights[truck];
					road.add(new Integer(truck_weights[truck]));
					end++;
					truck++;
				}
        	}
        }
        answer++;
        
        return answer;
    }
    
    public static void timeFlow(int[] arr, int start, int end){
    	for(int i=start; i<end; i++)
    		arr[i]++;
    }
        

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int len = 2;
		int weight = 10;
		int[] trucks = {7, 4, 5, 6};
		solution(len, weight, trucks);
	
		//Solved

	}

}
