import java.util.PriorityQueue;

public class MoreSpicy {
	
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //배열 -> 우선순위 큐
        for(int s : scoville){
        	pq.add(s);        	
        }
        
        //가장 작은 값 < K
        while(pq.peek() < K && pq.size() > 1){
        	pq.add(pq.poll() + pq.poll() * 2); //가장 작은거 2개 스코빌 공식 대입 후 큐에 삽입
        	answer++;
        }
                
        //스코빌지수를 넘지 못하는 경우 -1 리턴 
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
