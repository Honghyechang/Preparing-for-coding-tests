package day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution9 {
	public static void main(String[] args) {
	// TODO Auto-generated method stub

	Solution9 s=new Solution9();
	s.solution("01110");

}

public int[] solution (String s) {
	List<Integer> answerList=new ArrayList<Integer>();
	
	int change=0;
	int zero=0;
	
	while(!s.equals("1")) {
		change++;
		int beforeLength=s.length();
		s=s.replaceAll("0+", "");
		int afterLength=s.length();
		
		zero+=beforeLength-afterLength;
	
		s=Integer.toString(afterLength, 2);
		
		
	}
	int answer[]=new int[] {change,zero};
	System.out.println(Arrays.toString(answer));
	return answer;
}
}
