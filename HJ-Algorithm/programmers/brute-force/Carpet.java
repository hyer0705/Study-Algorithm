
public class Carpet {
    public static int[] solution(int brown, int red) {
        int[] answer = new int[2];

        for(int i=1; i<=red; i++){
        	if(red % i == 0){
        		int width = i;
        		int height = red/width;
        		//nearTiles = 빨간 타일 둘러싸는 갈색 타일 갯수
        		int nearTiles = width * 2 + height * 2 + 4;
        		if(width >= height && nearTiles == brown){
        			answer[0] = width + 2;//대각선 2개씩 더하기
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
