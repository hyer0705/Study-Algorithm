package dynamic_programming;

/* 타일 장식물
 * 피보나치수열을 이용하여 문제 해결
 * Bottom-up 이용
 * 	작은 문제를 풀면서 큰 문제의 답을 구함
 * 
 * N개의 타일이 주어지면 1번째는 2번째 타일은 무조건 1이라는 길이의 정사각형
 * 그 다음 정사각형의 한 변의 길이는 앞에 두 타일의 길이를 합한 값
 * 
 * N개의 타일을 통해 만든 직사각형의 둘레 = 2 * (가장 큰 타일의 한 변의 길이 + (가장 큰 타일의 한 변의 길이 + 두 번째로 큰 타일의 한 변의 길이))
 * */

public class TileOrnament {
	
	
	public static long solution(int N) {
        long[] tile = new long[N];
        tile[0] = 1;
        tile[1] = 1;
        
        for(int i = 2; i < N; i++) { 
        	tile[i] = tile[i - 2] + tile[i - 1];
        }
        
        return (tile[tile.length - 1] + tile[tile.length - 2] + tile[tile.length - 1]) * 2;
    }
	
	public static void main(String[] args) {
		final int N = 5; // 상수
		
		System.out.println("answer : " + solution(N));
	}
}
