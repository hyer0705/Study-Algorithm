import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
class Graph{
	private ArrayList<ArrayList<Integer>> graph;
	
	public Graph(int n) {
		this.graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
	}
	
	public ArrayList<ArrayList<Integer>> getGraph() {
		return this.graph;
	}
	
	public void put(int x, int y) {
		graph.get(x).add(y);
		graph.get(y).add(x);
	}
	
	public void putOneWay(int x, int y) {
		graph.get(x).add(y);
	}
	
	public int getDepth() {
		int distance = 0;
		int farthest = 0;
		
		ArrayList<Integer> firstNode;
		firstNode = graph.get(1); //1�� ���
		
		ArrayList<Integer> visited = new ArrayList<>();
		
		for(Integer i : firstNode) {
			visited.add(i);
//			System.out.println(i); //3, 2 �湮
			farthest++;   				
		}
		
		
		
//		 ���� ����Ʈ  
//		for(int i=1; i<graph.size(); i++) {
//			System.out.print("���� " + i + "�� ��������Ʈ");
//
//			for(int j=0; j<graph.get(i).size(); j++) {
//                System.out.print(" -> " + graph.get(i).get(j));
//            }
//            System.out.println();
//
//
//			if(graph.get(i).size() > distance) {
//				distance = graph.get(i).size();
//				farthest = 1;
//			} else if(graph.get(i).size() == distance) {
//				farthest++;
//			}
//		}
		
		
		return farthest;
	}
}

Graph gr = new Graph(n);
for(int ed[]:edge) {
	gr.put(ed[0], ed[1]);
}
*/

public class FarthestNode {

	public static int solution(int n, int[][] edge) {
		int answer = 0;
    	int[][]graph = new int[n + 1][n + 1];
//    	boolean[] visited = new boolean[n + 1];
    	//visited ���, distance = -1�� �ʱ�ȭ
    	int[] distances = new int[n + 1];
    	Arrays.fill(distances, -1);
    	
    	
    	//�׷��� �ʱ�ȭ
    	for(int ed[] : edge) {
    		graph[ed[0]][ed[1]] = 1;
    		graph[ed[1]][ed[0]] = 1;
    	}
    	
    	Queue<Integer> q = new LinkedList<>(); 
    	//��� 1 ���� ����
    	int start = 1;
    	//ť�� ��� 1 ����
    	q.add(start);
    	
    	//��� 1 �Ÿ� = 0
    	distances[start] = 0;
    	
    	int farthest = 0; //���� �� ����
    	
    	//�׷��� Ž��
    	while(!q.isEmpty()) {
    		start = q.poll();
    		
    		for(int i=2; i<=n; i++) {
    			if(graph[start][i] == 1 && visited[i] == false) {
    				q.add(i);
    				visited[i] = true;
    				distances[i] = distances[start] + 1;
    				
    				if(distances[i] > farthest) {
    					farthest = distances[i];
    				}
    			}
    		}
    	}
    	
    	//���� �� ���� ��� ��
    	for(int i : distances) {
    		if(i == farthest)
    			answer++;
    	}
    	System.out.println(answer);
    	
        return answer;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		solution(6, vertex);
		
	}

}
