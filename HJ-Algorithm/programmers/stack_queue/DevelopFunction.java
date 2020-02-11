import java.awt.List;
import java.util.ArrayList;

public class DevelopFunction {
    public static int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        int oldLoc = 0;
        
        //100달성 했는지 체크
        while(!isDone(progresses)){
        	//100달성한 작업 수 ans에 저장 
        	if(oldLoc!= loc){
        		ans.add(loc - oldLoc);
        	}
        	oldLoc = loc;
        	//진행율 증가
        	updateArr(progresses, speeds);
        }
        
        ans.add(loc-oldLoc);
        
        //어레이리스트 ans -> 배열 answer
        int[] answer = new int[ans.size()];
        
        for(int i=0; i<answer.length; i++){
        	answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
    //100달성한 배열 위치
    public static int loc = 0;
    
    //100달성 체크
    public static boolean isDone(int[] arr){
    	loc = 0;
    	for(int i=0; i<arr.length; i++){
    		if(arr[i] < 100){
    			return false;
    		}
    		else{
    			loc = i + 1;
    			System.out.println(i + " " + arr[i]);
    			System.out.println("Loc " + loc);
    		}
    	}
    	
    	return true;
    }
    
	//진행율 증가
    public static void updateArr(int[] progresses, int[] speeds){
    	for(int i=0; i<progresses.length; i++){
    		progresses[i] = progresses[i] + speeds[i];
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {93, 30, 55};
		int[] spd = {1, 30, 5};
		solution(arr, spd);
		
		//Solved
	}

}
