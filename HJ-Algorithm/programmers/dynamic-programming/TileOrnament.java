
public class TileOrnament {
	static long[] data = new long[100];
	
	public static long fibo(int num){
		//data[1]=2 ���� ����
		if(num < 1)
			return 1;
		
		//�޸������̼�
		if(data[num] != 0){
			return data[num];
		}
		else{
			data[num] = fibo(num - 1) + fibo(num - 2);
			return data[num];
		}
	}
	
    public static long solution(int N) {
        return fibo(N) * 2;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(6);
		
		//Solved

	}

}
