package algorithm;

import java.util.Scanner;

public class BJ_1978 {
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
		int N = sc.nextInt();
		int num[] = new int[N];
		
		for (int i=0; i<N; i++) {
			num[i] = sc.nextInt();
		}
		
		int numOfPrime = 0;
		int i = 0;
		for (int n : num) {
			if (isPrime(n))
				numOfPrime++;
		}
		System.out.println(numOfPrime);
		//Solved.
	}

}
