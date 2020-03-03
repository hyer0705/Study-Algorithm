/* Q. 타겟 넘버
 * n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
 * 예를 들어 [1,1,1,1,1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
 * 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어짐
 * 숫자를 적절히 더하고 빼서 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성
 * */

/* dfs() 방법 이용
 * 재귀함수를 이용해서 구현
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
