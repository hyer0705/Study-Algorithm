
public class Carpet {
    public static int[] solution(int brown, int red) {
        int[] answer = new int[2];

        for(int i=1; i<=red; i++){
        	if(red % i == 0){
        		int width = i;
        		int height = red/width;
        		//nearTiles = ���� Ÿ�� �ѷ��δ� ���� Ÿ�� ����
        		int nearTiles = width * 2 + height * 2 + 4;
        		if(width >= height && nearTiles == brown){
        			answer[0] = width + 2;//�밢�� 2���� ���ϱ�
        			answer[1] = height + 2;
        			break;
        		}
        	}
        }

        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(10, 2);

//		--------
//		-000000-
//		-000000-
//		-000000-
//		-000000-
//		--------
	}

}
