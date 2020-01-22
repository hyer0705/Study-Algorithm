package bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Carpet {
	
	public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int width;
        int height;
        for(int i = 1; i <= red; i++) {
        	
        	// i 가 red의 약수일 때
        	if((red % i) == 0) {
        		width = i;
        		height = red / i;
        		int total = width * 2 + height * 2 + 4;
        		
        		if(width >= height && brown == total) {
        			answer[0] = width + 2;
        			answer[1] = height + 2;
        			break;
        		}
        	}
        	
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		Carpet cp = new Carpet();
		int brown = 24;
		int red = 24;
		
		System.out.println(Arrays.toString(cp.solution(brown, red)));
	}

}
