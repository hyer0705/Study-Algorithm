/* ���� �ﰢ��
 * memoziation 2���� �迭�� triangle 2���� �迭�� �Ȱ��� ũ��� �����
 * �� ���� ù��° ��� memoziation[i][0] = triangle[i][0] + memozation[i-1][0];
 * �� ���� ������ ��� memoziation[i][memoziation[i].length -1] = triangle[i][memoziation[i].length -1] + memoziation[i-1][memoziation[i].length -2]; 
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
        
        memoziation[0][0] = triangle[0][0]; // ����� ����
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
