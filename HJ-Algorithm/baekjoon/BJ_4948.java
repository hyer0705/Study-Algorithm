package algorithm;

import java.util.Scanner;

public class BJ_4948 {
	public static boolean isPrime(int num) {
		if (num < 1)
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
		
		while(sc.hasNext()) {
			int num = sc.nextInt();
			int numOfPrime = 0;
			for (int i = num; i < num * 2; i++) { //베르트랑 공준
				if (isPrime(i)) {
					numOfPrime++;
				}
			}
			if (numOfPrime != 0)
				System.out.println(numOfPrime);
		}
	}
	//시간초과..?
	//tc 13 -> 3??
	//13, 17, 19, 23 -> 4개
}
