import java.util.ArrayList;
import java.util.List;

public class Trial_test {
	public static int[] solution(int[] answers){
		int[][] stud = new int[3][];
		//수포자 찍는 방식 배열
		stud[0] = new int[]{1, 2, 3, 4, 5};
		stud[1] = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
		stud[2] = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		//정답 맞춘 갯수 배열
		int[] answer = new int[3];
	
		for(int i=0; i<3; i++){
			int len = stud[i].length;
			for(int j=0; j<answers.length; j++){
				//정답 시 맞춘 갯수 ++
				if(answers[j] == stud[i][j % len]){
					answer[i]++;
				}
			}
		}
		
		//점수 순위 저장 리스트
		List<Integer> list = new ArrayList();
		
		int max = -1;
		for(int i=0; i<3; i++){
			//가장 높은 점수 득점자만 리스트에 저장 (클리어 후 add)
			if(answer[i] > max){
				list.clear();
				list.add(i+1);
				max = answer[i];
			}
			else if(answer[i] == max){ //동점자 있을 경우 다 저장
				list.add(i+1);
			}
		}
		
		//리스트 -> 배열 변환
		int index = 0;
		int[] result = new int[list.size()];
		
		for(int i:list){
			result[index++] = i;
		}
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5};
		solution(arr);

	}

}
