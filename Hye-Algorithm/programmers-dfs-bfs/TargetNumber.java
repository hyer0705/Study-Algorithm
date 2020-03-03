/* Q. Ÿ�� �ѹ�
 * n���� ���� �ƴ� ������ �ֽ��ϴ�. �� ���� ������ ���ϰų� ���� Ÿ�� �ѹ��� ������� �մϴ�.
 * ���� ��� [1,1,1,1,1]�� ���� 3�� ������� ���� �ټ� ����� �� �� �ֽ��ϴ�.
 * ����� �� �ִ� ���ڰ� ��� �迭 numbers, Ÿ�� �ѹ� target�� �Ű������� �־���
 * ���ڸ� ������ ���ϰ� ���� �ѹ��� ����� ����� ���� return �ϵ��� solution �Լ��� �ۼ�
 * */

/* dfs() ��� �̿�
 * ����Լ��� �̿��ؼ� ����
 * 	   							  0										depth = 0
 *					|/							\|
 *		(root+numbers[0])					(root-numbers[0])			depth = 1
 *			|/		\|							|/		\|
 *(root+numbers[1])	(root-numbers[1])(root+numbers[1])(root-numbers[1])	depth = 2
 * */

package dfs_bfs;

public class TargetNumber {
	
	private static int dfs(int[] numbers, int depth, int sum, int target) {
		if(depth == numbers.length) {
			if(sum == target) {
				return 1;
			}
			return 0;
		}
		return dfs(numbers, depth + 1, sum + numbers[depth], target) + 
				dfs(numbers, depth + 1, sum - numbers[depth], target);
	}
	
	public static int solution(int[] numbers, int target) {
        int answer = dfs(numbers, 0, 0, target);
		return answer;
    }
	
	public static void main(String[] args) {
		
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		
		System.out.println(solution(numbers, target));
		
	}
}
