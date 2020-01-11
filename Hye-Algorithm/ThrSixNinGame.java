import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ThrSixNinGame {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String input = br.readLine();
			
			// 자연수 N을 입력 받는다.
			int num = Integer.parseInt(input);
			
			for(int i = 1; i <= num; i++) {
				// 숫자가 3이 들어가는 숫자의 조건을 생각해야함
				int tmp = i;
				boolean sam = false;
				while(tmp > 0) {
					if((tmp % 10)%3 == 0 && tmp % 10 != 0) {
						bw.write("-");
						sam = true;
					}
					tmp /= 10;
				}
				bw.write(" ");
				if(!sam) bw.write(i + " ");
			}
			
			bw.flush();
			bw.close();
	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

//숫자를 일의 자리, 십의 자리, 백의 자리, 천의 자리로 나눈다. 입력받은 숫자에 따라 배열의 크기 달라짐
//int[] jari = new int[String.valueOf(i).length()];
