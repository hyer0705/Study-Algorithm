import java.util.Arrays;
import java.util.Comparator;

public class Sort_two {
	public static String solution(int[] numbers) {
		String answer = "";
		
		// ���ڸ� ���ϴ� ���� �ƴ� ���ڷ� ���ϴ� ���̹Ƿ� string���� �ٲ��ش�.
		String[] nums = new String[numbers.length];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = String.valueOf(numbers[i]);
		}
		
		// ���� ���� �������� ������ ����
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
		
		// ���� nums[0] == 0 �̶�� �� ���ڴ� 0 �̹Ƿ� answer�� "0" �� ����
		if(nums[0].equals("0"))
			return "0";
		
		// answer ���ٰ� ���� ������ ���̵��� �־������!
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
