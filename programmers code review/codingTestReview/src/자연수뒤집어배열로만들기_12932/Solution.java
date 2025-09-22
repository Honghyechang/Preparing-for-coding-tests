package 자연수뒤집어배열로만들기_12932;

import java.util.Arrays;

public class Solution {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		s.solution(12345);
//
//	}
//	
	public int[] solution(long n) {
	
		StringBuilder sb= new StringBuilder(n+"");
		sb.reverse();
		String str=sb.toString();
		
		int answer[]=new int[str.length()];
		
		for(int i=0; i<str.length(); i++) {
			int m=str.charAt(i)-'0';
			answer[i]=m;
		}
		
		
		System.out.println(Arrays.toString(answer));
		return answer;
	
	}

}
