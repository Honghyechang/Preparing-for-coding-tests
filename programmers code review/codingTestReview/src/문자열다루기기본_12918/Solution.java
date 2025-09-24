package 문자열다루기기본_12918;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//Solution s=new Solution();
//s.solution("123456");
//	}
	public boolean solution(String s) {
		
		System.out.println(s.matches("\\d{4}||\\d{6}"));
		return s.matches("\\d{4}||\\d{6}");
	}

}
