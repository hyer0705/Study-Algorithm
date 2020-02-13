package stackOrQueue;


import java.util.LinkedList;
import java.util.Queue;


public class SQ_TruckPassingBridge {

	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        int time = 0; // 시간을 나타내는 변수
        // 트럭 객체 배열 선언, truck의 갯수만큼
        Truck[] trucks = new Truck[truck_weights.length];
        
        // 다리를 지나기 전 truck들을 저장하는 queue
        Queue<Truck> before = new LinkedList<Truck>();

        // 객체 초기화 및 before에 add
        for(int i = 0; i < truck_weights.length; i++) {
        	trucks[i] = new Truck(truck_weights[i], bridge_length);
        	before.add(trucks[i]); // truck 객체들을 before queue에 add
        }
        
        // 다리를 뜻 하는 Queue 생성
        // 다리를 지나갈 때 트럭들을 저장함
        Queue<Truck> bridge = new LinkedList<Truck>();
        
        while(true) {
        	time++; // while문이 반복 되면 time의 값을 1 증가시킨다
        	
        	// bridge에 있는 트럭들의 거리 - 1 해주기
        	for(Truck t : bridge) {
        		t.setDistance(t.getDistance() - 1);
        	}
        	
        	// distance가 0인 경우 확인
        	if( !bridge.isEmpty() && bridge.peek().getDistance() == 0) {
        		bridge.remove();
        	}
//        	for(Truck t : bridge) {
//        		if(t.getDistance() == 0) {
//        			System.out.println("트럭이 다리를 완전히 지나갔습니다.");
//        			bridge.remove();
//        		}
//        	}
        	
        	if( !bridge.isEmpty() ) { // bridge 에 트럭이 하나라도 들어가 있을 때
        		
        		if( !before.isEmpty() ) {
        			// bridge에 있는 트럭들의 무게 합하기
        			int bridge_truck_weight = 0;
        			
        			for(Truck t : bridge) {
        				bridge_truck_weight += t.getWeight();
        			}
        			
        			// 지금 지나갈 예정인 트럭의 무게
        			int before_peek_weight = before.peek().getWeight();
        			
        			// 무게를 더했을 때 다리의 무게 제한에 걸리지 않는지 확인
        			if(bridge_truck_weight + before_peek_weight <= weight) {
        				bridge.add(before.remove());
        			}        			
        		}
        		
        	} else { // bridge 가 비어있을 때
        		if(!before.isEmpty()) {
        			bridge.add(before.remove()); // before에 있는 헤더 값을 지우고 bridge에 add        			
        		} else {
        			break;
        		}
        	}
        	
        }
        
        answer = time;
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		SQ_TruckPassingBridge truck = new SQ_TruckPassingBridge();
		
		int bridge_length = 100;
		int weight = 100;
//		int[] truck_weights = {10};
		int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

		System.out.println(truck.solution(bridge_length, weight, truck_weights));
	}

}

class Truck{ // 각 트럭들을 하나의 객체로 만들어서 보자
	
	private int distance;	// truck이 지나갈 거리, distance = bridge_length
	private int weight;	// truck의 무게
	
	// constructor
	public Truck(int weight, int distance){
		setDistance(distance);
		setWeight(weight);
	}
	
	// method
	public void decreaseDistance() {
		setDistance(distance--);
	}
	
	// getters
	public int getDistance() {
		return distance;
	}
	
	public int getWeight() {
		return weight;
	}
	
	// setters
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}