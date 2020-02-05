import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Sort_one {
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		// commands[0] 의 갯수만큼 반복
		for(int i = 0; i < commands.length; i++) {
			int start = commands[i][0] - 1;
			int end = commands[i][1] - 1;
			int select = commands[i][2] - 1 + start;
			
			// 주소 복사 말고 요소들을 아얘 복사하기
			int[] temp = new int[array.length];
			for(int j = 0; j < array.length; j++) {
				temp[j] = array[j];
			}
			
			// start - end 정렬
			for(int j = start; j < end; j++) {
				for(int k = j + 1; k <= end; k++) {
					int tmp;
					if(temp[j] > temp[k]) {
						tmp = temp[j];
						temp[j] = temp[k];
						temp[k] = tmp;
					}
				}
			}
			
			//answer 채워넣기
			answer[i] = temp[select];
		}
		
		return answer;
	}
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int[] array = {1, 5, 2, 6, 3, 7, 4};
			int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
			
			int[] answer = solution(array, commands);
			for(int i = 0; i < answer.length; i++) {
				bw.write(answer[i] + " ");
			}
			
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
