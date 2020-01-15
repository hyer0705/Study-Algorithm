
public class H_index {
    public static int solution(int[] citations) {
        int answer = 0;
        
        //11, 16¹ø ½ÇÆÐ
        int num = 0;
        while(true){
        	int cited = 0;
        	int i = 0;
        	while(i < citations.length){
        		if(citations[i] >= num){
        			cited++;
        		}
        		i++;
        		if(cited > num)	break;
        	}
        	if(num == cited){
        		answer = num;
        		break;
        	}
        	num++;
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		H_index h = new H_index();
		int[] arr = {3, 0, 6, 1, 5};
		int[] arr2 = {0, 0, 0, 0};
		
		System.out.println(solution(arr2));
	}

}
