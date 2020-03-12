package binary_search;

import java.util.Arrays;

public class SteppingBridge {

	public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        // binary search �� ���� ����
        Arrays.sort(rocks);
        
        // �̺� Ž���� ���� start, end
        // ���� ������ �ּ� �Ÿ��� �̺� Ž������ �˻�!
        int start = 1; // �Ÿ� 1�� ����
        int end = distance; // �Է¹��� distnace ��
        int mid = 0;
        
        // ���� �Է¹��� ������ ������ŭ n�� �Է� �ƴٸ� answer �� distance ���� �Ǿ�߸� �Ѵ�
        if(n == rocks.length) {
        	return distance;
        }
        
        // �̺�Ž�� �ݺ��� - start ���� end ������ �۰ų� ���� ��쿡�� �ݺ�
        while(start <= end) {
        	// start�� end�� �߰��� ��� = ���� ������ �Ÿ��� ����
        	mid = (start + end)/2; 
        	
        	int currentD = 0; // ���� ���̸� ����ϱ� ���� ����, ���� ������� ����(ó������ ������ 0)
        	int removeCnt = 0; // ������ ������ ������ �����ϴ� ����
        	for(int i = 0; i < rocks.length; i++) { // ���� �迭�� ���̸�ŭ �ݺ�
        		
        		// ���� ������ �տ� ����(ó������ ������ 0)���� �Ÿ�
        		int cha = rocks[i] - currentD;
        		
        		// ���� ������ �Ÿ� ���ذ��� mid �� ���� ������ ���� �������� �Ÿ��� ����� cha�� ��
        		// cha�� mid ���� ���� ��쿡�� ������ ����
        		if( cha < mid ) {
        			removeCnt++;
        		} else { // ������ ���� ���� ��� �տ� ������ �Ÿ��� ���ϴ� currentD�� ���� ������ ��ġ�� ����
        			currentD = rocks[i];
        		}
        	}
        	
        	// ������ ���� ������ n ���� ũ�ų� ���� ��� end �� ����
        	if(removeCnt > n) {
        		end = mid - 1;
        	} 
        	// ������ ���� ������ n ���� ���� ��� start �� ����
        	else {
        		start = mid + 1;
        		
        		//answer �� mid �� ����
        		// ���ŵ� ���� ������ ������ �Է¹��� ���� n�� ū ���� �Ű��� ���� �ʴ´�.
        		// n ���� ū ���� ������ �������� �����Ƿ�! ( �Ա� �ɻ�� ���� ���� )
        		answer = mid;
        	}
        }
        
        // test ���
        System.out.println("answer : "+answer);
        System.out.println("start : " + start);
        System.out.println("mid : " + mid);
        System.out.println("end : " + end);
        
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		int distance = 25;
		int[] rocks = {
				2, 14, 11, 21, 17
		};
		int n = 2;
		
		solution(distance, rocks, n);
		
	}
}
