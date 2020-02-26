package dynamic_programming;

/* Ÿ�� ��Ĺ�
 * �Ǻ���ġ������ �̿��Ͽ� ���� �ذ�
 * Bottom-up �̿�
 * 	���� ������ Ǯ�鼭 ū ������ ���� ����
 * 
 * N���� Ÿ���� �־����� 1��°�� 2��° Ÿ���� ������ 1�̶�� ������ ���簢��
 * �� ���� ���簢���� �� ���� ���̴� �տ� �� Ÿ���� ���̸� ���� ��
 * 
 * N���� Ÿ���� ���� ���� ���簢���� �ѷ� = 2 * (���� ū Ÿ���� �� ���� ���� + (���� ū Ÿ���� �� ���� ���� + �� ��°�� ū Ÿ���� �� ���� ����))
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
		final int N = 5; // ���
		
		System.out.println("answer : " + solution(N));
	}
}
