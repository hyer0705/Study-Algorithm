import java.awt.List;
import java.util.ArrayList;

public class DevelopFunction {
    public static int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        int oldLoc = 0;
        
        //100�޼� �ߴ��� üũ
        while(!isDone(progresses)){
        	//100�޼��� �۾� �� ans�� ���� 
        	if(oldLoc!= loc){
        		ans.add(loc - oldLoc);
        	}
        	oldLoc = loc;
        	//������ ����
        	updateArr(progresses, speeds);
        }
        
        ans.add(loc-oldLoc);
        
        //��̸���Ʈ ans -> �迭 answer
        int[] answer = new int[ans.size()];
        
        for(int i=0; i<answer.length; i++){
        	answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
    //100�޼��� �迭 ��ġ
    public static int loc = 0;
    
    //100�޼� üũ
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
    
	//������ ����
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
