import java.util.Arrays;
import java.util.Comparator;

public class BFSExam1 {

	public int[] solution(int[] answers) {
		// 학생들이 맞은 값들 저장
        int[][] tempjumsu = {
        		{1,0},
        		{2,0},
        		{3,0},
        };
        
        // 학생들의 찍는 답
        int[][] studentAns = {
        		{1,2,3,4,5},
        		{2,1,2,3,2,4,2,5},
        		{3,3,1,1,2,2,4,4,5,5}
        };
        
        for(int i = 0; i < studentAns.length; i++) {
        	int tag = 0;
            int jumsu = 0;
            
            // 점수 계산
        	for(int j = 0; j < answers.length; j++) {
        		if(j == studentAns[i].length) {
        			tag = 0;
        		}
        		if(answers[j] == studentAns[i][tag]) {
        			jumsu++;
        		}
        		tag++;
        	}
        	tempjumsu[i][1] = jumsu;
        }
        
        Arrays.sort(tempjumsu, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] entry1,int[] entry2) {
        		int time1 = entry1[1];
        		int time2 = entry2[1];
        		return Integer.compare(time2, time1);
        	}
		});
        
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0; i < tempjumsu.length; i++) {
        	if(tempjumsu[i][1] != 0) {
        		sb.append(tempjumsu[i][0]);
        	}
        }
        
        String[] arrStr = sb.toString().split("");
        
        
        int[] answer = new int[arrStr.length];
        
        for(int i = 0; i < arrStr.length; i++) {
        	answer[i] = Integer.parseInt(arrStr[i]);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		
		BFSExam1 bfs = new BFSExam1();
		
		int[] answers = {1,2,3,4,5};
		
		int[] answer = bfs.solution(answers);
		System.out.println(Arrays.toString(answer));
	}

}
