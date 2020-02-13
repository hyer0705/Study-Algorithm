package stackOrQueue;


import java.util.LinkedList;
import java.util.Queue;


public class SQ_TruckPassingBridge {

	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        int time = 0; // �ð��� ��Ÿ���� ����
        // Ʈ�� ��ü �迭 ����, truck�� ������ŭ
        Truck[] trucks = new Truck[truck_weights.length];
        
        // �ٸ��� ������ �� truck���� �����ϴ� queue
        Queue<Truck> before = new LinkedList<Truck>();

        // ��ü �ʱ�ȭ �� before�� add
        for(int i = 0; i < truck_weights.length; i++) {
        	trucks[i] = new Truck(truck_weights[i], bridge_length);
        	before.add(trucks[i]); // truck ��ü���� before queue�� add
        }
        
        // �ٸ��� �� �ϴ� Queue ����
        // �ٸ��� ������ �� Ʈ������ ������
        Queue<Truck> bridge = new LinkedList<Truck>();
        
        while(true) {
        	time++; // while���� �ݺ� �Ǹ� time�� ���� 1 ������Ų��
        	
        	// bridge�� �ִ� Ʈ������ �Ÿ� - 1 ���ֱ�
        	for(Truck t : bridge) {
        		t.setDistance(t.getDistance() - 1);
        	}
        	
        	// distance�� 0�� ��� Ȯ��
        	if( !bridge.isEmpty() && bridge.peek().getDistance() == 0) {
        		bridge.remove();
        	}
//        	for(Truck t : bridge) {
//        		if(t.getDistance() == 0) {
//        			System.out.println("Ʈ���� �ٸ��� ������ ���������ϴ�.");
//        			bridge.remove();
//        		}
//        	}
        	
        	if( !bridge.isEmpty() ) { // bridge �� Ʈ���� �ϳ��� �� ���� ��
        		
        		if( !before.isEmpty() ) {
        			// bridge�� �ִ� Ʈ������ ���� ���ϱ�
        			int bridge_truck_weight = 0;
        			
        			for(Truck t : bridge) {
        				bridge_truck_weight += t.getWeight();
        			}
        			
        			// ���� ������ ������ Ʈ���� ����
        			int before_peek_weight = before.peek().getWeight();
        			
        			// ���Ը� ������ �� �ٸ��� ���� ���ѿ� �ɸ��� �ʴ��� Ȯ��
        			if(bridge_truck_weight + before_peek_weight <= weight) {
        				bridge.add(before.remove());
        			}        			
        		}
        		
        	} else { // bridge �� ������� ��
        		if(!before.isEmpty()) {
        			bridge.add(before.remove()); // before�� �ִ� ��� ���� ����� bridge�� add        			
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

class Truck{ // �� Ʈ������ �ϳ��� ��ü�� ���� ����
	
	private int distance;	// truck�� ������ �Ÿ�, distance = bridge_length
	private int weight;	// truck�� ����
	
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