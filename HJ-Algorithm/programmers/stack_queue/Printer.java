import java.util.Stack;

public class Printer {
	
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        
        //ÀÎ¼â ¿äÃ» ¹®¼­
        int objNum = priorities[location];
        //¹è¿­ -> ½ºÅÃ
        Stack<Integer> st = new Stack<>();
        for(int num : priorities){
        	st.add(num);
        }
        
        int count = 0;
        while(hasBigger(st, objNum)){
        	count++;
        }
        
        answer = count + priorities.length - location + 1;
                
        return answer;
    }
    
    public static boolean hasBigger(Object obj, int num){
    	
        Stack<Integer> st = (Stack)obj;
        
    	while(!st.isEmpty()){
    		if(st.pop() > num)
    			return true;
    	}
    	
    	return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 1, 3, 2};
		solution(arr, 2);
		//¹®Á¦ÀÌ»ó  CDAB ¼ø¼­·Î ÀÎ¼â??
		//A(2), B(1), C(3), D(2) -- 0
		//D(2), A(2), B(1), C(3) -- 1
		//D(2), A(2), B(1) -- 2 (C(3) ÀÎ¼â)
		//B(1), D(2), A(2) -- 3
		//B(1), D(2) -- 4  (A(2) ÀÎ¼â)
		//B(1) -- 5 (D(2) ÀÎ¼â)
		// -- 6 (B(1) ÀÎ¼â)
		// --> CADB ¼ø¼­ ÀÎ¼â
	}

}
