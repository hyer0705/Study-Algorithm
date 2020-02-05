import java.util.Arrays;
import java.util.HashMap;

public class Marathon {

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        String[] sortedParticipant = participant;
        String[] sortedCompletion = completion;
        Arrays.sort(sortedParticipant);
        Arrays.sort(sortedCompletion);
        
        int i = 0;
        for(String p : sortedParticipant){
        	if(!p.equals(sortedCompletion[i++]))
        		return p;
        }

        return sortedParticipant[--i];
    }
    
	public static void main(String[] args) {
		String[] p = {"leo", "kiki", "eden"};
		String[] c = {"eden", "kiki"};
		solution(p, c);
		//Solved
	}

}
