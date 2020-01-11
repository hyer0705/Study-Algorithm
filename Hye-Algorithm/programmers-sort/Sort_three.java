import java.util.Arrays;
import java.util.Collections;

public class Sort_three {

	public static int solution(int[] citations) {
        int answer = 0;
        
        // �������� ������ ���� Integer �迭�� �� ����
        Integer[] arrCitations = new Integer[citations.length];
        for(int i = 0; i < citations.length; i++) {
        	arrCitations[i] = citations[i];
        }
        
        // ���� �ο�� Ƚ���� �������� ����
        Arrays.sort(arrCitations, Collections.reverseOrder());
        
        /* H-INDEX ���
         * 1. �������� ��ǥ ���� ���ο���� ���� ������ ������
         * 2. ������ ���ο���� �������ų� Ȥ�� ������ ���ο������ ���� ������ ����
         * 3. ���� ���� �� �ִ밪�� h-index �̴�!
         * */
        
        // h-index ���� ������ ����
        int max_h = 0;
        for(int i =0; i < arrCitations.length; i++) {
        	// ���ο���� ���� ����
        	int rank = i + 1;
        	if(rank <= arrCitations[i]) {
        		if(max_h < rank) {
        			max_h = rank;
        		}
        	}
        }
        
        answer = max_h;
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		// ���� �ο�� Ƚ���� ����� �迭
		int[] citations = {42, 22};
		
		System.out.println(solution(citations));
	}

}
