
public class IntegerTriangle {
	private static int[][] data;
	private static int[][] sumUp;
	private static int num = 0;
	
	public static int dp(int row, int col){
		if(data.length == row)	//마지막 레벨 도달 시 리턴
			return 0;
		System.out.println(num++ +": "+data[row][col]);
		if(sumUp[row][col] > 0) //메모이제이션
			return sumUp[row][col];
		
		//자기자신 + 자식의 큰 노드 더함
		return sumUp[row][col] = data[row][col] + Math.max(dp(row + 1, col), dp(row + 1, col + 1));
	}
	
    public static int solution(int[][] triangle) {
    	data = triangle;
        sumUp = new int[triangle.length][triangle.length];
        return dp(0, 0);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(triangle));
		
		//Solved

	}

}
