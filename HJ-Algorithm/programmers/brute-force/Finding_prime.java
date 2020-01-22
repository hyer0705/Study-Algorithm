import java.util.ArrayList;
import java.util.List;

public class Finding_prime {
	
	static List<Integer> allNums = new ArrayList();
	static String temp = "";

    static void print(List<Integer> list, boolean[] visited, int n) {
        for(int i=0; i<n; i++) {
            if(visited[i] == true)
            	temp += list.get(i);
        }
        allNums.add(Integer.valueOf(temp));
        temp = "";
    }

	static void combination(List<Integer> list, boolean[] visited, int start, int n, int r) {
	    if(r == 0) {
	        print(list, visited, n);
	        return;
	    } else {
	        for(int i=start; i<n; i++) {
	            visited[i] = true;
	            combination(list, visited, i + 1, n, r - 1);
	            visited[i] = false;
	        }
	    }
	}

	public static int solution(String numbers){
		int answer = 0;
		//숫자
		int number = Integer.valueOf(numbers);				
		//숫자 하나씩 저장 할 배열
		List<Integer> nums = new ArrayList();
		
		int i = 0;
		//숫자 하나씩 쪼개기
		while(number >= 0 && i++ < numbers.length()){
			if(number == 0)
				nums.add(0);
			else
				nums.add(number % 10);
			number = number / 10;
		}
		
		//스트링 숫자 쪼개기 성공 (앞 0포함)
		for(int j:nums)
			System.out.println(j);
		
		
		boolean[] visited = new boolean[nums.size()];
		
		for(int k=1; k<=nums.size(); k++){
			combination(nums, visited, 0, nums.size(), k);
		}
		
		System.out.println();
		System.out.println();
		
		for(int j:allNums)
			System.out.println(j);
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("034120");

	}

}
