import java.util.PriorityQueue;

public class MoreSpicy {
	
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //�迭 -> �켱���� ť
        for(int s : scoville){
        	pq.add(s);        	
        }
        
        //���� ���� �� < K
        while(pq.peek() < K && pq.size() > 1){
        	pq.add(pq.poll() + pq.poll() * 2); //���� ������ 2�� ���ں� ���� ���� �� ť�� ����
        	answer++;
        }
                
        //���ں������� ���� ���ϴ� ��� -1 ���� 
        return pq.peek() >= K ? answer : -1;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int k = 7;
		System.out.println(solution(scoville, k));
		
		//Solved
	}

}
