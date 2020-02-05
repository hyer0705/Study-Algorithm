import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Disguise {
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();
        //key = ��� Ÿ��, value = ��� Ÿ�Ժ� ����
        for(String[] item : clothes){
        	hm.put(item[1], hm.getOrDefault(item[1], 0) + 1);
        }
        
        //������ ���� �� = (��� Ÿ�Ժ� ���� + 1)�� �� - 1 
        Iterator it = hm.values().iterator();
        while(it.hasNext()){
        	Integer i = (Integer)it.next();
        	answer *= (i.intValue() + 1);
        }
        
        return answer - 1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Solved

	}
}
