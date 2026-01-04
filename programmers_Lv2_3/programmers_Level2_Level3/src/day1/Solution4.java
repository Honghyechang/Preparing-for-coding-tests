package day1;

import java.util.Arrays;

public class Solution4 {
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	Solution4 s=new Solution4();
	s.solution(12345);

}

	public int[] solution(long n) {
	String str=Long.toString(n);
	StringBuilder sb=new StringBuilder(str);
	String changeStr=sb.reverse().toString();
	int answer[]=changeStr.chars()
			 .map(i->i-'0')
			 .toArray();
	//System.out.println(Arrays.toString(answer));
	return answer;
	}
}
