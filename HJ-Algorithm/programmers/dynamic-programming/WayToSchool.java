import java.util.Arrays;

public class WayToSchool {
	private static int width, height;
	private static int[][] map;
	
	public static int dp(int m, int n){
		if(m == width-1 && n == height-1) //학교 도착
			return 1;
		if(m == width || n == height || map[n][m] < 0) //아래,오른쪽 맵 벗어남 ||우물 
			return 0;

		if(map[n][m] > 0)	return map[n][m]; //메모이제이션
		
		System.out.println(n + "-" + m);
		return map[n][m] = (dp(m+1, n) + dp(m, n+1)) % 1000000007; //아래로 이동, 오른쪽으로 이동
	}
	
    public static int solution(int m, int n, int[][] puddles) {
    	map = new int[n][m];
    	//height, width 학교 좌표 
    	height = n;
    	width = m;
    	//우물 = -1
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
