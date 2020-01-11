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
			
			// �ڿ��� N�� �Է� �޴´�.
			int num = Integer.parseInt(input);
			
			for(int i = 1; i <= num; i++) {
				// ���ڰ� 3�� ���� ������ ������ �����ؾ���
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

//���ڸ� ���� �ڸ�, ���� �ڸ�, ���� �ڸ�, õ�� �ڸ��� ������. �Է¹��� ���ڿ� ���� �迭�� ũ�� �޶���
//int[] jari = new int[String.valueOf(i).length()];
