import java.util.Arrays;

public class WayToSchool {
	private static int width, height;
	private static int[][] map;
	
	public static int dp(int m, int n){
		if(m == width-1 && n == height-1) //�б� ����
			return 1;
		if(m == width || n == height || map[n][m] < 0) //�Ʒ�,������ �� ��� ||�칰 
			return 0;

		if(map[n][m] > 0)	return map[n][m]; //�޸������̼�
		
		System.out.println(n + "-" + m);
		return map[n][m] = (dp(m+1, n) + dp(m, n+1)) % 1000000007; //�Ʒ��� �̵�, ���������� �̵�
	}
	
    public static int solution(int m, int n, int[][] puddles) {
    	map = new int[n][m];
    	//height, width �б� ��ǥ 
    	height = n;
    	width = m;
    	//�칰 = -1
    	Arrays.stream(puddles).forEach(v -> map[v[1]-1][v[0]-1] = -1);
        return dp(0, 0);
    }

	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = {{2,2}};
		System.out.println(solution(m, n, puddles));
		
		//Solved
	}

}
