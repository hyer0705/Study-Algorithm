/* 정수 삼각형
 * memoziation 2차원 배열을 triangle 2차원 배열과 똑같은 크기로 만든다
 * 각 행의 첫번째 요소 memoziation[i][0] = triangle[i][0] + memozation[i-1][0];
 * 각 행의 마지막 요소 memoziation[i][memoziation[i].length -1] = triangle[i][memoziation[i].length -1] + memoziation[i-1][memoziation[i].length -2]; 
 * memoziation[i][j] = triangle[i][j] + Math.max(memoziation[i-1][j-1], memoziation[i-1][j]);
 * */

package dynamic_programming;

public class IntTriangle {

	public static int solution(int[][] triangle) {
        int answer = 0;
        int[][] memoziation = new int[triangle.length][];
        for(int i = 0; i < memoziation.length; i++) {
        	memoziation[i] = new int[triangle[i].length];
        }
        
        memoziation[0][0] = triangle[0][0]; // 꼭대기 저장
        for(int i = 1; i < memoziation.length; i++) {
        	for(int j = 0; j < memoziation[i].length; j++) {
        		if(j == 0) {
        			memoziation[i][j] = memoziation[i-1][j] + triangle[i][j];
        		}else if(j == memoziation[i].length - 1) {
        			memoziation[i][j] = memoziation[i-1][j - 1] + triangle[i][j];
        		}else {
        			memoziation[i][j] = triangle[i][j] + Math.max(memoziation[i-1][j-1], memoziation[i-1][j]);
        		}
        	}
        }
        
        for(int i = 0; i < memoziation[memoziation.length-1].length; i++) {
        	if(answer < memoziation[memoziation.length - 1][i]) {
        		answer = memoziation[memoziation.length - 1][i];
        	}
        }

        System.out.println(answer);
        return answer;
    }
	
	public static void main(String[] args) {
		
		int[][] triangle = {
			{7},
			{3, 8},
			{8, 1, 0},
			{2, 7, 4, 4},
			{4, 5, 2, 6, 5}
		};
		
		solution(triangle);
	}
}
