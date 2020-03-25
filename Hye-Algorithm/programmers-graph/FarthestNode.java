package graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

// geeks for geeks bfs �˰��� ����
class Graph{
	// ** ���� = vertex, ���� = edge
	private int V; // �������� ��
	private LinkedList<Integer> adj[]; // ���� ����Ʈ, �� ���鿡 ������ ������ �����ϴ� ����Ʈ
	private int[] cnt; // ���� �������� �ش� ������ ������ ������ �����ϴ� �迭
	
	// === constructor ===
	public Graph(int v) { // ������ ���� ���ڷ� �޾Ƽ� �������� ���� �ʱ�ȭ
		V = v + 1;
		adj = new LinkedList[v + 1]; // �������� ������ŭ ����Ʈ �迭 �ʱ�ȭ
		for(int i = 0; i < v + 1; ++i) {
			adj[i] = new LinkedList<Integer>(); // �� ����Ʈ �迭�� ��Ҹ� ��ũ�� ����Ʈ�� �ʱ�ȭ!
		}
		cnt = new int[v+1]; // ������ �������� 1 ū ���ڸ�ŭ �ʱ�ȭ ����? 
							// ������ 1 ���� �����ϹǷ� �迭�� �ε����� �����ֱ� ���ؼ�
	}
	
	// Function to add an edge into the graph
	public void addEdge(int v, int w) {
		adj[v].add(w); // v ��������Ʈ�� w ��� �߰�
	}
	
	// prints BFS traversal from a given source s
	public void BFS(int s) { // s ���ڴ� start vertex�� ����!
		boolean visited[] = new boolean[V]; // �� vertex ���� �湮 ���θ� ��Ÿ���� �迭 false�� �ʱ�ȭ
		
		Queue<Integer> queue = new LinkedList<Integer>(); // bfs�� �����ϱ� ���� ť
		
		visited[s] = true; // ���� vertex �湮�ߴٰ� true ����
		queue.add(s); // ���� vertex�� ť�� add
		
		int current; // ť���� ���� ���� vertex�� �ǹ�
		while(queue.size() != 0) { // queue�� �� ������ �ݺ�!
			
			current = queue.poll(); // queue�� ��� ���� ���ͼ� current ������ ���� 
//			System.out.print(s + " ");
			
			// ����Ʈ�� ��� ��Ҹ� ��ȸ�ϱ� ���� iterator!
			// iterator�� �ڹ��� collections �� �ε��� �� ���� ������� ��ȸ�� �� �ְ� ���ش�.
			// current ������ ����Ǿ� �ִ� vertex �� ��������Ʈ�� ���
			Iterator<Integer> iter = adj[current].listIterator();
			
			// ���� ��Ұ� ���� ������ �ݺ�
			while(iter.hasNext()) {
				
				// ��������Ʈ���� ���� ���� n ������ ����
				int n = iter.next();
				
				// �湮 �迭�� false ���� �� �� vertex�� �湮���� ���� ���� ����!
				if(!visited[n]) {
					cnt[n] = cnt[current] + 1; // start vertex�� ���� ���� vertex ������ ������ ������ �����ش�
					visited[n] = true; // �湮�ߴٰ� true�� ����
					queue.add(n); // ť�� �־���!
				}
			}
		}
		
	}
	
	// cnt �迭�� ��ȯ
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
