
public class TargetNumber {
	private static int dp(int[] numbers, int target, int sum, int count){
		if(count == numbers.length && sum == target){ //�迭 ���� �� ��� && �� == Ÿ��
			return 1;
		}
		if(count > numbers.length - 1){ //�迭 ���� ��� �ʰ�
			return 0;
		}
		//+,-(����) �����ֱ�
		return dp(numbers, target, sum + numbers[count], count + 1)
			+ dp(numbers, target, sum - numbers[count], count + 1);

	}
	
    public static int solution(int[] numbers, int target) {
        return dp(numbers, target, 0, 0);
    }

	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers, target));
		//Solved

	}

}
