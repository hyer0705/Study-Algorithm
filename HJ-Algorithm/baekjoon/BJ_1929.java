package algorithm;

import java.util.Scanner;

public class BJ_1929 {
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
		String line = sc.nextLine();
		String stNum[] = line.split(" ");

		int num[] = new int[2];
		for(int i=0; i<stNum.length; i++) {
			num[i] = Integer.parseInt(stNum[i]);
		}
		
		for (int i = num[0]; i <= num[1]; i++) {
			if(isPrime(i))
				System.out.println(i);
		}
	}
	
	//시간초과..?
}
