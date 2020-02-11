
public class Tower {
    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        
        for(int i=heights.length-1; i>=1; i--){
        	for(int j=i-1; j>=0; j--){
        		if(heights[j] > heights[i]){
        			answer[i] = j + 1;
        			break;
        		}
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6,9,5,7,4};
		solution(arr);
		
		//Solved

	}

}
