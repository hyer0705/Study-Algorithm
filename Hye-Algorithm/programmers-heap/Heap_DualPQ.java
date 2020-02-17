package heap;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Double Ended Priority Queue 구현 후 사용 (greeks for greeks 참고)

class DbEndedPQ{
	
	// === member filed ===
	public Set<Integer> s;
	
	// === constructor ===
	public DbEndedPQ() {
		s = new HashSet<Integer>();
	}
	
	// === method ===
	public int size() {
		return s.size();
	}
	
	public boolean isEmpty() {
		return (s.size() == 0);
	}
	
	public void insert(int x) {
		s.add(x);
	}
	
	public int getMin() {
		return Collections.min(s, null);
	}
	
	public int getMax() {
		return Collections.max(s, null);
	}
	
	public void deleteMin() {
		if(s.size() == 0) {
			return;
		}
		s.remove(Collections.min(s, null));
	}
	
	public void deleteMax() {
		if(s.size() == 0) {
			return;
		}
		s.remove(Collections.max(s, null));
	}
	
	public String toString() {
		return s.toString();
	}
}

public class Heap_DualPQ {
	
	public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        // double ended priority queue
        DbEndedPQ pq = new DbEndedPQ();
        
        String[][] test = new String[operations.length][2];
        
        for(int i = 0; i < test.length; i++) {
        	
        	test[i] = operations[i].split(" ");
        }
        
        for(int i = 0; i < test.length; i++) {
        	
        	for(int j = 0; j < test[i].length; j++) {
        		System.out.print(test[i][j] + " ");
        	}
        	System.out.println();
        }
        System.out.println();
        
        for(int i = 0; i<test.length; i++) {
        	if(test[i][0].equals("I")) { // test[i][0] == "I"
        		int inputNum = Integer.parseInt(test[i][1]);
        		pq.insert(inputNum);
        	} else { // test[i][0] == "D"
        		if(test[i][1].equals("1")) { // test[i][1] == "1" 최댓값 제거
        			pq.deleteMax();
        		}else { // test[i][1] == "-1" 최솟값 제거
        			pq.deleteMin();
        		}
        	}
        }
        
        System.out.println(pq.toString());
        
        if(pq.isEmpty()) {
        	answer[0] = 0;
        	answer[1] = 0;
        } else {
        	answer[0] = pq.getMax();
        	answer[1] = pq.getMin();
        }
        
        return answer;
    }

	public static void main(String[] args) {
		
		Heap_DualPQ dual = new Heap_DualPQ();
		
		String[] operations = {
				"I 7",
				"I 5",
				"I -5",
				"D -1"
		};
		
		System.out.println(Arrays.toString(dual.solution(operations)));
	}
}
