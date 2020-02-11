import java.util.LinkedList;
import java.util.Queue;

public class TrucksPassingRoad {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; //전체 시간
        Queue<Integer> road = new LinkedList<>();//도로 큐 생성
        int[] time = new int[truck_weights.length];//트럭 이동 시간 

        
        int sum = 0; //도로 무게
        int truck = 0; //트럭 번호
        int start = 0;
        int end = 0;

        //첫차 진입  
        sum += truck_weights[truck];
        road.add(truck_weights[truck++]);
        end++;
        
        while(!road.isEmpty()){
        	//트럭 시간 흐름
        	timeFlow(time, start, end);
        	//시간 증가
        	answer++;
        	//트럭 지남 검사
        	for(int i=start; i<end; i++){
        		if(time[i] == bridge_length){
        			start++;
        			sum -= road.poll();
        		}
        	}
        	//도로 위 무게 + 다음 차 < 무게 제한, 다음 차 진입
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
