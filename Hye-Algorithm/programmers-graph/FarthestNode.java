package graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

// geeks for geeks bfs 알고리즘 참고
class Graph{
	// ** 정점 = vertex, 간선 = edge
	private int V; // 정점들의 수
	private LinkedList<Integer> adj[]; // 인접 리스트, 각 노드들에 인접한 노드들을 저장하는 리스트
	private int[] cnt; // 시작 정점부터 해당 노드까지 간선의 갯수를 저장하는 배열
	
	// === constructor ===
	public Graph(int v) { // 정점의 수를 인자로 받아서 정점들의 수를 초기화
		V = v + 1;
		adj = new LinkedList[v + 1]; // 정점들의 갯수만큼 리스트 배열 초기화
		for(int i = 0; i < v + 1; ++i) {
			adj[i] = new LinkedList<Integer>(); // 각 리스트 배열의 요소를 링크드 리스트로 초기화!
		}
		cnt = new int[v+1]; // 정점의 갯수보다 1 큰 숫자만큼 초기화 이유? 
							// 정점이 1 부터 시작하므로 배열의 인덱스와 맞춰주기 위해서
	}
	
	// Function to add an edge into the graph
	public void addEdge(int v, int w) {
		adj[v].add(w); // v 인접리스트에 w 노드 추가
	}
	
	// prints BFS traversal from a given source s
	public void BFS(int s) { // s 인자는 start vertex를 뜻함!
		boolean visited[] = new boolean[V]; // 각 vertex 들의 방문 여부를 나타내는 배열 false로 초기화
		
		Queue<Integer> queue = new LinkedList<Integer>(); // bfs를 구현하기 위한 큐
		
		visited[s] = true; // 시작 vertex 방문했다고 true 대입
		queue.add(s); // 시작 vertex를 큐에 add
		
		int current; // 큐에서 빼낸 현재 vertex를 의미
		while(queue.size() != 0) { // queue가 빌 때까지 반복!
			
			current = queue.poll(); // queue의 헤드 값을 빼와서 current 변수에 저장 
//			System.out.print(s + " ");
			
			// 리스트의 모든 요소를 조회하기 위한 iterator!
			// iterator는 자바의 collections 를 인덱스 값 없이 순서대로 조회할 수 있게 해준다.
			// current 변수에 저장되어 있는 vertex 의 인접리스트를 사용
			Iterator<Integer> iter = adj[current].listIterator();
			
			// 다음 요소가 있을 때까지 반복
			while(iter.hasNext()) {
				
				// 인접리스트에서 빼온 값을 n 변수에 저장
				int n = iter.next();
				
				// 방문 배열이 false 값일 때 이 vertex는 방문하지 않은 것을 뜻함!
				if(!visited[n]) {
					cnt[n] = cnt[current] + 1; // start vertex로 부터 현재 vertex 까지의 간선의 갯수를 더해준다
					visited[n] = true; // 방문했다고 true로 대입
					queue.add(n); // 큐에 넣어줌!
				}
			}
		}
		
	}
	
	// cnt 배열을 반환
	public int[] getCnt() {
		return cnt;
	}
}

public class FarthestNode {

	public static int solution(int n, int[][] edge) {
        int answer = 0;
        
        Graph graph = new Graph(n);
        
        for(int i = 0; i < edge.length; i++) {
        	graph.addEdge(edge[i][0], edge[i][1]);
        	graph.addEdge(edge[i][1], edge[i][0]);
        }
        
        graph.BFS(1);
        
        int[] cnt = graph.getCnt();
        
        Arrays.sort(cnt);
        int max = cnt[cnt.length - 1];
        
        for(int i = 1; i < cnt.length; i++) {
        	if(cnt[i] == max) {
        		answer++;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		int n = 6;
		int[][] vertex = {
				{3,6},
				{4,3},
				{3,2},
				{1,3},
				{1,2},
				{2,4},
				{5,2}
		};
		
		System.out.println(solution(n, vertex));
		
	}
}
