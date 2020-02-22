import java.util.PriorityQueue;

public class DiskController {
    public static int solution(int[][] jobs) {
    	//Disk Ŭ����
    	class Disk implements Comparable<Disk>{
			int arrive;
    		int run;
    		
    		public Disk(int arrive, int run){
    			this.arrive = arrive;
    			this.run = run;
    		}
    		
    		@Override
			public int compareTo(Disk target) {//run ���� ����
				return this.run>target.run ? 1 : -1; //���� ���?
			}
    		
			public int getArrive() {
				return arrive;
			}
			
			public int getRun() {
				return run;
			}
    	}
    	
        int answer = 0;
        
        //Disks �ʱ�ȭ
        Disk[] disks = new Disk[jobs.length];
        for(int i=0; i<disks.length; i++){
        	disks[i] = new Disk(jobs[i][0], jobs[i][1]);
        }
        
        //Disks -> �켱���� ť
        PriorityQueue<Disk> pq_run = new PriorityQueue<>();//run ���� ����
        PriorityQueue<Disk> pq_arrive = new PriorityQueue<>(disks.length,
        		(Disk d1, Disk d2) -> d1.getArrive()>= d2.getArrive() ? 1:-1);//arrive���� ����

        
        //Disks -> pq_arrive 
        for(Disk d:disks){
        	pq_arrive.add(d);
        }
        
        int total_run = 0;
        int current_time = 0;
        while(!pq_arrive.isEmpty()){
        	//current_time = disk ���� �ð� 
        	if(current_time < pq_arrive.peek().getArrive())
        		current_time = pq_arrive.peek().getArrive();
//        	System.out.println("c" + current_time);
//        	System.out.println("s"+pq_arrive.size());
//        	System.out.println("t"+total_run);
        	while(!pq_arrive.isEmpty() && pq_arrive.peek().getArrive() <= current_time){ //���� ��ũ�� pq_run�� ����
//        		System.out.println("üũ : "+ pq_arrive.peek().getRun());
        		pq_run.add(pq_arrive.poll());
//        		System.out.println("r" + pq_run.peek().getArrive());
        	}
        	while(!pq_run.isEmpty()){
//        		System.out.println("hi");
        		current_time += pq_run.peek().getRun(); //�� �ð� ª�� ��ũ ����
        		total_run += current_time - pq_run.poll().getArrive(); //����ð� = �Ϸ�ð� - �����ð�
        	}
        }
        
        answer = total_run/disks.length;
        System.out.println("a"+answer);
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] jobs = {{0,3}, {1,9}, {2,6}};
//		int[][] jobs = {{0,3}, {1,9}, {500, 6}};
//		int[][] jobs = {{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 2}, {15, 34}, {35, 43}, {26, 1}};
		int[][] jobs = {{0, 9}, {0, 4}, {0, 5}, {0, 7}, {0, 3}};
		
		solution(jobs);
		
		//�� �׽�Ʈ���̽� ���� ����
		//1~10, 12, 15 ���� why??
		//https://duooo-story.tistory.com/8?category=881766 �����غ���
	}

}
