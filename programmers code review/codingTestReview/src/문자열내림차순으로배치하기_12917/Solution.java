package 문자열내림차순으로배치하기_12917;

import java.util.stream.Collectors;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//Solution s=new Solution();
//s.solution("Zbcdefg");
//	}
	
	public String solution(String s) {
		
		s=s.chars()
		   .boxed()
		   .sorted((a,b)->{
			   return b-a;
		   })
		   .map((i)->(char)i.intValue()+"")
		   .collect(Collectors.joining());
		System.out.println(s);
		   
		   return s;
		
		
	}

}
