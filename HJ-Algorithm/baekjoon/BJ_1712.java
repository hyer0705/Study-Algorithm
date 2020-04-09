package algorithm;

import java.util.Scanner;

public class BJ_1712 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int fixed = sc.nextInt();
		int origin = sc.nextInt();
		int price = sc.nextInt();
		
		int i = 0;
		
		while (i < 10000000) {
			if (fixed + origin * i < price * i) {
				System.out.println(i);
				return;
			}
			i++;
		}
		
		System.out.println(-1);
	}

}
