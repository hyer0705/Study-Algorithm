import java.util.PriorityQueue;

public class DiskController {
    public static int solution(int[][] jobs) {
    	//Disk 클래스
    	class Disk implements Comparable<Disk>{
			int arrive;
    		int run;
    		
    		public Disk(int arrive, int run){
    			this.arrive = arrive;
    			this.run = run;
    		}
    		
    		@Override
			public int compareTo(Disk target) {//run 기준 정렬
				return this.run>target.run ? 1 : -1; //같을 경우?
			}
    		
			public int getArrive() {
				return arrive;
			}
			
			public int getRun() {
				return run;
			}
    	}
    	
        int answer = 0;
        
        //Disks 초기화
        Disk[] disks = new Disk[jobs.length];
        for(int i=0; i<disks.length; i++){
        	disks[i] = new Disk(jobs[i][0], jobs[i][1]);
        }
        
        //Disks -> 우선순위 큐
        PriorityQueue<Disk> pq_run = new PriorityQueue<>();//run 기준 정렬
        PriorityQueue<Disk> pq_arrive = new PriorityQueue<>(disks.length,
        		(Disk d1, Disk d2) -> d1.getArrive()>= d2.getArrive() ? 1:-1);//arrive기준 정렬

        
        //Disks -> pq_arrive 
        for(Disk d:disks){
        	pq_arrive.add(d);
        }
        
        int total_run = 0;
        int current_time = 0;
        while(!pq_arrive.isEmpty()){
        	//current_time = disk 도착 시간 
        	if(current_time < pq_arrive.peek().getArrive())
        		current_time = pq_arrive.peek().getArrive();
//        	System.out.println("c" + current_time);
//        	System.out.println("s"+pq_arrive.size());
//        	System.out.println("t"+total_run);
        	while(!pq_arrive.isEmpty() && pq_arrive.peek().getArrive() <= current_time){ //도착 디스크들 pq_run에 삽입
//        		System.out.println("체크 : "+ pq_arrive.peek().getRun());
        		pq_run.add(pq_arrive.poll());
//        		System.out.println("r" + pq_run.peek().getArrive());
        	}
        	while(!pq_run.isEmpty()){
//        		System.out.println("hi");
        		current_time += pq_run.peek().getRun(); //런 시간 짧은 디스크 수행
        		total_run += current_time - pq_run.poll().getArrive(); //수행시간 = 완료시간 - 도착시간
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
		
		//위 테스트케이스 전부 성공
		//1~10, 12, 15 실패 why??
		//https://duooo-story.tistory.com/8?category=881766 참고해보기
	}

}
