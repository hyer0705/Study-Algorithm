package algorithm;

import java.util.Scanner;

public class BJ_2581 {
	public static boolean isPrime(int num) {
		if (num < 2)
			return false;
		
		for (int i=2; i<num; i++) {
			if (num % i == 0)
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int sum = 0;
		int min = 0;
		boolean findingMin = true;
		
		for (int i = M; i <= N; i++) {
			if (isPrime(i)) {
				sum += i;
				if(findingMin) {
					min = i;
					findingMin = false;
				}
			}
		}
		
		if(sum == 0) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(sum);
		System.out.println(min);
		//Solved.
	}
}
