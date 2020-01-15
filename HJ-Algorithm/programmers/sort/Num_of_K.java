import java.util.Arrays;

public class Num_of_K {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
        	int[] partialArr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
        	Arrays.sort(partialArr);
        	answer[i] = partialArr[commands[i][2] - 1];
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Num_of_K k = new Num_of_K();
		int[] arr = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		System.out.println(k.solution(arr, commands));

	}

}
