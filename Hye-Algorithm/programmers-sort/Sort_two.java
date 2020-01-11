import java.util.Arrays;
import java.util.Comparator;

public class Sort_two {
	public static String solution(int[] numbers) {
		String answer = "";
		
		// 숫자를 더하는 것이 아닌 문자로 더하는 것이므로 string으로 바꿔준다.
		String[] nums = new String[numbers.length];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = String.valueOf(numbers[i]);
		}
		
		// 내가 정한 기준으로 정렬을 하자
		Arrays.sort(nums, new Comparator<String>() {
			@Override
			public int compare(String n1, String n2) {
				if(Integer.parseInt(n1+n2) < Integer.parseInt(n2+n1))
					return 1;
				else if(Integer.parseInt(n1+n2) > Integer.parseInt(n2+n1))
					return -1;
				else
					return 0;
			}
		});
		
		// 만약 nums[0] == 0 이라면 그 숫자는 0 이므로 answer에 "0" 을 저장
		if(nums[0].equals("0"))
			return "0";
		
		// answer 에다가 내가 정렬한 아이들을 넣어줘야함!
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < nums.length; i++) {
			sb.append(nums[i]);
		}
		
		answer = sb.toString();
		
		return answer;
	}
	
	public static void main(String args[]) {
		int[] numbers = {9,1,2,5,7};
		
		System.out.println(solution(numbers));
		
	}
}
